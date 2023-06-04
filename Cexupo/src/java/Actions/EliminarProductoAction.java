/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import DAO.ProductoDao;
import productoService.Producto;
import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author Usuario
 */
public class EliminarProductoAction extends ActionSupport {
    
    private String id;
    
    public EliminarProductoAction() {
    }
    
    public String execute() throws Exception {
        ProductoDao pDao = new ProductoDao();
        Producto p = pDao.getProducto(Integer.parseInt(id));
        pDao.removeProducto(p);
        return SUCCESS;     
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    } 
}
