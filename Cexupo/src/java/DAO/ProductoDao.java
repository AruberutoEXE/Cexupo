/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Hibernate.HibernateUtil;
import Hibernate.Producto;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author alber
 */
public class ProductoDao {
    public Producto getProducto(int id) {
        Session sesion  = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from Producto where id='"+id+"'");
        Producto u = (Producto) q.uniqueResult();
        tx.commit();
        return u;
    }
    public List<Producto> getAllProductos() {
        Session sesion  = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from Producto");
        List<Producto> u =  (List<Producto>) q.list();
        tx.commit();
        System.out.println("nºProductos: "+u.size());
        return u;
    }
}
