/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import com.opensymphony.xwork2.ActionSupport;
import DAO.ProductoDao;
import Hibernate.Producto;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class ProductosVendidosAction extends ActionSupport {
    
    private List<Producto> productosVendidos;
    
    public ProductosVendidosAction() {
    }
    
    public String execute() throws Exception {
        
        ProductoDao pdao=new ProductoDao();
        productosVendidos=pdao.getAllProductosVendidos("");
        return SUCCESS;
    }

    public List<Producto> getProductosPublicados() {
        return productosVendidos;
    }

    public void setProductosPublicados(List<Producto> productos) {
        this.productosVendidos = productos;
    }
    
}
