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
public class ProductosPublicadosAction extends ActionSupport {
    
    private List<Producto> productosPublicados;
    
    public ProductosPublicadosAction() {
    }
    
    public String execute() throws Exception {
        
        ProductoDao pdao=new ProductoDao();
        productosPublicados=pdao.getAllProductosPublicados("");
        return SUCCESS;
    }

    public List<Producto> getProductosPublicados() {
        return productosPublicados;
    }

    public void setProductosPublicados(List<Producto> productos) {
        this.productosPublicados = productos;
    }
    
}
