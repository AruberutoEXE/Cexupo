/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import DAO.ProductoDao;
import DAO.TarifaDao;
import DAO.UsuarioDao;
import DAO.VentaDao;
import productoService.Producto;
import tarifaService.Tarifaenvio;
import usuarioService.Usuario;
import ventaService.Venta;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Map;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.apache.struts2.dispatcher.SessionMap;

import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author alber
 */
public class FianlizarCompra extends ActionSupport implements SessionAware {

    public FianlizarCompra() {
    }
    private String direccion;
    private String transporte;
    private String pago;
    private String id;

    private SessionMap<String, Object> sessionMap;

    public String execute() throws Exception {
        System.out.println("Detalles: ");
        System.out.println(direccion);
        System.out.println(transporte);
        System.out.println(pago);
        System.out.println(id);
        //try {
        VentaDao vdao = new VentaDao();
        UsuarioDao udao = new UsuarioDao();
        Usuario usu = udao.getUser((String) sessionMap.get("username"));
        if (vdao.getVenta(usu.getUsername(), id) == null) {
            Venta v = new Venta();
            direccion = direccion.replaceAll("[^\\w+]", "");
            pago = pago.replaceAll("[^\\w+]", "");
            transporte = transporte.replaceAll("[^\\w+]", "");
            v.setIdDireccion(Long.parseLong(direccion));
            v.setIdMetodoPago(Long.parseLong(pago));
            v.setIdTarifa(Long.parseLong(transporte));

            v.setIdUsuario(usu.getUsername());
            GregorianCalendar gc = new GregorianCalendar();
            gc.setTime(new Date());
            XMLGregorianCalendar xmlgc = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);

            v.setFechaVenta(xmlgc);
            v.setIdProducto(Long.parseLong(id));
            TarifaDao tdao = new TarifaDao();
            ProductoDao pdao = new ProductoDao();
            Producto p = pdao.getProducto(Integer.parseInt(id));
            Tarifaenvio t = tdao.getTarifa(transporte);
            float total = p.getPrecio() + t.getPrecioPeso() + t.getPrecioVolumen() + t.getPrecioSeguro();
            v.setPrecioTotal(total);

            vdao.addVenta(v);
        }
        /*} catch (Exception e) {
            System.err.println(e.getMessage());
            return ERROR;
        }*/
        return SUCCESS;

    }

    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap) map;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTransporte() {
        return transporte;
    }

    public void setTransporte(String transporte) {
        this.transporte = transporte;
    }

    public String getPago() {
        return pago;
    }

    public void setPago(String pago) {
        this.pago = pago;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
