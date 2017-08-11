package com.lanou.admin.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import com.lanou.admin.beans.Administrator;
import com.lanou.admin.beans.Literal;
import com.lanou.admin.beans.Users;
import com.lanou.admin.beans.UsersDonate;
import com.lanou.admin.service.interfaces.IAdminService;
import com.lanou.admin.util.AdministratorUtil;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 
 * @author lanou
 *
 */
@SuppressWarnings("serial")
public class AdminAction extends ActionSupport implements SessionAware{
			
			//实例化用于接收结果集
		    public Map<String,Object>result;
			public Map<String,Object>session;	      
			//实例化(administrator是个对象)
			public Administrator administrator;
			//实例化
			@Autowired
		    public IAdminService adminService;
			public AdministratorUtil util;	
			//文本类实例化
			public Literal literal;
			//修改密码
			public String changePwd;
			//捐赠用户
			public UsersDonate usersDonate;
			//用户注册
			public Users users;
			
			/*
			 * 管理员登录
			 */
			public String login(){
						System.out.println(123);
						//调用方法，接收结果集
						result=adminService.loginAll(administrator);						
						return "loginSUCCESS";				         
			}
			          
//			public String islogin(){
//						result=new HashMap<String,Object>();
//						result.put("islogin",util.islogin());
//						return SUCCESS;
//			}

			/*
			 * 发表内容的方法(管理员的登录)
			 */
			public String insertAd(){
						result= adminService.insert(literal);	
						System.out.println("action");
						return SUCCESS;
			}
			
			/*
			 * 获取数据库文本信息方法
			 */
		    public String gainMessage(){
		    			System.out.println("========================="+456);
		    			result = adminService.gainNews(); 
		    			System.out.println("========================="+7777777);
						return "gainMessageSuccess";		    	
		    }
			
			/*
			 * 修改密码
			 */
		    public String modify(){
		    		result = adminService.modifymm(administrator, changePwd);
		    		return "modifySUCCESS";
		    }
		    
		    /*
		     * 客户捐赠
		     */
		    public String donate(){
		    		result = adminService.donateSomething(usersDonate);
		    		System.out.println(usersDonate);
		    		System.out.println(123);
		    		return "donateSUCCESS";
		    }
		    
		    /*
		     * 获取客户捐赠前台展示
		     */
		    public String getDonate(){
		    	   result = adminService.getDonateSomething();
		    	   return "getDonateSUCCESS";
		    }
		    
		    /*
		     * 用户注册
		     */
		    public String register(){
		    		result = adminService.registerUsersService(users);
		    		return "registerSUCCESS";
		    }
		    
		    /*
		     * 用户登录
		     */
		    public String yhDl(){
		    	System.out.println(users);
		    		System.out.println(789);
		    	 	result = adminService.loginUsersSome(users);
		    	 	System.out.println(456);
		    	 	//判断登录状态是否为1
					if (Integer.parseInt(result.get("ststus").toString())==1) {
						       session.put("loginStatus", 1);
						       session.put("admins", users);
					}
		    	 	return "loginabcSUCCESS";
		    }
		    
		    /*
		     * 向前台发送用户名
		     */
		    public String getUsersName(){
		    		Users user = (Users) session.get("admins");
		    		Map<String,Object> map = new HashMap<>();
		    		map.put("username", user.getNames());
		    		result = map;
		    		return "getUsersNameSUCCESS";
		    }
		    
			public Map<String,Object> getResult() {
				return result;
			}

			public void setResult(Map<String,Object> result) {
				this.result = result;
			}

			public Map<String, Object> getSession() {
				return session;
			}

			public void setSession(Map<String, Object> session) {
				this.session = session;
			}
			/*
			 * administrator的get方法
			 */
			public Administrator getAdministrator() {
				return administrator;
			}
			/*
			 * administrator的set方法
			 */
			public void setAdministrator(Administrator administrator) {
				this.administrator = administrator;
			}
			
			/*
			 * adminService的get方法
			 */
			public IAdminService getAdminService() {
				return adminService;
			}			
			/*
			 * adminService的set方法
			 */
			public void setAdminService(IAdminService adminService) {
				this.adminService = adminService;
			}
			/*
			 * literal的get方法
			 */
			public Literal getLiteral() {
				return literal;
			}
			/*
			 * literal的set方法
			 */
			public void setLiteral(Literal literal) {
				this.literal = literal;
			}
			/*
			 * changePwd的get方法
			 */
			public String getChangePwd() {
				return changePwd;
			}
			/*
			 * changePwd的set方法
			 */
			public void setChangePwd(String changePwd) {
				this.changePwd = changePwd;
			}
			/*
			 * usersDonate的get方法
			 */
			public UsersDonate getUsersDonate() {
				return usersDonate;
			}
			/*
			 * usersDonate的set方法
			 */
			public void setUsersDonate(UsersDonate usersDonate) {
				this.usersDonate = usersDonate;
			}
			
			public Users getUsers() {
				return users;
			}

			public void setUsers(Users users) {
				this.users = users;
			}

		
					
												
}
