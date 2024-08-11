package com.klef.ep.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="courses_table")
public class Courses implements Serializable {
         @Id
         @Column(name="coursecode",length=50,nullable=false)
         private String coursecode;
         @Column(name="coursename",length=50,nullable=false)
         private String coursename;
         @Column(name = "coursetype",length=5,nullable=false)
         private String coursetype;
         @Column(name="coursedept",length=10,nullable=false)
         private String coursedept;
		public String getCoursecode() {
			return coursecode;
		}
		public void setCoursecode(String coursecode) {
			this.coursecode = coursecode;
		}
		public String getCoursename() {
			return coursename;
		}
		public void setCoursename(String coursename) {
			this.coursename = coursename;
		}
		public String getCoursetype() {
			return coursetype;
		}
		public void setCoursetype(String coursetype) {
			this.coursetype = coursetype;
		}
		public String getCoursedept() {
			return coursedept;
		}
		public void setCoursedept(String coursedept) {
			this.coursedept = coursedept;
		}
         
         
         
}
