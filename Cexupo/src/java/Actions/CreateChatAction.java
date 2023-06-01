/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import DAO.UsuarioDao;
import Hibernate.ChatId;
import Hibernate.Mensaje;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author alber
 */
public class CreateChatAction extends ActionSupport implements SessionAware{
    
    private List<Mensaje> mensajes;
    private SessionMap<String, Object> sessionMap;
    public CreateChatAction() {
    }
    
    public String execute() throws Exception {
        String username=(String)sessionMap.get("username");
         UsuarioDao uDao = new UsuarioDao();
            //mensajes = uDao.getMensajesChat(chatId);
        return SUCCESS;
        
    }

    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap) map;
    }
    
}
