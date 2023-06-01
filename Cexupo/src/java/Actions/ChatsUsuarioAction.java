/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import DAO.UsuarioDao;
import Hibernate.Chat;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Usuario
 */
public class ChatsUsuarioAction extends ActionSupport implements SessionAware{
    
    private List<Chat> chats;
    private SessionMap<String, Object> sessionMap;
    
    public ChatsUsuarioAction() {
    }
    
    public String execute() throws Exception {
        UsuarioDao uDao = new UsuarioDao();
        chats = uDao.getAllChatsUsuario((String)sessionMap.get("username"));
        return SUCCESS;
    }

    public List<Chat> getChats() {
        return chats;
    }

    public void setChats(List<Chat> chats) {
        this.chats = chats;
    }
    
    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap) map;
    }
    
    
}
