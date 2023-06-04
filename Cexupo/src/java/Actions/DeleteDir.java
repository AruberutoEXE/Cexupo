/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import DAO.UsuarioDao;
import usuarioService.Direccion;
import usuarioService.Usuario;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;

/**
 *
 * @author agarc
 */
public class DeleteDir extends ActionSupport {

    private String id;
    private Direccion direcciones;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DeleteDir() {
    }

    public String execute() throws Exception {
        UsuarioDao uDao = new UsuarioDao();
        Direccion d = uDao.getDireccion(Integer.parseInt(id));
        uDao.removeDireccion(d);
        return SUCCESS;
    }

}
