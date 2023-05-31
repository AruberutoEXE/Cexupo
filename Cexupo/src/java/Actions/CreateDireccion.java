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
  
    private String nombre;
    private String cp;
    private String direccion;
   
    private SessionMap<String, Object> sessionMap;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
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
       try{
           String idUsuario = (String)sessionMap.get("username");
        System.out.println("entra: " + idUsuario + ".."+ direccion +  ".." + cp + ".." + nombre );
        Direccion newDir = new Direccion(this.direccion, Integer.parseInt(cp), this.nombre,idUsuario);
       UsuarioDao udao= new UsuarioDao();
       udao.createDireccion(newDir);
       }catch(NumberFormatException e){
           return ERROR;
       }
        
        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> map) {
       sessionMap = (SessionMap) map;
    }
    
}
