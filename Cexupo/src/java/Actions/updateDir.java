/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author agarc
 */
public class updateDir extends ActionSupport {
    private String nombre;
    private int cp;
    private String direccion;
    private String id;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public updateDir() {
    }
    
    public String execute() throws Exception {
        return SUCCESS;
        
    }
    public String goToUpdate(){
        return SUCCESS;
    }
}
