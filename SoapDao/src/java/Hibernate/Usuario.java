package Hibernate;
// Generated 30-may-2023 15:55:56 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Usuario generated by hbm2java
 */
public class Usuario  implements java.io.Serializable {


     private String username;
     private String password;
     private String email;
     private Set productos = new HashSet(0);

    public Usuario() {
    }

	
    public Usuario(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
    public Usuario(String username, String password, String email, Set productos) {
       this.username = username;
       this.password = password;
       this.email = email;
       this.productos = productos;
    }
   
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public Set getProductos() {
        return this.productos;
    }
    
    public void setProductos(Set productos) {
        this.productos = productos;
    }




}

