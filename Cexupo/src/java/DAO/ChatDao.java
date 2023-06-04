/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import chatService.Chat;
import chatService.ChatId;
import chatService.Mensaje;
import java.util.List;

/**
 *
 * @author alber
 */
public class ChatDao {

    public Chat createChat(Long idProducto, String idUsuario) {

        return createChat_1(idProducto, idUsuario);
    }

    public Chat getChat(Long idProducto, String idUsuario) {

        return getChat_1(idProducto, idUsuario);
    }

    public List<Chat> getAllChatsUsuario(String username) {
       
        return getAllChatsUsuario_1(username);
    }

    public void deleteChat(Chat c) {
        deleteChat_1(c);
    }

    public List<Mensaje> getMensajesChat(ChatId id) {
        return getMensajesChat_1(id);
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
