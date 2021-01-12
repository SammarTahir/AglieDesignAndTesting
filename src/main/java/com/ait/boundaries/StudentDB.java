package com.ait.boundaries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ait.entities.Student;

public class StudentDB implements StudentDAO {
	private final Map<Integer, Student> students;
	private final List<Student> studentList;
	
	protected StudentDB() {
		students = new HashMap<Integer, Student>();
		studentList = new ArrayList<Student>();
	}
	
	@Override
	public Student addStudent(final int studentId, final Student student) {
		students.put(studentId, student);
		return student;
	}

	@Override
	public Student getStudent(int studentId) {
		return students.get(studentId);
	}

	@Override
	public List<Student> getStudents() {
		studentList.clear();
		for (final Map.Entry student:students.entrySet()){
			studentList.add((Student) student.getValue());
		}
		return studentList;
		}
}
