/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Hibernate.HibernateUtil;
import Hibernate.Tarifaenvio;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author alber
 */
public class TarifaDao {
     public Tarifaenvio getTarifa(String idTarifa) {

        Session sesion = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from Tarifaenvio WHERE id='" + idTarifa + "'");
        Tarifaenvio u = (Tarifaenvio) q.uniqueResult();
        tx.commit();
        sesion.close();
        return u;
    }
}
