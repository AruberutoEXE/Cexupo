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
import java.util.Map;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author alber
 */
public class ModificarVenta extends ActionSupport implements SessionAware{
    
    private String direccion;
    private String transporte;
    private String pago;
    private String id;
    
     private SessionMap<String, Object> sessionMap;
    public ModificarVenta() {
    }
    
    public String execute() throws Exception {
        
        try {
            VentaDao vdao=new VentaDao();
            String usu = (String) sessionMap.get("username");
            Venta v=vdao.getVenta(usu, id);
            direccion = direccion.replaceAll("[^\\w+]", "");
            pago = pago.replaceAll("[^\\w+]", "");
            transporte = transporte.replaceAll("[^\\w+]", "");
            v.setIdDireccion(Long.parseLong(direccion));
            v.setIdMetodoPago(Long.parseLong(pago));
            v.setIdTarifa(Long.parseLong(transporte));
            vdao.updateVenta(v);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return ERROR;
        }
        
        return SUCCESS;
    }

     @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap) map;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
