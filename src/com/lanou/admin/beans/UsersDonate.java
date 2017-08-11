package com.lanou.admin.beans;
/**
 * 
 * @author lanou
 *
 */
public class UsersDonate {
		private String id;
		private Integer Money;
		private String type;
		private String time;
		private String name;
		
		public Integer getMoney() {
			return Money;
		}
		public void setMoney(Integer money) {
			Money = money;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getTime() {
			return time;
		}
		public void setTime(String time) {
			this.time = time;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		
		
		
}
