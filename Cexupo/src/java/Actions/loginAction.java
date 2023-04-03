/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import com.opensymphony.xwork2.ActionSupport;
import DAO.UsuarioDao;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import static org.apache.struts2.ServletActionContext.getServletContext;
import org.hibernate.Session;
/**
 *
 * @author st
 */
public class loginAction extends ActionSupport {
    String usuario,password;
    Map user;
    String usGlobal;
    String sunombre;
   int cont=-1;
   public String pp;
   
   
    public static String NuSER;

    public String getSunombre() {
        
        return sunombre;
    }

    public void setSunombre(String sunombre) {
        
        this.sunombre = sunombre;
    }
    

    public static String getNuSER() {
        
        return NuSER;
    }

    public  void setNuSER( String NuSER) {
        this.NuSER = NuSER;
    }
    
    public String getPp() {
        pp=usuario;
        return pp;
    }

    public void setPp(String pp) {
        this.pp = pp;
    }
   
   

    public int getCont() {
        return cont;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }
    
   
   

    public String getUsGlobal() {

      return this.usGlobal;
        
    }

    
    
    
    public Map getUser() {
        return user;
    }

    public void setUser(Map user) {
        this.user = user;
    }
    



    
    
    
    public String getUsuario() {
        cont++;
        return usuario;
    }

    public void setUsuario(String usuario) {
        
        
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }
    public String metodo(){
        return getUsuario();
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String vacio(){
        return SUCCESS;
    }
    public String user(){
        return SUCCESS;
    }
    public loginAction() {
    }
    String datoRequest;
    String datoSesion;
    String datosAplicacion;

    public String getDatoRequest() {
        return datoRequest;
    }

    public void setDatoRequest(String datoRequest) {
        this.datoRequest = datoRequest;
    }

    public String getDatoSesion() {
        return datoSesion;
    }

    public void setDatoSesion(String datoSesion) {
        this.datoSesion = datoSesion;
    }

    public String getDatosAplicacion() {
        return datosAplicacion;
    }

    public void setDatosAplicacion(String datosAplicacion) {
        this.datosAplicacion = datosAplicacion;
    }
    
    public String execute() throws Exception {
        
        String a=getUsuario();
        //Almacen.setusrLog(usuario);
        
        setNuSER(usuario);
        setSunombre(NuSER);
        

        UsuarioDao udao=new UsuarioDao();
       if(a.equals(udao.getUser(a).getUsername())) {
           return SUCCESS;
       }
       else
           return ERROR;}
        
    public String logout(){
        NuSER=null;
        return SUCCESS;
    }
    
}
