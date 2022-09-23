//Student-service-interface
package com.mindtree.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.mindtree.entity.Student;
import com.mindtree.repo.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService {

	
	@Autowired
	StudentRepo sturepo;
	
	@Autowired
	RestTemplate template;
	
	private static final String URI="http://localhost:8100/college/";

	@Override
	public List<Student> getAllStudents(){
		return sturepo.findAll();
	}
	@Override
	public Student getStudent(Integer id) {
		Optional<Student> s = sturepo.findById(id);
			return s.get();
			
	}

	@Override
	public Student addStudent(Integer collId, Student stu) {
		
		stu.setCollId(collId);
		return sturepo.save(stu);
	}
	
	@Override
	public List<Student> getStudents(int collId) {
		List<Student> s1 = sturepo.findAll();
		List<Student> s2 = new ArrayList<>();
		
		for(Student s : s1) {
			if(s.getCollId()==collId)
				s2.add(s);
		}
		
		return s2;
	}

	@Override
	public List<Student> getStusListAscWithNames(int collId) {
		List<Student> s1 = sturepo.findAll(Sort.by(Direction.ASC, "name"));
		List<Student> s2 = new ArrayList<>();
		
		for(Student s : s2) {
			if(s.getCollId()==collId)
				s2.add(s);
		}
		
		return s2;
	}

	@Override
	public List<Student> getStusListDescWithAge(int collId) {
		List<Student> s1 = sturepo.findAll(Sort.by(Direction.DESC, "age"));
		List<Student> s2 = new ArrayList<>();
		
		for(Student s : s2) {
			if(s.getCollId()==collId)
				s2.add(s);
		}
		
		return s2;
	}

	@Override
	public List<Student> saveStudents(int collId, List<Student> stuList) {
		List<Student> s1 = new ArrayList<>();
		
		for(Student stu : stuList){
			stu.setCollId(collId);
			Student savedStu = sturepo.save(stu);
			s1.add(savedStu);
		}
		template.getForObject(URI+"update/count/"+collId+"/"+s1.size(), String.class);
		return s1;
	}

	
}
