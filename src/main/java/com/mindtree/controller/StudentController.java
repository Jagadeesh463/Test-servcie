//Student-Controller
package com.mindtree.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mindtree.entity.Student;
import com.mindtree.service.StudentService;

@RestController
@RequestMapping("/student") 
public class StudentController {

	@Autowired
	StudentService stuService;
	@GetMapping("/get")
	//GetAllStudents
	public ResponseEntity<?> displayStudents(){
		List<Student> stuList = stuService.getAllStudents(); 
		return new ResponseEntity<List<Student>>(stuList,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	//GetAllStudentsById
	public ResponseEntity<?> displayStudentById(@PathVariable("id") int id){
		try {
			Student stu = stuService.getStudent(id);
			return new ResponseEntity<Student>(stu,HttpStatus.OK);
		}
		catch(Exception s) {
			return new ResponseEntity<String>(s.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("/coll/{id}")
	//GetAllStudentsRespectiveCollege
	public ResponseEntity<?> displayStudentsFromColl(@PathVariable("id") int collId){
		List<Student> stuList = stuService.getStudents(collId);
		return new ResponseEntity<List<Student>>(stuList,HttpStatus.OK);
	}
	
	
	@GetMapping("/names/asc/{id}") 
	//GetStudentsFromCollNamesInAsc
	public ResponseEntity<?> GetStudentsFromCollNamesInAsc(@PathVariable("id") int collId){
		List<Student> stuList = stuService.getStusListAscWithNames(collId);
		return new ResponseEntity<List<Student>>(stuList,HttpStatus.OK);
	}
	
	@GetMapping("/age/desc/{id}")
	// GetStudentsFromCollWithAgeInDesc
	public ResponseEntity<?> GetStudentsFromCollWithAgeInDesc(@PathVariable("id") int collId){
		List<Student> stuList = stuService.getStusListDescWithAge(collId);
		return new ResponseEntity<List<Student>>(stuList,HttpStatus.OK);
	}
	
	@PostMapping("/{id}")
	//AddStudentById
	public ResponseEntity<?> addStudent(@PathVariable("id") int collId, @RequestBody Student s){
		Student stu = stuService.addStudent(collId,s);
		return new ResponseEntity<Student>(stu,HttpStatus.CREATED);
	}

	@PostMapping("/list/{id}")
	public ResponseEntity<?> addStudents(@PathVariable("id") int collId, @RequestBody List<Student> stuList){
		List<Student> savedStus = stuService.saveStudents(collId,stuList);
		return new ResponseEntity<List<Student>>(savedStus,HttpStatus.CREATED);
	}
	
	
}