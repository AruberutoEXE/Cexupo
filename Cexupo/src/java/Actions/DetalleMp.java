/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import DAO.UsuarioDao;
import Hibernate.Metodopago;
import com.opensymphony.xwork2.ActionSupport;

public class DetalleMp extends ActionSupport {
      private String id;
    private String nombre;
    private String detalles;
    public DetalleMp() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }
    
    public String execute() throws Exception {
        UsuarioDao dao = new UsuarioDao();
        Metodopago mp = dao.getMetPago(Integer.parseInt(id));
        nombre = mp.getNombre();
        detalles = mp.getDetalles();
        return SUCCESS;
    }
    
}