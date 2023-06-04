/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import DAO.PuntuacionDao;
import DAO.VentaDao;
import puntuacionService.Puntuacion;
import ventaService.Venta;
import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author alber
 */
public class EliminarReview extends ActionSupport {
    
    private String id;
    public EliminarReview() {
    }
    
    public String execute() throws Exception {
        PuntuacionDao pdao=new PuntuacionDao();
        VentaDao vdao=new VentaDao();
        Venta v=vdao.getVenta(id);
        Long puntid=v.getIdPuntuacion();
        Puntuacion p;
        p=pdao.getPuntuacion(puntid.toString());
        pdao.removePuntuacion(p);
        v.setIdPuntuacion(0);
        vdao.updateVenta(v);
        return SUCCESS;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
}
