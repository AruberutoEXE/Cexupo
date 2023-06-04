/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import DAO.UsuarioDao;
import usuarioService.Usuario;
import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author agarc
 */
public class ModifyUser extends ActionSupport {
    private String username;
     private String password;
     private String email;
     private String user;
    public ModifyUser() {
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
    
    public String execute() throws Exception {
       UsuarioDao uDao = new UsuarioDao();
       Usuario u = uDao.getUser(user);
       if(!this.username.equals(u.getUsername())){
           u.setUsername(username);
       }
       if(!this.email.equals(u.getEmail())){
           u.setEmail(email);
       }
       if(!this.password.equals(u.getPassword())){
           u.setPassword(password);
       }
       uDao.updateUser(u);
       return SUCCESS;
    }
    
}
