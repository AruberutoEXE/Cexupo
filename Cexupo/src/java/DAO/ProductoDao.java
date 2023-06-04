/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import productoService.Producto;
import productoService.Tarifaenvio;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author alber
 */
public class ProductoDao {

    public Producto getProducto(int id) {
        return getProducto_1(id);
    }

    public List<Producto> getAllProductos() {
        return getAllProductos_1();
    }

    public List<Producto> getAllProductosPublicados(String idUser) {
        return getAllProductosPublicados(idUser);
    }

    public List<Producto> getAllProductosVendidos(String idUser) {
        return getAllProductosVendidos_1(idUser);
    }

    public List<Tarifaenvio> getAllTarifas() {
        return getAllTarifas_1();
    }
   

    public void addProducto(Producto p) {
        addProducto_1(p);
    }
    
    public void removeProducto(Producto p) {
        removeProducto_1(p);
    }
    
    public void updateProducto(Producto p) {
        updateProducto_1(p);
    }

    private static void addProducto_1(productoService.Producto p) {
        productoService.ProductoDaoService_Service service = new productoService.ProductoDaoService_Service();
        productoService.ProductoDaoService port = service.getProductoDaoServicePort();
        port.addProducto(p);
    }

    private static java.util.List<productoService.Producto> getAllProductos_1() {
        productoService.ProductoDaoService_Service service = new productoService.ProductoDaoService_Service();
        productoService.ProductoDaoService port = service.getProductoDaoServicePort();
        return port.getAllProductos();
    }

    private static java.util.List<productoService.Producto> getAllProductosPublicados_1(java.lang.String idUser) {
        productoService.ProductoDaoService_Service service = new productoService.ProductoDaoService_Service();
        productoService.ProductoDaoService port = service.getProductoDaoServicePort();
        return port.getAllProductosPublicados(idUser);
    }

    private static java.util.List<productoService.Producto> getAllProductosVendidos_1(java.lang.String name) {
        productoService.ProductoDaoService_Service service = new productoService.ProductoDaoService_Service();
        productoService.ProductoDaoService port = service.getProductoDaoServicePort();
        return port.getAllProductosVendidos(name);
    }

    private static java.util.List<productoService.Tarifaenvio> getAllTarifas_1() {
        productoService.ProductoDaoService_Service service = new productoService.ProductoDaoService_Service();
        productoService.ProductoDaoService port = service.getProductoDaoServicePort();
        return port.getAllTarifas();
    }

    private static Producto getProducto_1(int id) {
        productoService.ProductoDaoService_Service service = new productoService.ProductoDaoService_Service();
        productoService.ProductoDaoService port = service.getProductoDaoServicePort();
        return port.getProducto(id);
    }

    private static void removeProducto_1(productoService.Producto p) {
        productoService.ProductoDaoService_Service service = new productoService.ProductoDaoService_Service();
        productoService.ProductoDaoService port = service.getProductoDaoServicePort();
        port.removeProducto(p);
    }

    private static void updateProducto_1(productoService.Producto p) {
        productoService.ProductoDaoService_Service service = new productoService.ProductoDaoService_Service();
        productoService.ProductoDaoService port = service.getProductoDaoServicePort();
        port.updateProducto(p);
    }
}
