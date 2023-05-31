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
import java.util.Map;
import org.apache.struts2.dispatcher.SessionMap;

/**
 *
 * @author Usuario
 */
public class ProductosVendidosAction extends ActionSupport {
    
    private List<Producto> productosVendidos;
    private SessionMap<String, Object> sessionMap;
    
    public ProductosVendidosAction() {
    }
    
    public String execute() throws Exception {
        
        ProductoDao pdao=new ProductoDao();
        productosVendidos=pdao.getAllProductosVendidos((String)sessionMap.get("username"));
        return SUCCESS;
    }

    public List<Producto> getProductosPublicados() {
        return productosVendidos;
    }

    public void setProductosPublicados(List<Producto> productos) {
        this.productosVendidos = productos;
    }
    
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap) map;
    }
    
}
