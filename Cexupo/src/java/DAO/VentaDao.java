/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Hibernate.HibernateUtil;
import Hibernate.Producto;
import Hibernate.Venta;
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
}
