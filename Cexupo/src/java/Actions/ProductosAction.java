/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import DAO.ProductoDao;
import Hibernate.Producto;
import com.opensymphony.xwork2.ActionSupport;
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
        productos=pdao.getAllProductos();
        return SUCCESS;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
    
}
