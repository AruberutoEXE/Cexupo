/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Hibernate.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
public class UsuarioDao {
    
    
    
    public boolean isRegistered(String name,String  pass){
        Usuario usu=getUser(name);
        boolean res=false;
        if(usu!=null){
            
            if(usu.getPassword().equals(pass)){
               res=true; 
            }else{
               res=false; 
            }
            
        }else{
           res=false; 
        }
        return res;
    }
    public Usuario getUser(String user) {
        
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from Usuario WHERE username='" + user + "'");
        Usuario u = (Usuario) q.uniqueResult();
        tx.commit();
        return u;
    }
    public static boolean createUser(Usuario user){
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        boolean salida = true;
        org.hibernate.Transaction tx = null;
        try{
            tx = sesion.beginTransaction();
            sesion.save(user);
            tx.commit();
        }catch(Exception ex){
            if(tx != null){
                tx.rollback();
            }
            salida = false;
        }
        return salida;
    }
    public static boolean userExiste(String email){
        boolean salida;
        Transaction tx= null;
        Usuario u = null;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        try{
            tx = sesion.beginTransaction();
            Query sql = sesion.createQuery("FROM Usuario WHERE email=:email").setParameter("email", email);
            u = (Usuario) sql.uniqueResult();
            tx.commit();
            
        }catch(HibernateException e){
            if(tx != null){
                tx.rollback();
            }
        }
        if(u != null){
            salida = true;
        }
        else{
            salida = false;
        }
        return salida;
    }
    
    public List<Chat> getAllChatsUsuario() {
        ProductoDao pDao = new ProductoDao();
        List<Producto> productos = pDao.getAllProductosPublicados("usuario");
        List idProductos = new ArrayList();
        Iterator it = productos.iterator();
        Producto p;
        while(it.hasNext()){
            p = (Producto) it.next();
            idProductos.add(p.getId());
        }
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from Chat where idUsuario='usuario' OR idProducto IN idProductos").setParameterList("idProductos", idProductos);
        List<Chat> chats = (List<Chat>) q.list();
        tx.commit();
        return chats;
    }
    
    public List<Mensaje> getMensajesChat(ChatId id) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from Mensaje where idChat=:id").setParameter("id", id);
        List<Mensaje> mensajes = (List<Mensaje>) q.list();
        tx.commit();
        return mensajes;
    }
}
