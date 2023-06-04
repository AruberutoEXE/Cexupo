/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import DAO.UsuarioDao;
import Hibernate.Direccion;
import Hibernate.Metodopago;
import Hibernate.Usuario;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author alber
 */
@WebService(serviceName = "UsuarioDaoService")
public class UsuarioDaoService {

    UsuarioDao udao = new UsuarioDao();

    @WebMethod(operationName = "isRegistered")
    public boolean isRegistered(@WebParam(name = "name") String name, @WebParam(name = "pass") String pass) {
        return udao.isRegistered(name, pass);
    }

    @WebMethod(operationName = "getUser")
    public Usuario getUser(@WebParam(name = "user")String user) {
        return udao.getUser(user);
    }

    @WebMethod(operationName = "createUser")
    public boolean createUser(@WebParam(name = "name")Usuario user) {
        return udao.createUser(user);
    }

    @WebMethod(operationName = "userExiste")
    public boolean userExiste(@WebParam(name = "email") String email) {
        return udao.userExiste(email);
    }
    @WebMethod(operationName = "updateUser")
    public void updateUser(@WebParam(name = "u")Usuario u) {
        udao.updateUser(u);
    }
    @WebMethod(operationName = "getAllUserDirections")
    public List<Direccion> getAllUserDirections(@WebParam(name = "user")Usuario user) {
        return udao.getAllUserDirections(user);
    }
    @WebMethod(operationName = "getDireccion")
    public Direccion getDireccion(@WebParam(name = "id")int id) {
        return udao.getDireccion(id);
    }
    @WebMethod(operationName = "getMetPago")
    public Metodopago getMetPago(@WebParam(name = "id")int id) {
        return udao.getMetPago(id);
    }
    @WebMethod(operationName = "createDireccion")
    public boolean createDireccion(@WebParam(name = "dir")Direccion dir) {
        return udao.createDireccion(dir);
    }
    @WebMethod(operationName = "updateDireccion")
    public void updateDireccion(@WebParam(name = "d")Direccion d) {
        udao.updateDireccion(d);
    }
    @WebMethod(operationName = "removeDireccion")
    public void removeDireccion(@WebParam(name = "name")Direccion d) {
        udao.removeDireccion(d);
    }
    @WebMethod(operationName = "getAllUserPayMethods")
    public List<Metodopago> getAllUserPayMethods(@WebParam(name = "user")Usuario user) {
        return udao.getAllUserPayMethods(user);
    }
    @WebMethod(operationName = "createMetodoPago")
    public boolean createMetodoPago(@WebParam(name = "mp")Metodopago mp) {
        return udao.createMetodoPago(mp);
    }
    @WebMethod(operationName = "updateMetodoPago")
    public void updateMetodoPago(@WebParam(name = "name")Metodopago mp) {
        udao.updateMetodoPago(mp);
    }
    @WebMethod(operationName = "removeMetodoPago")
    public void removeMetodoPago(@WebParam(name = "name") Metodopago mp) {
        udao.removeMetodoPago(mp);
    }
}
