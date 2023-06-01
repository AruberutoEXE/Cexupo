/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import DAO.UsuarioDao;
import Hibernate.Metodopago;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author agarc
 */
public class CreateMethodPay extends ActionSupport implements SessionAware{
    private String nombre;
     private String detalles;
private SessionMap<String, Object> sessionMap;

    public SessionMap<String, Object> getSessionMap() {
        return sessionMap;
    }

    public void setSessionMap(SessionMap<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }
    public CreateMethodPay() {
    }
    
    public String execute() throws Exception {
        String idUsuario = (String)sessionMap.get("username");
        Metodopago newMet = new Metodopago();
        newMet.setDetalles(detalles);
        newMet.setIdUsuario(idUsuario);
        newMet.setNombre(nombre);
       UsuarioDao udao= new UsuarioDao();
       udao.createMetodoPago(newMet);
        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> map) {
     sessionMap = (SessionMap) map;
    }
    
}
