/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import DAO.TarifaDao;
import Hibernate.Tarifaenvio;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author alber
 */
@WebService(serviceName = "TarifaDaoService")
public class TarifaDaoService {

    /**
     * This is a sample web service operation
     * @param idTarifa
     * @return Tarifaenvio
     */
    
    @WebMethod(operationName = "getTarifa")
    public Tarifaenvio getTarifa(@WebParam(name = "idTarifa") String idTarifa) {
        TarifaDao tdao=new TarifaDao();
        return tdao.getTarifa(idTarifa);
    }
    
}
