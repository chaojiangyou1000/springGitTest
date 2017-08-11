package com.lanou.admin.dao.interfaces;

import java.util.List;

import com.lanou.admin.beans.Administrator;
import com.lanou.admin.beans.Literal;
import com.lanou.admin.beans.Users;
import com.lanou.admin.beans.UsersDonate;

/**
 * dao层的接口类
 * @author lanou
 *
 */
public interface IAdmindao {
			
			
	
	 		//管理员登录方法
		  	public boolean login(Administrator admin);
		  	
		  	//向数据库插入文本内容方法
		  	public boolean insertAll(Literal literal);
		  	
		  	//前台获取数据库
		  	public  List<Literal> gainSj();

		  	//修改密码
		  	public boolean modifyPwd(Administrator administrator,String changePwd);
		  	
		  	//客户捐赠
		  	public boolean donateSome(UsersDonate usersDonate);
		  	
		  	//获取客户捐赠前台展示
		  	public List<UsersDonate> getUserGain();
		  	
		  	//用户注册
		  	public boolean registerUsers(Users users);
		  	
		  	//用户登录
		  	public boolean loginUsers(Users user);
}
