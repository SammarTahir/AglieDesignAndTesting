package com.ait.boundaries;

import java.util.List;

import com.ait.entities.*;

public interface StudentDAO {
	Student addStudent(int studentId, Student student);
	Student getStudent(int studentId);
	List<Student> getStudents();
}
