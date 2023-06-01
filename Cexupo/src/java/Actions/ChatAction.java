/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import DAO.ProductoDao;
import DAO.UsuarioDao;
import Hibernate.Chat;
import Hibernate.ChatId;
import Hibernate.Mensaje;
import Hibernate.Producto;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class ChatAction extends ActionSupport {
    
    private ChatId chatId;
    private List<Mensaje> mensajes;
    private Producto producto;
    
    public ChatAction() {
    }
    
    public String execute() throws Exception {
        return SUCCESS;
    }
    
    public String cargar() throws Exception {
        UsuarioDao uDao = new UsuarioDao();
        ProductoDao pDao = new ProductoDao();
        mensajes = uDao.getMensajesChat(chatId);
        producto = pDao.getProducto((int) chatId.getIdProducto());
        return SUCCESS;
    }
    
    public String eliminar() throws Exception {
        UsuarioDao uDao = new UsuarioDao();
        Chat c = new Chat(chatId);
        uDao.deleteChat(c);
        return SUCCESS;
    }

    public ChatId getChatId() {
        return chatId;
    }

    public void setChatId(ChatId chatId) {
        this.chatId = chatId;
    }

    public List<Mensaje> getMensajes() {
        return mensajes;
    }

    public void setMensajes(List<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    
    
}
