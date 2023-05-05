/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Hibernate.HibernateUtil;
import Hibernate.Producto;
import Hibernate.Tarifaenvio;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author alber
 */
public class ProductoDao {

    public Producto getProducto(int id) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from Producto where id='" + id + "'");
        Producto u = (Producto) q.uniqueResult();
        tx.commit();
        return u;
    }

    public List<Producto> getAllProductos() {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from Producto where estado='publicado'");
        List<Producto> u = (List<Producto>) q.list();
        tx.commit();
        System.out.println("nºProductos: " + u.size());
        return u;
    }

    public List<Producto> getAllProductosPublicados(String idUser) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from Producto where id_usuario='usuario' AND estado='publicado'");
        //Query q = sesion.createQuery("from Producto where id_usuario='" + idUser + "' AND estado='publicado'");
        List<Producto> u = (List<Producto>) q.list();
        tx.commit();
        System.out.println("nºProductos: " + u.size());
        return u;
    }

    public List<Producto> getAllProductosVendidos(String idUser) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from Producto where id_usuario='" + idUser + "' AND estado='vendido'");
        List<Producto> u = (List<Producto>) q.list();
        tx.commit();
        System.out.println("nºProductos: " + u.size());
        return u;
    }

    public List<Tarifaenvio> getAllTarifas() {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from Tarifa");
        List<Tarifaenvio> u = (List<Tarifaenvio>) q.list();
        tx.commit();
        return u;
    }

    public void addProducto(Producto p) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        session.save(p);
        tx.commit();
    }
    
    public void removeProducto(Producto p) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        session.delete(p);
        tx.commit();
    }
    
    public void updateProducto(Producto p) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        session.update(p);
        tx.commit();
    }
}
