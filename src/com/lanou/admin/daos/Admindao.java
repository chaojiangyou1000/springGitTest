package com.lanou.admin.daos;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.lanou.admin.beans.Administrator;
import com.lanou.admin.beans.Literal;
import com.lanou.admin.beans.Users;
import com.lanou.admin.beans.UsersDonate;
import com.lanou.admin.dao.interfaces.IAdmindao;

/**
 * dao层
 * 
 * @author lanou
 *
 */
public class Admindao implements IAdmindao {

			private SessionFactory sessionFactory;

			/*
			 * 管理员登录方法（admin是个普通参数）
			 */
			@Override
			public boolean login(Administrator admin) {
		
						System.out.println("dao");
						// 打开session
						Session session = sessionFactory.getCurrentSession();
						// 开启事务
						Transaction tx = session.beginTransaction();						
						String hql = "from Administrator admin where admin.name=:name and admin.password=:password";
						@SuppressWarnings("unchecked")
						Query<Administrator> query = session.createQuery(hql);
						System.out.println("====================" + admin);
						query.setParameter("name", admin.getName());
						query.setParameter("password", admin.getPassword());
						List<Administrator> list = query.getResultList();
						// 提交事务
						tx.commit();					
						session.close();			
						if (list.size() > 0) {						
							return true;						
						}
						return false;														
			}
		
			/*
			 * 后台发表新闻信息
			 */
			@Override
			public boolean insertAll(Literal literal) {
						//打开session
					   Session session=sessionFactory.getCurrentSession();
					   //开启事务
					   Transaction tx=session.beginTransaction();
					   try {
						   //保存
						     session.save(literal);
						     //提交事务
						     tx.commit();
						     return true;
					} catch (Exception e) {
						  e.printStackTrace();
						  tx.rollback();
						  return false;
					}finally{
						session.close();
					}						
			}
			
			/*
			 * 获取数据库字段信息
			 */
			@SuppressWarnings("deprecation")
			@Override
			public List<Literal> gainSj() {						
						//打开session
					   Session session=sessionFactory.getCurrentSession();
					   //开启事务
					   Transaction tx=session.beginTransaction();
					   //实例化				
					   try {
						   String hql="from Literal literal";
						   @SuppressWarnings("unchecked")
						Query<Literal>query= session.createQuery(hql);							   
						   List<Literal> list= query.list();	
						   System.out.println("============"+list.get(0).getContents());
						   tx.commit();
						   System.out.println("================dao======================="+list);
						   return list;
					} catch (Exception e) {
							 e.printStackTrace();
							 tx.rollback();
							 return null;
					}finally{
						    session.close();						   
					}						   					
				
			}
			
			/*
			 * sessionFactory的get方法
			 */
			public SessionFactory getSessionFactory() {
				return sessionFactory;
			}
			
			/*
			 * sessionFactory的set方法
			 */
			public void setSessionFactory(SessionFactory sessionFactory) {
				this.sessionFactory = sessionFactory;
			}

			/**
			 * 修改密码
			 */
			@SuppressWarnings("deprecation")
			@Override
			public boolean modifyPwd(Administrator administrator, String changePwd) {
					Session session = sessionFactory.getCurrentSession();
					Transaction tx = session.beginTransaction();
					String hql = "from Administrator admin where admin.name = :name and admin.password = :password";
					@SuppressWarnings("unchecked")
					Query<Administrator> query = session.createQuery(hql);
					query.setParameter("name", administrator.getName());
					query.setParameter("password", administrator.getPassword());
					//调用方法得到一个集合
					List<Administrator> lists = query.list();
					//查看lists集合是否为空，再设置密码
					if (lists.size()>0) {
						administrator = session.get(Administrator.class, lists.get(0).getId());
						administrator.setPassword(changePwd);
						System.out.println(123);
						//提交事务
						tx.commit();
						//关闭
						session.close();
						return true;
					}else{
						return false;
					}
			}

			/*
			 * 客户捐赠
			 */
			@Override
			public boolean donateSome(UsersDonate usersDonate) {
					//创建session连接
				   Session session = sessionFactory.getCurrentSession();
				   //打开事务
				   Transaction tx = session.beginTransaction();
				   System.out.println(usersDonate+"===========");
				   try {
					   session.save(usersDonate);
					   tx.commit();
					   return true;
				} catch (Exception e) {
					e.printStackTrace();
					tx.rollback();
					return false;
				}finally{
					session.close();
				}
				  
			}
			
			/*
			 * 获取客户捐赠前台展示
			 */
			@Override
			public List<UsersDonate> getUserGain() {
					//创建session连接
					Session session = sessionFactory.getCurrentSession();
					//打开事务
					Transaction tx = session.beginTransaction();					
					try {
						String hql = "from UsersDonate usersDonate";
						@SuppressWarnings("unchecked")
						Query<UsersDonate> query = session.createQuery(hql);
						@SuppressWarnings("deprecation")
						List<UsersDonate> lists = query.list();
						tx.commit();
						return lists;
					} catch (Exception e) {
                        e.printStackTrace();
                        tx.rollback();
                        return null;
					}finally{
						session.close();
					}
					
			}
			
			/*
			 * 用户注册
			 */
			@Override
			public boolean registerUsers(Users users) {
					//创建session连接
					Session session = sessionFactory.getCurrentSession();
					//打开事务
					Transaction tx = session.beginTransaction();
					try {
						session.save(users);
						tx.commit();
						return true;
					} catch (Exception e) {
						e.printStackTrace();
						tx.rollback();
						return false;
					} finally {
						session.close();
					}
			}
			
			/*
			 * 用户登录
			 */
			@Override
			public boolean loginUsers(Users user) {
					//创建session连接
				 	Session session = sessionFactory.getCurrentSession();
				 	//打开事务
				 	Transaction tx = session.beginTransaction();
				 	System.out.println(123);
				 	
				 	String hql = "from Users user where user.names = :names and user.pwd = :pwd";
//				 	String hql = "select Users.names,Users.pwd from Users";
				 	@SuppressWarnings("unchecked")
				 	
					Query<Users> query = session.createQuery(hql);
				 	System.out.println(user);
				 	query.setParameter("names",user.getNames());
				 	query.setParameter("pwd", user.getPwd());
				 	
				 	List<Users> list = query.getResultList();
				 	tx.commit();
				 	session.close();
				 	if (list.size()>0) {
						return true;
					}
					return false;
			}

			
			

			

}
