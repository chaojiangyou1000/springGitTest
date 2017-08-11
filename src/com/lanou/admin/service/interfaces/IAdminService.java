package com.lanou.admin.service.interfaces;

import java.util.Map;

import com.lanou.admin.beans.Administrator;
import com.lanou.admin.beans.Literal;
import com.lanou.admin.beans.Users;
import com.lanou.admin.beans.UsersDonate;

/**
 * 接口类
 * @author lanou
 *
 */
public interface IAdminService {
			
	       
		   //管理员登录方法
	        public Map<String,Object> loginAll(Administrator administrator);
	         
	        //向数据库插入文本内容方法
	        public Map<String,Object> insert(Literal literal);
	        
	        //获取数据库信息的方法 
	        public Map<String,Object> gainNews();
	        
	        //修改密码
	        public Map<String,Object> modifymm(Administrator administrator,String changePwd);
	        
	        //客户捐赠
	        public Map<String,Object> donateSomething(UsersDonate usersDonate);
	        
	        //获取客户捐赠前台展示
	        public Map<String,Object> getDonateSomething();
	        
	        //用户注册
	        public Map<String, Object> registerUsersService(Users users);
	        
	        //用户登录
	        public Map<String, Object> loginUsersSome(Users users);
}
