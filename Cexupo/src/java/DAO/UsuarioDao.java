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
        Usuario usu=getUser(name);
        boolean res=false;
        if(usu!=null){
            
            if(usu.getPassword().equals(pass)){
               res=true; 
            }else{
               res=false; 
            }
            
        }else{
           res=false; 
        }
        return res;
    }
    public Usuario getUser(String user) {
        
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from Usuario WHERE username='" + user + "'");
        Usuario u = (Usuario) q.uniqueResult();
        tx.commit();
        return u;
    }
}
