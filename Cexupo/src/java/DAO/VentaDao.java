/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ventaService.*;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import ventaService.Venta;

/**
 *
 * @author alber
 */
public class VentaDao {
     public void addVenta(Venta v) {
         addVenta_1(v);
    }
     public Venta getVenta(String idUsuario,String idProducto) {
        return getVenta2(idUsuario, idProducto);
    }
     public Venta getVenta(String idProducto) {
        return getVenta_1(idProducto);
    }
      public List<Venta> getVentasByUsu(String usu) {
        return getVentasByUsu_1(usu);
    }
     public void updateVenta(Venta v) {
         updateVenta_1(v);
    }
     public void removeVenta(Venta v) {
         removeVenta_1(v);
    }

    private static void addVenta_1(ventaService.Venta v) {
        ventaService.VentasDaoServices_Service service = new ventaService.VentasDaoServices_Service();
        ventaService.VentasDaoServices port = service.getVentasDaoServicesPort();
        port.addVenta(v);
    }

    private static Venta getVenta_1(java.lang.String idProducto) {
        ventaService.VentasDaoServices_Service service = new ventaService.VentasDaoServices_Service();
        ventaService.VentasDaoServices port = service.getVentasDaoServicesPort();
        return port.getVenta(idProducto);
    }

    private static Venta getVenta2(java.lang.String idusuario, java.lang.String idProducto) {
        ventaService.VentasDaoServices_Service service = new ventaService.VentasDaoServices_Service();
        ventaService.VentasDaoServices port = service.getVentasDaoServicesPort();
        return port.getVenta2(idusuario, idProducto);
    }

    private static java.util.List<ventaService.Venta> getVentasByUsu_1(java.lang.String usu) {
        ventaService.VentasDaoServices_Service service = new ventaService.VentasDaoServices_Service();
        ventaService.VentasDaoServices port = service.getVentasDaoServicesPort();
        return port.getVentasByUsu(usu);
    }

    private static void removeVenta_1(ventaService.Venta v) {
        ventaService.VentasDaoServices_Service service = new ventaService.VentasDaoServices_Service();
        ventaService.VentasDaoServices port = service.getVentasDaoServicesPort();
        port.removeVenta(v);
    }

    private static void updateVenta_1(ventaService.Venta v) {
        ventaService.VentasDaoServices_Service service = new ventaService.VentasDaoServices_Service();
        ventaService.VentasDaoServices port = service.getVentasDaoServicesPort();
        port.updateVenta(v);
    }
}
