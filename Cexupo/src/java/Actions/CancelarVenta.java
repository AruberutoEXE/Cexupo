/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import DAO.UsuarioDao;
import DAO.VentaDao;
import usuarioService.Usuario;
import ventaService.Venta;
import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author alber
 */
public class CancelarVenta extends ActionSupport implements SessionAware{
    
   
    private String id;
    
     private SessionMap<String, Object> sessionMap;
    public CancelarVenta() {
    }
    
    public String execute() throws Exception {
        
        try {
            VentaDao vdao=new VentaDao();
            String usu = (String) sessionMap.get("username");
            Venta v=vdao.getVenta(usu, id);
            vdao.removeVenta(v);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return ERROR;
        }
        
        return SUCCESS;
    }

     @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap) map;
    }

 

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
