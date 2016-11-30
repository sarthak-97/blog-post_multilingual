package org.hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
@Entity
public class post {

		@Id @GeneratedValue
		int id;
		private String mob;
		@Lob
		private String posts;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getMob() {
			return mob;
		}
		public void setMob(String mob) {
			this.mob = mob;
		}
		public String getPosts() {
			return posts;
		}
		public void setPosts(String posts) {
			this.posts = posts;
		}
		
		
}
