/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Hibernate.Chat;
import Hibernate.ChatId;
import Hibernate.HibernateUtil;
import Hibernate.Mensaje;
import Hibernate.Producto;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author alber
 */
public class ChatDao {

    public Chat createChat(Long idProducto, String idUsuario) {

        return chatSoapToHibernate(createChat_1(idProducto, idUsuario));
    }

    public Chat getChat(Long idProducto, String idUsuario) {

        return chatSoapToHibernate(getChat_1(idProducto, idUsuario));
    }

    public List<Chat> getAllChatsUsuario(String username) {
        List<chatService.Chat> cs = getAllChatsUsuario_1(username);
        List<Chat> ch = new LinkedList<Chat>();
        for (int i = 0; i < cs.size(); i++) {
            ch.add(chatSoapToHibernate(cs.get(i)));
        }
        return ch;
    }

    public void deleteChat(Chat c) {
        deleteChat_1(chatHibernateToSoap(c));
    }

    public List<Mensaje> getMensajesChat(ChatId id) {

        getMensajesChat_1(chatIdHibernateToSoap(id))
        
        
        return res;
    }

    public Mensaje getMensaje(Long id) {

        return getMensaje_1(id);
    }

    public void addMensaje(Mensaje m) {
        addMensaje_1(m);
    }

    public void removeMensaje(Mensaje m) {
        removeMensaje_1(m);
    }

    public void updateMensaje(Mensaje m) {
        updateMensaje_1(m);
    }

    private static void addMensaje_1(chatService.Mensaje m) {
        addMensaje_1(m);
    }

    public chatService.Chat chatHibernateToSoap(Hibernate.Chat c) {
        chatService.Chat res = new chatService.Chat();
        res.setId(chatIdHibernateToSoap(c.getId()));
        return res;
    }

    public chatService.ChatId chatIdHibernateToSoap(Hibernate.ChatId c) {
        chatService.ChatId res = new chatService.ChatId();
        res.setIdProducto(c.getIdProducto());
        res.setIdUsuario(c.getIdUsuario());
        return res;
    }

    public Hibernate.Chat chatSoapToHibernate(chatService.Chat c) {
        Hibernate.Chat res = new Hibernate.Chat();
        res.setId(chatIdSoapToHibernate(c.getId()));
        return res;
    }

    public Hibernate.ChatId chatIdSoapToHibernate(chatService.ChatId c) {
        Hibernate.ChatId res = new Hibernate.ChatId();
        res.setIdProducto(c.getIdProducto());
        res.setIdUsuario(c.getIdUsuario());
        return res;
    }

    public chatService.Mensaje MensajeHibernateToSoap(Hibernate.Mensaje c) {
        chatService.Mensaje res = new chatService.Mensaje();
        res.setId(c.getId());
        return res;
    }
    public Hibernate.Mensaje MensajeSoapToHibernate(chatService.Mensaje c) {
        Hibernate.Mensaje res = new Hibernate.Mensaje();
        res.setId(c.getId());
        return res;
    }

  
    private static chatService.Chat createChat_1(java.lang.Long idProducto, java.lang.String idUsuario) {
        chatService.ChatDaoService_Service service = new chatService.ChatDaoService_Service();
        chatService.ChatDaoService port = service.getChatDaoServicePort();
        return port.createChat(idProducto, idUsuario);
    }

    private static void deleteChat_1(chatService.Chat c) {
        chatService.ChatDaoService_Service service = new chatService.ChatDaoService_Service();
        chatService.ChatDaoService port = service.getChatDaoServicePort();
        port.deleteChat(c);
    }

    private static java.util.List<chatService.Chat> getAllChatsUsuario_1(java.lang.String username) {
        chatService.ChatDaoService_Service service = new chatService.ChatDaoService_Service();
        chatService.ChatDaoService port = service.getChatDaoServicePort();
        return port.getAllChatsUsuario(username);
    }

    private static chatService.Chat getChat_1(java.lang.Long idProducto, java.lang.String idUsuario) {
        chatService.ChatDaoService_Service service = new chatService.ChatDaoService_Service();
        chatService.ChatDaoService port = service.getChatDaoServicePort();
        return port.getChat(idProducto, idUsuario);
    }

    private static chatService.Mensaje getMensaje_1(java.lang.Long id) {
        chatService.ChatDaoService_Service service = new chatService.ChatDaoService_Service();
        chatService.ChatDaoService port = service.getChatDaoServicePort();
        return port.getMensaje(id);
    }

    private static java.util.List<chatService.Mensaje> getMensajesChat_1(chatService.ChatId id) {
        chatService.ChatDaoService_Service service = new chatService.ChatDaoService_Service();
        chatService.ChatDaoService port = service.getChatDaoServicePort();
        return port.getMensajesChat(id);
    }

    private static void removeMensaje_1(chatService.Mensaje txt) {
        chatService.ChatDaoService_Service service = new chatService.ChatDaoService_Service();
        chatService.ChatDaoService port = service.getChatDaoServicePort();
        port.removeMensaje(txt);
    }

    private static void updateMensaje_1(chatService.Mensaje m) {
        chatService.ChatDaoService_Service service = new chatService.ChatDaoService_Service();
        chatService.ChatDaoService port = service.getChatDaoServicePort();
        port.updateMensaje(m);
    }

}
