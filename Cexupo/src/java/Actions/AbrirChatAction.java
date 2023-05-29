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

/**
 *
 * @author Usuario
 */
public class AbrirChatAction extends ActionSupport {
    
    private ChatId chatId;
    private List<Mensaje> mensajes;
    
    public AbrirChatAction() {
    }
    
    public String execute() throws Exception {
        UsuarioDao uDao = new UsuarioDao();
        mensajes = uDao.getMensajesChat(chatId);
        return SUCCESS;
    }

    public ChatId getChatId() {
        return chatId;
    }

    public void setChatId(ChatId chatId) {
        this.chatId = chatId;
    }
    
    
}
