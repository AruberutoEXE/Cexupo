/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import DAO.UsuarioDao;
import usuarioService.Metodopago;
import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author agarc
 */
public class ModfiyMp extends ActionSupport {

    private String nombreM;
    private String detalles;
    private String id;

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

    public ModfiyMp() {
    }

    public String execute() throws Exception {
        UsuarioDao uDao = new UsuarioDao();
        Metodopago mp = uDao.getMetPago(Integer.parseInt(id));
        if (!this.nombreM.equals(mp.getNombre())) {
            mp.setNombre(nombreM);
        }

        if (!this.detalles.equals(mp.getDetalles())) {
            mp.setDetalles(detalles);
        }
        uDao.updateMetodoPago(mp);
        return SUCCESS;
    }

}
