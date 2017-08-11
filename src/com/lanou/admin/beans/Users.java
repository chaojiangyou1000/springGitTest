package com.lanou.admin.beans;
/**
 * 
 * @author Administrator
 *
 */
public class Users {
		private String id;
		private String names;
		private String pwd;
		private String email;
		private Integer phone;
		private String realNames;
		
		
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getNames() {
			return names;
		}
		public void setNames(String names) {
			this.names = names;
		}
		public String getPwd() {
			return pwd;
		}
		public void setPwd(String pwd) {
			this.pwd = pwd;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		
		public String getRealNames() {
			return realNames;
		}
		public void setRealNames(String realNames) {
			this.realNames = realNames;
		}
		public Integer getPhone() {
			return phone;
		}
		public void setPhone(Integer phone) {
			this.phone = phone;
		}
		
}
