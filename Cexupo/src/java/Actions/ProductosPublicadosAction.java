/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import com.opensymphony.xwork2.ActionSupport;
import DAO.ProductoDao;
import productoService.Producto;
import java.util.List;
import java.util.Map;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Usuario
 */
public class ProductosPublicadosAction extends ActionSupport implements SessionAware{
    
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
    
    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap) map;
    }
}
