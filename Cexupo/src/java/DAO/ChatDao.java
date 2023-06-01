/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Hibernate.Chat;
import Hibernate.ChatId;
import Hibernate.HibernateUtil;
import Hibernate.Usuario;
import org.hibernate.Session;

/**
 *
 * @author alber
 */
public class ChatDao {
     public static boolean createChat(Long idProducto,String idUsuario){
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        boolean salida = true;
        org.hibernate.Transaction tx = null;
         ChatId chat =new ChatId();
        chat.setIdProducto(idProducto);
        chat.setIdUsuario(idUsuario);
        try{
            tx = sesion.beginTransaction();
            sesion.save(chat);
            tx.commit();
        }catch(Exception ex){
            if(tx != null){
                tx.rollback();
            }
            salida = false;
        }
        sesion.close();
        return salida;
    }
     public static boolean getChat(Long idProducto,String idUsuario){
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        boolean salida = true;
        org.hibernate.Transaction tx = null;
         ChatId chat =new ChatId();
        chat.setIdProducto(idProducto);
        chat.setIdUsuario(idUsuario);
        try{
            tx = sesion.beginTransaction();
            sesion.save(chat);
            tx.commit();
        }catch(Exception ex){
            if(tx != null){
                tx.rollback();
            }
            salida = false;
        }
        sesion.close();
        return salida;
    }
}
