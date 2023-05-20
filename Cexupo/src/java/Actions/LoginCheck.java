package Actions;

import DAO.UsuarioDao;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
  
import org.apache.struts2.dispatcher.SessionMap;  
import org.apache.struts2.interceptor.SessionAware;

public class LoginCheck extends ActionSupport implements SessionAware {
    private SessionMap<String,Object> sessionMap;  
    private String username;
    private String password;
    String sunombre;
    public static String NuSER;
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginCheck() {
    }

    public String execute() throws Exception {
         
        setNuSER(username);
        setSunombre(NuSER);
        
        if (isRegistered(this.getUsername(),this.getPassword())) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    private static boolean isRegistered(String name, String pass) {
        UsuarioDao udao = new UsuarioDao();
        
        return udao.isRegistered(name, pass);
    }
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
       public String logout(){
        NuSER=null;
        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> map) {
       sessionMap=(SessionMap)map;  
    }

}
