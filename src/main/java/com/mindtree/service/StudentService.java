//Student-service-interface
package com.mindtree.service;

import java.util.List;

import com.mindtree.entity.Student;

public interface StudentService {
	
	public List<Student> getAllStudents();
	
	public Student getStudent(Integer id);
	
	public Student addStudent(Integer collId,Student stu);
	
	
	public List<Student> getStusListAscWithNames(int collId);
	
	public List<Student> getStusListDescWithAge(int collId);

	public List<Student> getStudents(int collId);

	List<Student> saveStudents(int collId, List<Student> stuList);

}
