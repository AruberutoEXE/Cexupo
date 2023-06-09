/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import DAO.ChatDao;
import DAO.UsuarioDao;
import chatService.Chat;
import chatService.Mensaje;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author alber
 */
public class CreateChatAction extends ActionSupport implements SessionAware {

    private String producto;
    private List<Mensaje> mensajes;
    private SessionMap<String, Object> sessionMap;

    public CreateChatAction() {
    }

    public String execute() throws Exception {
        //try {
            String username = (String) sessionMap.get("username");
            UsuarioDao uDao = new UsuarioDao();
            ChatDao cdao = new ChatDao();
            Chat chat = cdao.getChat(Long.parseLong(producto), username);
            if (chat == null) {
                chat = cdao.createChat(Long.parseLong(producto), username);
            }
            mensajes = cdao.getMensajesChat(chat.getId());
        /*} catch (Exception e) {
            System.err.println(e.getMessage());
            return ERROR;
        }*/
        System.out.println("Abrir chat");
        return SUCCESS;

    }

    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap) map;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public List<Mensaje> getMensajes() {
        return mensajes;
    }

    public void setMensajes(List<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }

}
