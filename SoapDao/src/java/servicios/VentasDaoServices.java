package servicios;

import DAO.VentaDao;
import Hibernate.Venta;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author alber
 */
@WebService(serviceName = "VentasDaoServices")
public class VentasDaoServices {

    VentaDao vdao = new VentaDao();
    
    @WebMethod(operationName = "addVenta")
    public void addVenta(@WebParam(name = "v") Venta v) {
        vdao.addVenta(v);
    }

    @WebMethod(operationName = "getVenta2")
    public Venta getVenta2(@WebParam(name = "idusuario") String idusuario, @WebParam(name = "idProducto") String idProducto) {
        return vdao.getVenta(idusuario, idProducto);
    }

    @WebMethod(operationName = "getVenta")
    public Venta getVenta(@WebParam(name = "idProducto") String idProducto) {
        return vdao.getVenta(idProducto);
    }

    @WebMethod(operationName = "getVentasByUsu")
    public List<Venta> getVentasByUsu(@WebParam(name = "usu") String usu) {
        return vdao.getVentasByUsu(usu);
    }

    @WebMethod(operationName = "updateVenta")
    public  void updateVenta(@WebParam(name = "v") Venta v) {
        vdao.updateVenta(v);
    }

    @WebMethod(operationName = "removeVenta")
    public void removeVenta(@WebParam(name = "v")Venta v) {
        vdao.removeVenta(v);
    }

}
