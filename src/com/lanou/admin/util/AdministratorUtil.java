package com.lanou.admin.util;

import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
/**
 * 
 * @author lanou
 *
 */
public class AdministratorUtil {
			public boolean islogin(){
					   HttpSession session=ServletActionContext.getRequest().getSession();
					   if (Integer.parseInt(session.getAttribute("loginStatus").toString())==1) {
						    return true;
					}
					   return false;
			}
}
