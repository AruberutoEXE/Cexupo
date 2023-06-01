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
public class ProductosPublicadosAction extends ActionSupport {
    
    private List<Producto> productosPublicados;
    private SessionMap<String, Object> sessionMap;
    
    public ProductosPublicadosAction() {
    }
    
    public String execute() throws Exception {
        
        ProductoDao pdao=new ProductoDao();
        System.out.println("Usuario logueado: "+sessionMap.get("username"));
        productosPublicados=pdao.getAllProductosPublicados((String)sessionMap.get("username"));
        return SUCCESS;
    }

    public List<Producto> getProductosPublicados() {
        return productosPublicados;
    }

    public void setProductosPublicados(List<Producto> productos) {
        this.productosPublicados = productos;
    }

    public SessionMap<String, Object> getSessionMap() {
        return sessionMap;
    }
    
    public void setSessionMap(Map<String, Object> map) {
        sessionMap = (SessionMap) map;
    }
}
