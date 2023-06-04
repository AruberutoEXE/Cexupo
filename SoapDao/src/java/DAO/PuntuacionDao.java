/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Hibernate.HibernateUtil;
import Hibernate.Puntuacion;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author alber
 */
public class PuntuacionDao {
    public void addPuntuacion(Puntuacion v) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        session.save(v);
        tx.commit();
        session.close();
    }
     public Puntuacion getPuntuacion(String id) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from Puntuacion where id='" + id+"'");
        Puntuacion u = (Puntuacion) q.uniqueResult();
        tx.commit();
        sesion.close();
        return u;
    }
    
     public void updatePuntuacion(Puntuacion v) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        session.update(v);
        tx.commit();
        session.close();
    }
     public void removePuntuacion(Puntuacion v) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        session.delete(v);
        tx.commit();
        session.close();
    }
}
