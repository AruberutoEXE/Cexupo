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
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author alber
 */
public class ChatDao {

    public Chat createChat(Long idProducto, String idUsuario) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Transaction tx = null;
        ChatId chatid = new ChatId();
        chatid.setIdProducto(idProducto);
        chatid.setIdUsuario(idUsuario);
        Chat chat = new Chat(chatid);
        try {
            tx = sesion.beginTransaction();
            sesion.save(chat);
            tx.commit();
        } catch (Exception ex) {
            if (tx != null) {
                tx.rollback();
            }
            chat = null;
        }
        sesion.close();
        return chat;
    }

    public Chat getChat(Long idProducto, String idUsuario) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from Chat where idUsuario='" + idUsuario + "' AND idProducto='" + idProducto + "'");
        Chat chat = (Chat) q.uniqueResult();
        tx.commit();
        sesion.close();
        return chat;
    }

    public List<Chat> getAllChatsUsuario(String username) {
        ProductoDao pDao = new ProductoDao();
        String str = "(";
        List<Chat> chats;
        List<Producto> productos = pDao.getAllProductosPublicados(username);
        if (productos.size() != 0) {
            Iterator it = productos.iterator();
            Producto p;
            while (it.hasNext()) {
                p = (Producto) it.next();
                if (it.hasNext()) {
                    str += "" + p.getId() + ",";
                } else {
                    str += "" + p.getId() + ")";
                }
            }
            Session sesion = HibernateUtil.getSessionFactory().openSession();
            org.hibernate.Transaction tx = sesion.beginTransaction();
            Query q = sesion.createQuery("from Chat where idUsuario='" + username + "' OR idProducto IN " + str);
            chats = (List<Chat>) q.list();
            tx.commit();
            sesion.close();
        }else{
            Session sesion = HibernateUtil.getSessionFactory().openSession();
            org.hibernate.Transaction tx = sesion.beginTransaction();
            Query q = sesion.createQuery("from Chat where idUsuario='" + username + "'");
            chats = (List<Chat>) q.list();
            tx.commit();
            sesion.close();
        }
        return chats;
    }

    public void deleteChat(Chat c) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        session.delete(c);
        tx.commit();
        session.close();
    }

    public List<Mensaje> getMensajesChat(ChatId id) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        int idChat = id.hashCode();
        Query q = sesion.createQuery("from Mensaje where idChat='" + idChat + "' ORDER BY fecha ASC");
        List<Mensaje> mensajes = (List<Mensaje>) q.list();
        tx.commit();
        sesion.close();
        return mensajes;
    }

    public Mensaje getMensaje(Long id) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from Mensaje where id=:id").setParameter("id", id);
        Mensaje mensaje = (Mensaje) q.uniqueResult();
        tx.commit();
        sesion.close();
        return mensaje;
    }

    public void addMensaje(Mensaje m) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        session.save(m);
        tx.commit();
        session.close();
    }

    public void removeMensaje(Mensaje m) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        session.delete(m);
        tx.commit();
        session.close();
    }

    public void updateMensaje(Mensaje m) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        session.update(m);
        tx.commit();
        session.close();
    }
}
