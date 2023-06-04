/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import DAO.ProductoDao;
import DAO.VentaDao;
import productoService.Producto;
import ventaService.Venta;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author alber
 */
public class Ventas extends ActionSupport implements SessionAware {

    private List<Producto> productos;

    private SessionMap<String, Object> sessionMap;

    public Ventas() {
    }

    public String execute() throws Exception {

        ProductoDao pdao = new ProductoDao();
        VentaDao vdao = new VentaDao();
        List<Producto> pro = pdao.getAllProductos();
        List<Venta> ventas = vdao.getVentasByUsu((String) sessionMap.get("username"));
        productos = new LinkedList<Producto>();
        List<Long> vn = new LinkedList<Long>();
        System.out.println("Numero de ventas: " + ventas.size());
        for (int i = 0; i < ventas.size(); i++) {
            vn.add(ventas.get(i).getIdProducto());
        }

        for (int i = 0; i < pro.size(); i++) {

            for (int j = 0; j < vn.size(); j++) {
                System.out.println(vn.get(j)+" :vs: "+pro.get(i).getId());
                if (vn.get(j)==pro.get(i).getId()) {
                    System.out.println("Aceptado!!");
                    productos.add(pro.get(i));
                }
            }

        }
        System.out.println("Numero de productos: " + productos.size());
        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap) map;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

}
