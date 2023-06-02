/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import DAO.UsuarioDao;
import DAO.VentaDao;
import Hibernate.Usuario;
import Hibernate.Venta;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;
import java.util.Map;
import org.apache.struts2.dispatcher.SessionMap;

import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author alber
 */
public class FianlizarCompra extends ActionSupport implements SessionAware {

    public FianlizarCompra() {
    }
    private String direccion;
    private String transporte;
    private String pago;
    private String idProducto;

    private SessionMap<String, Object> sessionMap;

    public String execute() throws Exception {
        try {
            VentaDao vdao = new VentaDao();
            Venta v = new Venta();

            v.setIdDireccion(Long.parseLong(direccion));
            v.setIdMetodoPago(Long.parseLong(pago));
            v.setIdTarifa(Long.parseLong(transporte));
            UsuarioDao udao = new UsuarioDao();
            Usuario usu = udao.getUser((String) sessionMap.get("username"));
            v.setIdUsuario(usu.getUsername());
            v.setFechaVenta(new Date());
            v.setIdProducto(Long.parseLong(idProducto));

            vdao.addVenta(v);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return ERROR;
        }
        return SUCCESS;

    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTransporte() {
        return transporte;
    }

    public void setTransporte(String transporte) {
        this.transporte = transporte;
    }

    public String getPago() {
        return pago;
    }

    public void setPago(String pago) {
        this.pago = pago;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap) map;
    }

}
