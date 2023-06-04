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
public class AddUpdateReview extends ActionSupport {
    String puntuacion;
    String comentario;
    String id;
    public AddUpdateReview() {
    }
    
    public String execute() throws Exception {
        try{
            
        
        PuntuacionDao pdao=new PuntuacionDao();
        VentaDao vdao=new VentaDao();
        Venta v=vdao.getVenta(id);
        long puntid=v.getIdPuntuacion();
        Puntuacion p;
        if(puntid==0){
            p=new Puntuacion();
            
        }else{
            p=pdao.getPuntuacion(puntid+"");
        }
        p.setNumero(Integer.parseInt(puntuacion));
        p.setResenya(comentario);
        
        if(puntid==0){
            pdao.addPuntuacion(p);
            
        }else{
            pdao.updatePuntuacion(p);
        }
        v.setIdPuntuacion(p.getId());
        vdao.updateVenta(v);
        }catch(Exception e){
            System.err.println(e.getMessage());
            return ERROR;
        }
        
        return SUCCESS;
    }
    
}
