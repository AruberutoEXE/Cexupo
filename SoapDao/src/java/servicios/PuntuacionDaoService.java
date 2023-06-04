/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import DAO.PuntuacionDao;
import Hibernate.Puntuacion;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author alber
 */
@WebService(serviceName = "PuntuacionDaoService")
public class PuntuacionDaoService {
PuntuacionDao pdao=new PuntuacionDao();
   
    @WebMethod(operationName = "addPuntuacion")
    public void addPuntuacion(@WebParam(name = "p")Puntuacion p) {
        pdao.addPuntuacion(p);
    }
    @WebMethod(operationName = "getPuntuacion")
    public Puntuacion getPuntuacion(@WebParam(name = "id")String id) {
        return pdao.getPuntuacion(id);
    }
    @WebMethod(operationName = "updatePuntuacion")
    public void updatePuntuacion(@WebParam(name = "p")Puntuacion p) {
        pdao.updatePuntuacion(p);
    }
    @WebMethod(operationName = "removePuntuacion")
    public void removePuntuacion(@WebParam(name = "name")Puntuacion v) {
        pdao.removePuntuacion(v);
    }
}
