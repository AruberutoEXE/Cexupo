/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import DAO.UsuarioDao;
import usuarioService.Usuario;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author agarc
 */
public class DetalleUsuario extends ActionSupport implements SessionAware{
    private String username;
     private String password;
     private String email;
     private String usuario;
     private SessionMap<String, Object> sessionMap;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public SessionMap<String, Object> getSessionMap() {
        return sessionMap;
    }

    public void setSessionMap(SessionMap<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
     
    public DetalleUsuario() {
    }
    
    public String execute() throws Exception {
        UsuarioDao udao= new UsuarioDao();
        Usuario u=udao.getUser((String)sessionMap.get("username"));
        username = u.getUsername();
        email = u.getEmail();
        password = u.getPassword();
        return SUCCESS;
    }
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap) map;
    }
}
