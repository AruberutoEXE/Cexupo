/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import DAO.UsuarioDao;
import usuarioService.Direccion;
import usuarioService.Usuario;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;


public class GetDireccionesUser extends ActionSupport implements SessionAware{
    
    public GetDireccionesUser() {
    }
    private String id;
    private SessionMap<String, Object> sessionMap;

    private List<Direccion> direcciones;

    public SessionMap<String, Object> getSessionMap() {
        return sessionMap;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSessionMap(SessionMap<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    public List<Direccion> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(List<Direccion> direcciones) {
        this.direcciones = direcciones;
    }

    public String execute() throws Exception {
      
       UsuarioDao udao = new UsuarioDao();
        
        Usuario usu=udao.getUser((String)sessionMap.get("username"));
        
           direcciones = udao.getAllUserDirections(usu); 
        
       return SUCCESS;
       
    }
    public String detallesDir(){
        UsuarioDao uDao = new UsuarioDao();
        Direccion d = uDao.getDireccion(Integer.parseInt(id));
        System.out.println("Valor del id: "+id);
        return SUCCESS;
    }
    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap) map;
    }
    
    
    
}
