/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import DAO.UsuarioDao;
import Hibernate.Direccion;
import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author agarc
 */
public class ModifyDir extends ActionSupport {
    private String nombreD;
    private int cp;
    private String direccion;
    private String id;

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
    public ModifyDir() {
    }
    
    public String execute() throws Exception {
        UsuarioDao uDao = new UsuarioDao();
        Direccion d = uDao.getDireccion(Integer.parseInt(id));
        if(!this.nombreD.equals(d.getNombre())){
            d.setNombre(nombreD);
        }
        if(!this.direccion.equals(d.getDireccion())){
            d.setDireccion(direccion);
        }
        if(this.cp != d.getCp()){
            d.setCp(cp);
        }
        
        uDao.updateDireccion(d);
        return SUCCESS;
    }
    
}
