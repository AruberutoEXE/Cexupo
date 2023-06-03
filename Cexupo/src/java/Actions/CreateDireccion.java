/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import DAO.UsuarioDao;
import Hibernate.Direccion;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author agarc
 */
public class CreateDireccion extends ActionSupport implements SessionAware{
  
    private String nombreD;
    private int cp;
    private String direccion;
   
    private SessionMap<String, Object> sessionMap;

    public String getNombreD() {
        return nombreD;
    }

    public void setNombreD(String nombreD) {
        this.nombreD = nombreD;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

   

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
    
    public CreateDireccion() {
    }
    
    public String execute() throws Exception {
        String idUsuario = (String)sessionMap.get("username");
        Direccion newDir = new Direccion();
        newDir.setCp(cp);
        newDir.setDireccion(direccion);
        newDir.setIdUsuario(idUsuario);
        newDir.setNombre(nombreD);
       UsuarioDao udao= new UsuarioDao();
       udao.createDireccion(newDir);
        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> map) {
       sessionMap = (SessionMap) map;
    }
    
}
