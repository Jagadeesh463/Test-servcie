package com.mindtree;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.ClassOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import com.mindtree.entity.Student;
import com.mindtree.repo.StudentRepo;
import com.mindtree.service.StudentServiceImpl;
@SpringBootTest(classes={StudentApplication.class})
class StudentApplication {

	@Mock
	StudentRepo sturepo;
	@InjectMocks
	 StudentServiceImpl  studentServiceImpl;
	@Test
	@Order(1)
	public void test_getallstudents() {
		List<Student> s1 = new ArrayList<Student>();
		s1.add(new Student(1,"ajay",1,"m",23,1));
		s1.add(new Student(2,"bhagya",1,"m",21,102));
		when( sturepo.findAll()).thenReturn( s1 );
		 
		assertEquals(2,studentServiceImpl.getAllStudents().size());
	}
	
	@Test
	@Order(2)
	public void test_getallstudentbyId() {
		List<Student> s1 = new ArrayList<Student>();
		s1.add(new Student(1,"ajay",1,"m",23,1));
		s1.add(new Student(2,"bhagya",1,"m",21,102));
		int id1=1;
		when( sturepo.saveAll(s1)).thenReturn( s1 );
		//int id2= studentServiceImpl.getStudent(id1).getId();
		Student s=studentServiceImpl.getStudent(id1);
		int id2=s.getId();
		assertEquals(id1,id2);
		 
	}
	@Test
	@Order(3)
	public void test_addStudent()
	{
		Student s1=new Student(3,"b",1,"m",21,102);
		when( sturepo.save(s1)).thenReturn(s1);
		assertEquals(s1,studentServiceImpl.addStudent( 3, s1));
		
	}
	

}
