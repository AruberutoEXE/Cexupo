/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import DAO.UsuarioDao;
import Hibernate.Metodopago;
import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author agarc
 */
public class DeleteMetP extends ActionSupport {
    private String id;
    private Metodopago metodop;
    public DeleteMetP() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Metodopago getMetodop() {
        return metodop;
    }

    public void setMetodop(Metodopago metodop) {
        this.metodop = metodop;
    }
    
    public String execute() throws Exception {
        UsuarioDao uDao = new UsuarioDao();
        Metodopago mp = uDao.getMetPago(Integer.parseInt(id));
        uDao.removeMetodoPago(mp);
        return SUCCESS;
    }
    
}
