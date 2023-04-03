/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Hibernate.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
public class UsuarioDao {
    
    
    
    public boolean isRegistered(String name,String  pass){
        return false;
    }
    public Usuario getUser(String user) {
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from Usuario WHERE usuario='" + user + "'");
        Usuario u = (Usuario) q.uniqueResult();
        tx.commit();
        return u;
    }
}
