/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import tarifaService.Tarifaenvio;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author alber
 */
public class TarifaDao {
     public Tarifaenvio getTarifa(String idTarifa) {
        return getTarifa(idTarifa);
    }

    private static tarifaService.Tarifaenvio getTarifa_1(java.lang.String idTarifa) {
        tarifaService.TarifaDaoService_Service service = new tarifaService.TarifaDaoService_Service();
        tarifaService.TarifaDaoService port = service.getTarifaDaoServicePort();
        return port.getTarifa(idTarifa);
    }
     
}
