/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import DAO.ChatDao;
import Hibernate.Chat;
import Hibernate.ChatId;
import Hibernate.Mensaje;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author alber
 */
@WebService(serviceName = "ChatDaoService")
public class ChatDaoService {

    ChatDao cdao=new ChatDao();
    @WebMethod(operationName = "createChat")
    public Chat createChat(@WebParam(name = "idProducto")Long idProducto,@WebParam(name = "idUsuario")String idUsuario) {
        return cdao.createChat(idProducto, idUsuario);
    }
    @WebMethod(operationName = "getChat")
    public Chat getChat(@WebParam(name = "idProducto")Long idProducto,@WebParam(name = "idUsuario")String idUsuario) {
        return cdao.getChat(idProducto, idUsuario);
    }
    @WebMethod(operationName = "getAllChatsUsuario")
    public List<Chat> getAllChatsUsuario(@WebParam(name = "username") String username) {
        return cdao.getAllChatsUsuario(username);
    }
    @WebMethod(operationName = "deleteChat")
    public void deleteChat(@WebParam(name = "c") Chat c) {
        cdao.deleteChat(c);
    }
    @WebMethod(operationName = "getMensajesChat")
    public List<Mensaje> getMensajesChat(@WebParam(name = "id") ChatId id) {
        return  cdao.getMensajesChat(id);
    }
    @WebMethod(operationName = "getMensaje")
    public Mensaje getMensaje(@WebParam(name = "id") Long id) {
        return cdao.getMensaje(id);
    }
    @WebMethod(operationName = "addMensaje")
    public void addMensaje(@WebParam(name = "m") Mensaje m) {
        addMensaje(m);
    }
    @WebMethod(operationName = "removeMensaje")
    public void removeMensaje(@WebParam(name = "txt") Mensaje m) {
        cdao.removeMensaje(m);
    } 
    @WebMethod(operationName = "updateMensaje")
    public void updateMensaje(@WebParam(name = "m") Mensaje m) {
        cdao.updateMensaje(m);
    }
}
