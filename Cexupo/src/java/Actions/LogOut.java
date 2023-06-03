/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author alber
 */
public class LogOut extends ActionSupport implements SessionAware{
    
    private SessionMap<String, Object> sessionMap;

    public LogOut() {
    }
    
    public String execute() throws Exception {
        sessionMap.clear();
        return SUCCESS;
    }

      @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap) map;
    }
    
}
