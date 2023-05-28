/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import DAO.ProductoDao;
import DAO.UsuarioDao;
import Hibernate.Direccion;
import Hibernate.Metodopago;
import Hibernate.Tarifaenvio;
import Hibernate.Usuario;
import com.opensymphony.xwork2.ActionSupport;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author alber
 */
public class Comprar extends ActionSupport implements SessionAware {

    private SessionMap<String, Object> sessionMap;

    public Comprar() {
    }

    private String producto;

    private List<String> direcciones;
    private List<String> transportes;
    private List<String> pagos;
    
    private String idProducto;
    public String execute() throws Exception {
        ProductoDao pdao = new ProductoDao();
        List<String> tarifas = new LinkedList<String>();
        List<Tarifaenvio> t = pdao.getAllTarifas();
        for (int i = 0; i < t.size(); i++) {
            tarifas.add(t.get(i).getNombreTarifa());
        }
        transportes = tarifas;

        UsuarioDao udao = new UsuarioDao();
        List<String> dir = new LinkedList<String>();
        Usuario usu=udao.getUser((String)sessionMap.get("username"));
        List<Direccion> dirlist = udao.getAllUserDirections(usu);
        for (int i = 0; i < dirlist.size(); i++) {
            dir.add(dirlist.get(i).getNombre());
        }
        direcciones = dir;
        
        List<String> pay = new LinkedList<String>();
        List<Metodopago> paylist = udao.getAllUserPayMethods(usu);
        for (int i = 0; i < paylist.size(); i++) {
            pay.add(paylist.get(i).getNtarjeta());
        }
        direcciones = pay;
        return SUCCESS;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap) map;
    }

    public List<String> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(List<String> direcciones) {
        this.direcciones = direcciones;
    }

    public List<String> getTransportes() {
        return transportes;
    }

    public void setTransportes(List<String> transportes) {
        this.transportes = transportes;
    }

    public List<String> getPagos() {
        return pagos;
    }

    public void setPagos(List<String> pagos) {
        this.pagos = pagos;
    }


    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }


}
