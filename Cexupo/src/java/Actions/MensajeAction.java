/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import DAO.ChatDao;
import DAO.UsuarioDao;
import Hibernate.Mensaje;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Usuario
 */
public class MensajeAction extends ActionSupport implements SessionAware{
    
    private Long id;
    private String contenido;
    private SessionMap<String, Object> sessionMap;
    
    public MensajeAction() {
    }
    
    public String execute() throws Exception {
        return SUCCESS;
    }
    
    public String editarM() throws Exception {
        ChatDao cDao = new ChatDao();
        Mensaje m = cDao.getMensaje(id);
        m.setContenido(contenido);
        cDao.updateMensaje(m);
        return SUCCESS;
    }
    
    public String enviarM() throws Exception {
        ChatDao cDao = new ChatDao();
        Mensaje m = new Mensaje();
        m.setContenido(contenido);
        m.setIdUsuario((String)sessionMap.get("username"));
        cDao.addMensaje(m);
        return SUCCESS;
    }
    
    public String borrarM() throws Exception {
        ChatDao cDao = new ChatDao();
        Mensaje m = cDao.getMensaje(id);
        cDao.removeMensaje(m);
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
    
    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap) map;
    }
}
