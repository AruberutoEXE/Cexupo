/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import puntuacionService.Puntuacion;
import org.hibernate.Query;
import org.hibernate.Session;
import puntuacionService.Puntuacion;

/**
 *
 * @author alber
 */
public class PuntuacionDao {
    public void addPuntuacion(Puntuacion v) {
        addPuntuacion_1(v);
    }
     public Puntuacion getPuntuacion(String id) {
        return getPuntuacion_1(id);
    }
    
     public void updatePuntuacion(Puntuacion v) {
         updatePuntuacion_1(v);
    }
     public void removePuntuacion(Puntuacion v) {
         removePuntuacion_1(v);
    }

    private static void addPuntuacion_1(puntuacionService.Puntuacion p) {
        puntuacionService.PuntuacionDaoService_Service service = new puntuacionService.PuntuacionDaoService_Service();
        puntuacionService.PuntuacionDaoService port = service.getPuntuacionDaoServicePort();
        port.addPuntuacion(p);
    }

    private static Puntuacion getPuntuacion_1(java.lang.String id) {
        puntuacionService.PuntuacionDaoService_Service service = new puntuacionService.PuntuacionDaoService_Service();
        puntuacionService.PuntuacionDaoService port = service.getPuntuacionDaoServicePort();
        return port.getPuntuacion(id);
    }

    private static void removePuntuacion_1(puntuacionService.Puntuacion name) {
        puntuacionService.PuntuacionDaoService_Service service = new puntuacionService.PuntuacionDaoService_Service();
        puntuacionService.PuntuacionDaoService port = service.getPuntuacionDaoServicePort();
        port.removePuntuacion(name);
    }

    private static void updatePuntuacion_1(puntuacionService.Puntuacion p) {
        puntuacionService.PuntuacionDaoService_Service service = new puntuacionService.PuntuacionDaoService_Service();
        puntuacionService.PuntuacionDaoService port = service.getPuntuacionDaoServicePort();
        port.updatePuntuacion(p);
    }
}
