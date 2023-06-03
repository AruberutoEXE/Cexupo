/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import DAO.UsuarioDao;
import Hibernate.Usuario;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;

/**
 *
 * @author agarc
 */
public class DetalleUsuario extends ActionSupport {
    private String username;
     private String password;
     private String email;
     private String usuario;
     

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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
        Usuario u = udao.getUser(usuario);
        username = u.getUsername();
        email = u.getEmail();
        password = u.getPassword();
        return SUCCESS;
    }
    
}
