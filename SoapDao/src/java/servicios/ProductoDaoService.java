/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import DAO.ProductoDao;
import Hibernate.Producto;
import Hibernate.Tarifaenvio;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author alber
 */
@WebService(serviceName = "ProductoDaoService")
public class ProductoDaoService {

    ProductoDao pdao = new ProductoDao();

    @WebMethod(operationName = "getProducto")
    public Producto getProducto(@WebParam(name = "id")int id) {
        return pdao.getProducto(id);
    }
    @WebMethod(operationName = "getAllProductos")
    public List<Producto> getAllProductos() {
        return pdao.getAllProductos();
    }
    @WebMethod(operationName = "getAllProductosPublicados")
    public List<Producto> getAllProductosPublicados(@WebParam(name = "idUser") String idUser) {
        return pdao.getAllProductosPublicados(idUser);
    }
    @WebMethod(operationName = "getAllProductosVendidos")
    public List<Producto> getAllProductosVendidos(@WebParam(name = "name")String idUser) {
        return pdao.getAllProductosVendidos(idUser);
    }
    @WebMethod(operationName = "getAllTarifas")
    public List<Tarifaenvio> getAllTarifas() {
        return pdao.getAllTarifas();
    }
    @WebMethod(operationName = "addProducto")
    public void addProducto(@WebParam(name = "p") Producto p) {
        pdao.addProducto(p);
    }
    @WebMethod(operationName = "removeProducto")
    public void removeProducto(@WebParam(name = "p")Producto p) {
        removeProducto(p);
    }
    @WebMethod(operationName = "updateProducto")
    public void updateProducto(@WebParam(name = "p")Producto p) {
        pdao.updateProducto(p);
    }

}
