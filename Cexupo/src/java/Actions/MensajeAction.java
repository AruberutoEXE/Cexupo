/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import DAO.UsuarioDao;
import Hibernate.Mensaje;
import Hibernate.Usuario;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;
import java.util.Map;
import org.apache.struts2.dispatcher.SessionMap;

/**
 *
 * @author Usuario
 */
public class MensajeAction extends ActionSupport {
    
    private Long id;
    private String contenido;
    private SessionMap<String, Object> sessionMap;
    
    public MensajeAction() {
    }
    
    public String execute() throws Exception {
        return SUCCESS;
    }
    
    public String editarM() throws Exception {
        UsuarioDao uDao = new UsuarioDao();
        Mensaje m = uDao.getMensaje(id);
        m.setContenido(contenido);
        uDao.updateMensaje(m);
        return SUCCESS;
    }
    
    public String enviarM() throws Exception {
        UsuarioDao uDao = new UsuarioDao();
        Mensaje m = new Mensaje();
        m.setContenido(contenido);
        m.setIdUsuario((String)sessionMap.get("username"));
        uDao.addMensaje(m);
        return SUCCESS;
    }
    
    public String borrarM() throws Exception {
        UsuarioDao uDao = new UsuarioDao();
        Mensaje m = uDao.getMensaje(id);
        uDao.removeMensaje(m);
        return SUCCESS;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap) map;
    }
}
