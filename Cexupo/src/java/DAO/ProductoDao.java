/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Hibernate.HibernateUtil;
import Hibernate.Producto;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author alber
 */
public class ProductoDao {
    public Producto getProducto(int id) {
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from Producto where id='"+id+"'");
        Producto u = (Producto) q.uniqueResult();
        tx.commit();
        return u;
    }
    public Producto getAllProductos() {
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from Producto");
        Producto u = (Producto) q.list();
        tx.commit();
        return u;
    }
}
