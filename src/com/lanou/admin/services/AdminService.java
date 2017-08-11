package com.lanou.admin.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lanou.admin.beans.Administrator;
import com.lanou.admin.beans.Literal;
import com.lanou.admin.beans.Users;
import com.lanou.admin.beans.UsersDonate;
import com.lanou.admin.daos.Admindao;
import com.lanou.admin.service.interfaces.IAdminService;

/**
 * 业务逻辑层
 * @author lanou
 *
 */
public class AdminService implements IAdminService{
				
				//实例化
				Map<String,Object>result=new HashMap<String,Object>();
				
				//实例化
				private Admindao dao;
				
				 /*
				  * 管理员登录方法
				  */
				@Override  
				public Map<String, Object> loginAll(Administrator admin) {
							System.out.println(456);							
							if (dao.login(admin)) {
								System.out.println("===========servic===============");
								result.put("status", 1);
								result.put("info", "登录成功");
							} else {
								result.put("status", 0);
								result.put("info", "登录失败");
							}
							System.out.println(12);
							return result;							
				}
				
				/*
				 * 向数据库插入数据的方法
				 */
				@Override
				public Map<String,Object> insert(Literal literal) {
						   if (dao.insertAll(literal)) {
							  result.put("status", 1);
							  result.put("info", "发表成功");
						} else {
							  result.put("status", 0);
							  result.put("info", "发表失败");
						}
						return result;
				}

				/*
				 * 获取数据库文本信息的方法
				 */
				@Override
				public Map<String, Object> gainNews() {
						System.out.println(123);
						
						System.out.println("====================service==============="+dao);	
						System.out.println("====================service======9999999999========="+dao.gainSj());	
						List<Literal> lists= dao.gainSj();
						System.out.println("====================service===============");	
						result.put("list", lists);
						return result;
				}
				
				/*
				 * dao的get方法
				 */
				public Admindao getDao() {
					return dao;
				}
				
				/*
				 * dao的set方法
				 */
				public void setDao(Admindao dao) {
					this.dao = dao;
				}

				/*
				 * 修改密码
				 */
				@Override
				public Map<String, Object> modifymm(Administrator administrator, String changePwd) {
						if (dao.modifyPwd(administrator, changePwd)) {
							result.put("status", 1);
							result.put("info", "修改成功");
							return result;
						}else{
							result.put("status", 0);
							result.put("info", "修改失败");
							return result;
						}					
				}
				
				/*
				 *客户捐赠 
				 */
				@Override
				public Map<String, Object> donateSomething(UsersDonate usersDonate) {
						if (dao.donateSome(usersDonate)) {
							result.put("status", 1);
							result.put("info", "添加成功");
							return result;
						}else{
							result.put("status", 0);
							result.put("info", "添加失败");
							return result;
						}
				}

				/*
				 * 获取客户捐赠前台展示
				 */
				@Override
				public Map<String, Object> getDonateSomething() {
					  List <UsersDonate> list =	dao.getUserGain();
					  result.put("lists", list);
					  return result;
				}

				/*
				 * 用户注册
				 */
				@Override
				public Map<String, Object> registerUsersService(Users users) {
						if (dao.registerUsers(users)) {
							result.put("ststus", 1);
							result.put("info", "注册成功");
							return result;
						} else {
							result.put("ststus", 0);
							result.put("info", "注册失败");
							return result;
						}
				}

				/*
				 *用户登录 
				 */
				@Override
				public Map<String, Object> loginUsersSome(Users user) {
						
						if (dao.loginUsers(user)) {
							result.put("ststus", 1);
							result.put("info", "登录成功");
							
							return result;
						} else {
							result.put("ststus", 0);
							result.put("info", "登录失败");
							System.out.println("service");
							
							return result;
						}
				}

				


}
