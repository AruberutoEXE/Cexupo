/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Hibernate.HibernateUtil;
import Hibernate.Producto;
import Hibernate.Usuario;
import Hibernate.Venta;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author alber
 */
public class VentaDao {
     public void addVenta(Venta v) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        session.save(v);
        tx.commit();
        session.close();
    }
     public Venta getVenta(String idUsuario,String idProducto) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from Venta where idUsuario='" + idUsuario + "' AND idProducto='"+idProducto+"'");
        Venta u = (Venta) q.uniqueResult();
        tx.commit();
        sesion.close();
        return u;
    }
     public Venta getVenta(String idProducto) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from Venta where idProducto='"+idProducto+"'");
        Venta u = (Venta) q.uniqueResult();
        tx.commit();
        sesion.close();
        return u;
    }
      public List<Venta> getVentasByUsu(String usu) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from Venta where idUsuario='"+usu+"'");
        List<Venta> u = (List<Venta>)q.list();
        tx.commit();
        sesion.close();
        return u;
    }
     public void updateVenta(Venta v) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        session.update(v);
        tx.commit();
        session.close();
    }
     public void removeVenta(Venta v) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        session.delete(v);
        tx.commit();
        session.close();
    }
}
