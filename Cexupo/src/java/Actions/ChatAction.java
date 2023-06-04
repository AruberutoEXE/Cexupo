/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import DAO.ChatDao;
import DAO.ProductoDao;
import chatService.Chat;
import chatService.ChatId;
import chatService.Mensaje;
import productoService.Producto;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Usuario
 */
public class ChatAction extends ActionSupport implements SessionAware{
    
    private ChatId chatId;
    private List<Mensaje> mensajes;
    private Producto product;
    private String producto;
    private SessionMap<String, Object> sessionMap;
    private Long idMensaje;
    private String contenidoMensaje;
    
    
    public ChatAction() {
    }
    
    public String execute() throws Exception {
        ChatDao cDao = new ChatDao();
        ProductoDao pDao = new ProductoDao();
        if(chatId == null){
            this.chatId = new ChatId();
            chatId.setIdProducto(Long.parseLong(producto));
            chatId.setIdUsuario((String)sessionMap.get("username"));
        }
        mensajes = cDao.getMensajesChat(chatId);
        product = pDao.getProducto((int) chatId.getIdProducto());
        return SUCCESS;
    }
    
    public String eliminar() throws Exception {
        ChatDao cDao = new ChatDao();
        Chat c = new Chat();
        c.setId(chatId);
        cDao.deleteChat(c);
        return SUCCESS;
    }
    
    public String editarM() throws Exception {
        execute();
        ChatDao cDao = new ChatDao();
        Mensaje m = cDao.getMensaje(idMensaje);
        m.setContenido(contenidoMensaje);
        cDao.updateMensaje(m);
        return SUCCESS;
    }
    
    public String enviarM() throws Exception {
        ChatDao cDao = new ChatDao();
        Mensaje m = new Mensaje();
        m.setContenido(contenidoMensaje);
        m.setIdUsuario((String)sessionMap.get("username"));
        execute();
        m.setIdChat(chatId.hashCode());
        cDao.addMensaje(m);
        return SUCCESS;
    }
    
    public String borrarM() throws Exception {
        execute();
        ChatDao cDao = new ChatDao();
        Mensaje m = cDao.getMensaje(idMensaje);
        cDao.removeMensaje(m);
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

    public Producto getProduct() {
        return product;
    }

    public void setProduct(Producto producto) {
        this.product = producto;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public Long getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(Long id) {
        this.idMensaje = id;
    }

    public String getContenidoMensaje() {
        return contenidoMensaje;
    }

    public void setContenidoMensaje(String contenido) {
        this.contenidoMensaje = contenido;
    }
    
    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap) map;
    }
    
}
