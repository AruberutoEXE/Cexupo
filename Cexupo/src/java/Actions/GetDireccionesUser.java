/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import DAO.UsuarioDao;
import Hibernate.Direccion;
import Hibernate.Usuario;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.LinkedList;
import java.util.List;
import org.apache.struts2.dispatcher.SessionMap;


public class GetDireccionesUser extends ActionSupport {
    
    public GetDireccionesUser() {
    }
    private SessionMap<String, Object> sessionMap;

    private List<String> direcciones;

    public SessionMap<String, Object> getSessionMap() {
        return sessionMap;
    }

    public void setSessionMap(SessionMap<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    public List<String> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(List<String> direcciones) {
        this.direcciones = direcciones;
    }
   
    
    public String execute() throws Exception {
      
       UsuarioDao udao = new UsuarioDao();
        List<String> dir = new LinkedList<String>();
        Usuario usu=udao.getUser((String)sessionMap.get("username"));
        List<Direccion> dirlist = udao.getAllUserDirections(usu);
        for (int i = 0; i < dirlist.size(); i++) {
            dir.add(dirlist.get(i).getNombre());
        }
        direcciones = dir; 
       return SUCCESS;
    
    }
    
    
    
}
