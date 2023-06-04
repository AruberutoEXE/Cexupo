/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import DAO.ProductoDao;
import DAO.VentaDao;
import productoService.Producto;
import com.opensymphony.xwork2.ActionSupport;
import java.util.AbstractList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author alber
 */
public class ProductosAction extends ActionSupport {
    
    
    private List<Producto> productos;
    
    public ProductosAction() {
    }
    
    public String execute() throws Exception {
        
        ProductoDao pdao=new ProductoDao();
        List<Producto> pro=pdao.getAllProductos();
        VentaDao vdao=new VentaDao();
        productos=new LinkedList<Producto>();
        for(int i=0;i<pro.size();i++){
            if(vdao.getVenta(pro.get(i).getId()+"")==null){
               productos.add(pro.get(i));  
            }
        }
        return SUCCESS;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
    
}
