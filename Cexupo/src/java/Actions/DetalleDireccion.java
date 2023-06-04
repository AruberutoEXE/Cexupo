/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import DAO.UsuarioDao;
import usuarioService.Direccion;
import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author agarc
 */
public class DetalleDireccion extends ActionSupport {
   
    private String id;
    private String nombreD;
    private int cp;
    private String direccion;

   
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreD() {
        return nombreD;
    }

    public void setNombreD(String nombreD) {
        this.nombreD = nombreD;
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
    public DetalleDireccion() {
    }
    
    public String execute() throws Exception {
         UsuarioDao dao = new UsuarioDao();
         Direccion d = dao.getDireccion(Integer.parseInt(id));
         nombreD = d.getNombre();
         cp = d.getCp();
         direccion = d.getDireccion();
         return SUCCESS;
    }
    
}
