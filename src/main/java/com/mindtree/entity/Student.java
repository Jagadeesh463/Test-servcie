//Student-Entity
package com.mindtree.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name="Student_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	
		@Id
		@SequenceGenerator(name="Student_details_SEQ",initialValue = 1,allocationSize = 1)
		
	
				private int id;
				private String name;

				private int rollno;
				

				private String gender;

				private Integer age;
				private Integer collId;

				public Integer getId() {
					return id;
				}

				public void setId(Integer id) {
					this.id = id;
				}

				public String getName() {
					return name;
				}

				public void setName(String name) {
					this.name = name;
				}

				
				public String getGender() {
					return gender;
				}

				public void setGender(String gender) {
					this.gender = gender;
				}

				public Integer getAge() {
					return age;
				}

				public void setAge(Integer age) {
					this.age = age;
				}

				public int getRollno() {
					return rollno;
				}

				public void setRollno(int rollno) {
					this.rollno = rollno;
				}

				public Integer getCollId() {
					return collId;
				}

				public void setCollId(Integer collId) {
					this.collId = collId;
				}

				public Student(int id, String name, int rollno, String gender, Integer age, Integer collId) {
					super();
					this.id = id;
					this.name = name;
					this.rollno = rollno;
					this.gender = gender;
					this.age =age;
					this.collId = collId;
				}

				public Student() {
					super();
					// TODO Auto-generated constructor stub
				}

						
				
		}


