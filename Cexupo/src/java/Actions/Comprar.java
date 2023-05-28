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

    List<String> direcciones;
    List<String> transportes;
    List<String> pagos;

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
            //dir.add(paylist.get(i).getNombre());
        }
        direcciones = dir;
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

}
