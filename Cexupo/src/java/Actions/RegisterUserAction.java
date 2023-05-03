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
import java.util.regex.Matcher;//Class - Used to search for the pattern
import java.util.regex.Pattern;//Class - Defines a pattern (to be used in a search)

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
        String salida = SUCCESS;
        Usuario newUser = new Usuario(this.getUsername(), this.getPassword(), this.getEmail());
        if (UsuarioDao.userExiste(this.getEmail())) {
            addFieldError("email", "Ya existe un usuario asociado al email introducido");
            salida = ERROR;
        } else {
            UsuarioDao.createUser(newUser);
            Map session = (Map) ActionContext.getContext().get("session");
            session.put("usuario", newUser);
        }
         return salida;
    }
    public void validate(){
        String patronEmail = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$";
        Pattern patron = Pattern.compile(patronEmail);
        Matcher matcher = patron.matcher(this.getEmail());
        
        if(this.getUsername().equals("")){
            addFieldError("username","El nombre de usuario es obligatorio");
        }else if(this.getUsername().length() < 2){
            addFieldError("username","El nombre de usuario debe tener 2 o más caracteres");
        }
        if(this.getPassword().equals("")){
            addFieldError("password","La contraseña es obligatoria");
        }else if(this.getPassword().length() < 8){
            addFieldError("password","La contraseña debe tener un minimo de 8 caracteres");
        }
        if(this.getEmail().equals("")){
            addFieldError("email","El email es obligatorio");
        }else if(!matcher.matches()){
            addFieldError("email","El formato de email es incorrecto");
        }
        
    }
   
}
