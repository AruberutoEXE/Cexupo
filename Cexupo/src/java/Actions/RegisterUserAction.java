/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import DAO.UsuarioDao;
import Hibernate.Usuario;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;

/**
 *
 * @author agarc
 */
public class RegisterUserAction extends ActionSupport {
    private String username;
    private String password;
    private String email;
    public RegisterUserAction() {
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
       String salida;
        Usuario newUser = new Usuario(this.getUsername(), this.getPassword(),this.getEmail());
        if(UsuarioDao.userExiste(this.getEmail())){
            addFieldError("email", "There is already a user associated with the Email");
            salida = ERROR;
        }else{
        UsuarioDao.createUser(newUser);
        Map session = (Map) ActionContext.getContext().get("session");
        session.put("username", newUser); 
        
        salida= SUCCESS;
        }
        return salida;
    }
    
}
