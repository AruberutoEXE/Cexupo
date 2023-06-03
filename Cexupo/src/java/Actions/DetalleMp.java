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
    private String nombreM;
    private String detalles;
    public DetalleMp() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
    
    public String execute() throws Exception {
        UsuarioDao dao = new UsuarioDao();
        Metodopago mp = dao.getMetPago(Integer.parseInt(id));
        nombreM = mp.getNombre();
        detalles = mp.getDetalles();
        return SUCCESS;
    }
    
}
