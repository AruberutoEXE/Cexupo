/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import usuarioService.*;

public class UsuarioDao {

    public boolean isRegistered(String name, String pass) {
        
        return isRegistered_1(name, pass);
    }

    public Usuario getUser(String user) {

        return getUser_1(user);
    }

    public static boolean createUser(Usuario user) {
       
        return createUser_1(user);
    }

    public static boolean userExiste(String email) {
        return userExiste_1(email);
    }
    public void updateUser(Usuario u) {
        updateUser_1(u);
    }
    
    public List<Direccion> getAllUserDirections(Usuario user) {
        return getAllUserDirections_1(user);
    }
    public Direccion getDireccion(int id){
        return getDireccion_1(id);
    }
    public Metodopago getMetPago(int id){
        return getMetPago_1(id);
    }
    public boolean createDireccion(Direccion dir) {
        return createDireccion_1(dir);
    }

    public void updateDireccion(Direccion d) {
        updateDireccion_1(d);
    }

    public void removeDireccion(Direccion d) {
        removeDireccion_1(d);
    }

    public List<Metodopago> getAllUserPayMethods(Usuario user) {
        return getAllUserPayMethods_1(user);
    }

    public boolean createMetodoPago(Metodopago mp) {
        return createMetodoPago_1(mp);
    }

    public void updateMetodoPago(Metodopago mp) {
        updateMetodoPago_1(mp);
    }

    public void removeMetodoPago(Metodopago mp) {
        removeMetodoPago_1(mp);
    }

    private static boolean createDireccion_1(usuarioService.Direccion dir) {
        usuarioService.UsuarioDaoService_Service service = new usuarioService.UsuarioDaoService_Service();
        usuarioService.UsuarioDaoService port = service.getUsuarioDaoServicePort();
        return port.createDireccion(dir);
    }

    private static boolean createMetodoPago_1(usuarioService.Metodopago mp) {
        usuarioService.UsuarioDaoService_Service service = new usuarioService.UsuarioDaoService_Service();
        usuarioService.UsuarioDaoService port = service.getUsuarioDaoServicePort();
        return port.createMetodoPago(mp);
    }

    private static boolean createUser_1(usuarioService.Usuario name) {
        usuarioService.UsuarioDaoService_Service service = new usuarioService.UsuarioDaoService_Service();
        usuarioService.UsuarioDaoService port = service.getUsuarioDaoServicePort();
        return port.createUser(name);
    }

    private static java.util.List<usuarioService.Direccion> getAllUserDirections_1(usuarioService.Usuario user) {
        usuarioService.UsuarioDaoService_Service service = new usuarioService.UsuarioDaoService_Service();
        usuarioService.UsuarioDaoService port = service.getUsuarioDaoServicePort();
        return port.getAllUserDirections(user);
    }

    private static java.util.List<usuarioService.Metodopago> getAllUserPayMethods_1(usuarioService.Usuario user) {
        usuarioService.UsuarioDaoService_Service service = new usuarioService.UsuarioDaoService_Service();
        usuarioService.UsuarioDaoService port = service.getUsuarioDaoServicePort();
        return port.getAllUserPayMethods(user);
    }

    private static Direccion getDireccion_1(int id) {
        usuarioService.UsuarioDaoService_Service service = new usuarioService.UsuarioDaoService_Service();
        usuarioService.UsuarioDaoService port = service.getUsuarioDaoServicePort();
        return port.getDireccion(id);
    }

    private static Metodopago getMetPago_1(int id) {
        usuarioService.UsuarioDaoService_Service service = new usuarioService.UsuarioDaoService_Service();
        usuarioService.UsuarioDaoService port = service.getUsuarioDaoServicePort();
        return port.getMetPago(id);
    }

    private static Usuario getUser_1(java.lang.String user) {
        usuarioService.UsuarioDaoService_Service service = new usuarioService.UsuarioDaoService_Service();
        usuarioService.UsuarioDaoService port = service.getUsuarioDaoServicePort();
        return port.getUser(user);
    }

    private static boolean isRegistered_1(java.lang.String name, java.lang.String pass) {
        usuarioService.UsuarioDaoService_Service service = new usuarioService.UsuarioDaoService_Service();
        usuarioService.UsuarioDaoService port = service.getUsuarioDaoServicePort();
        return port.isRegistered(name, pass);
    }

    private static void removeDireccion_1(usuarioService.Direccion name) {
        usuarioService.UsuarioDaoService_Service service = new usuarioService.UsuarioDaoService_Service();
        usuarioService.UsuarioDaoService port = service.getUsuarioDaoServicePort();
        port.removeDireccion(name);
    }

    private static void removeMetodoPago_1(usuarioService.Metodopago name) {
        usuarioService.UsuarioDaoService_Service service = new usuarioService.UsuarioDaoService_Service();
        usuarioService.UsuarioDaoService port = service.getUsuarioDaoServicePort();
        port.removeMetodoPago(name);
    }

    private static void updateDireccion_1(usuarioService.Direccion d) {
        usuarioService.UsuarioDaoService_Service service = new usuarioService.UsuarioDaoService_Service();
        usuarioService.UsuarioDaoService port = service.getUsuarioDaoServicePort();
        port.updateDireccion(d);
    }

    private static void updateMetodoPago_1(usuarioService.Metodopago name) {
        usuarioService.UsuarioDaoService_Service service = new usuarioService.UsuarioDaoService_Service();
        usuarioService.UsuarioDaoService port = service.getUsuarioDaoServicePort();
        port.updateMetodoPago(name);
    }

    private static void updateUser_1(usuarioService.Usuario u) {
        usuarioService.UsuarioDaoService_Service service = new usuarioService.UsuarioDaoService_Service();
        usuarioService.UsuarioDaoService port = service.getUsuarioDaoServicePort();
        port.updateUser(u);
    }

    private static boolean userExiste_1(java.lang.String email) {
        usuarioService.UsuarioDaoService_Service service = new usuarioService.UsuarioDaoService_Service();
        usuarioService.UsuarioDaoService port = service.getUsuarioDaoServicePort();
        return port.userExiste(email);
    }
    
    
    
    
}
