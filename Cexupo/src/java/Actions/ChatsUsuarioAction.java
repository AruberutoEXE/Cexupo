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

/**
 *
 * @author Usuario
 */
public class ChatsUsuarioAction extends ActionSupport {
    
    private List<Chat> chats;
    
    public ChatsUsuarioAction() {
    }
    
    public String execute() throws Exception {
        UsuarioDao uDao = new UsuarioDao();
        chats = uDao.getAllChatsUsuario();
        return SUCCESS;
    }

    public List<Chat> getChats() {
        return chats;
    }

    public void setChats(List<Chat> chats) {
        this.chats = chats;
    }
    
    
    
}
