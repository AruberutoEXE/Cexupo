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

    public boolean isRegistered(String name, String pass) {
        Usuario usu = getUser(name);
        boolean res = false;
        if (usu != null) {

            if (usu.getPassword().equals(pass)) {
                res = true;
            } else {
                res = false;
            }

        } else {
            res = false;
        }
        return res;
    }

    public Usuario getUser(String user) {

        Session sesion = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from Usuario WHERE username='" + user + "'");
        Usuario u = (Usuario) q.uniqueResult();
        tx.commit();
        sesion.close();
        return u;
    }

    public static boolean createUser(Usuario user) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        boolean salida = true;
        org.hibernate.Transaction tx = null;
        try {
            tx = sesion.beginTransaction();
            sesion.save(user);
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

    public static boolean userExiste(String email) {
        boolean salida;
        Transaction tx = null;
        Usuario u = null;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        try {
            tx = sesion.beginTransaction();
            Query sql = sesion.createQuery("FROM Usuario WHERE email=:email").setParameter("email", email);
            u = (Usuario) sql.uniqueResult();
            tx.commit();

        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        }
        if (u != null) {
            salida = true;
        } else {
            salida = false;
        }
        sesion.close();
        return salida;
    }
    public void updateUser(Usuario u) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        session.update(u);
        tx.commit();
        session.close();
    }
    
    public List<Direccion> getAllUserDirections(Usuario user) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from Direccion where idUsuario='" + user.getUsername() + "'");
        List<Direccion> u = (List<Direccion>) q.list();
        tx.commit();
        sesion.close();
        return u;
    }
    public Direccion getDireccion(int id){
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from Direccion where id='" + id + "'");
         Direccion d =  (Direccion) q.uniqueResult();
        tx.commit();
        sesion.close();
        return d;
    }
    public Metodopago getMetPago(int id){
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from Metodopago where id='" + id + "'");
         Metodopago mp =  (Metodopago) q.uniqueResult();
        tx.commit();
        sesion.close();
        return mp;
    }
    public boolean createDireccion(Direccion dir) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        boolean salida = true;
        org.hibernate.Transaction tx = sesion.beginTransaction();
        sesion.save(dir);
        tx.commit();
        sesion.close();
        return salida;
    }

    public void updateDireccion(Direccion d) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        session.update(d);
        tx.commit();
        session.close();
    }

    public void removeDireccion(Direccion d) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        session.delete(d);
        tx.commit();
        session.close();
    }

    public List<Metodopago> getAllUserPayMethods(Usuario user) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from Metodopago where idUsuario='" + user.getUsername() + "'");
        List<Metodopago> u = (List<Metodopago>) q.list();
        tx.commit();
        sesion.close();
        return u;
    }

    public boolean createMetodoPago(Metodopago mp) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        boolean salida = true;
        org.hibernate.Transaction tx = sesion.beginTransaction();
        sesion.save(mp);
        tx.commit();
        sesion.close();
        return salida;
    }

    public void updateMetodoPago(Metodopago mp) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        session.update(mp);
        tx.commit();
        session.close();
    }

    public void removeMetodoPago(Metodopago mp) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        session.delete(mp);
        tx.commit();
        session.close();
    }
}
