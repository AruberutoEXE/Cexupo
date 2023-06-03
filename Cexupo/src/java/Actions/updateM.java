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
public class updateM extends ActionSupport {
     private String nombreM;
    private String detalles;
    private String id;
    public updateM() {
    }

    public String getNombreM() {
        return nombreM;
    }

    public void setNombreM(String nombreM) {
        this.nombreM = nombreM;
    }

    

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String execute() throws Exception {
        return SUCCESS;
    }
     public String goToUpdate(){
        return SUCCESS;
    }
    
    public String goToPublicar(){
        return SUCCESS;
    }
}
