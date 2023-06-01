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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author alber
 */
public class ChatDao {

    public static boolean createChat(Long idProducto, String idUsuario) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        boolean salida = true;
        org.hibernate.Transaction tx = null;
        ChatId chat = new ChatId();
        chat.setIdProducto(idProducto);
        chat.setIdUsuario(idUsuario);
        try {
            tx = sesion.beginTransaction();
            sesion.save(chat);
            tx.commit();
        } catch (Exception ex) {
            if (tx != null) {
                tx.rollback();
            }
            salida = false;
        }
        sesion.close();
        return salida;
    }

    public static boolean getChat(Long idProducto, String idUsuario) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        boolean salida = true;
        org.hibernate.Transaction tx = null;
        ChatId chat = new ChatId();
        chat.setIdProducto(idProducto);
        chat.setIdUsuario(idUsuario);
        try {
            tx = sesion.beginTransaction();
            sesion.save(chat);
            tx.commit();
        } catch (Exception ex) {
            if (tx != null) {
                tx.rollback();
            }
            salida = false;
        }
        sesion.close();
        return salida;
    }

    public List<Chat> getAllChatsUsuario(String username) {
        ProductoDao pDao = new ProductoDao();
        List<Producto> productos = pDao.getAllProductosPublicados(username);
        List idProductos = new ArrayList();
        Iterator it = productos.iterator();
        Producto p;
        while (it.hasNext()) {
            p = (Producto) it.next();
            idProductos.add(p.getId());
        }
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from Chat where idUsuario='" + username + "' OR idProducto IN idProductos").setParameterList("idProductos", idProductos);
        List<Chat> chats = (List<Chat>) q.list();
        tx.commit();
        sesion.close();
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
        Query q = sesion.createQuery("from Mensaje where idChat=:id ORDER BY fecha ASC").setParameter("id", id);
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
