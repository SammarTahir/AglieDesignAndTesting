package com.ait.entities;

import java.sql.SQLException;
import java.util.List;

import com.ait.boundaries.*;
import com.ait.server.Server;

public class Principal {
	StudentDAO database = SchoolDAO.getStudentDAO();
	
	public void addStudent(final int studentId, final String name, final String subject, final double grade) throws SQLException {
		final Student student = new Student(studentId, name, subject, grade);
		Server.addStudent(studentId, name, subject, grade);
		database.addStudent(studentId, student);
	}
	
	public Student getStudent(final int studentId) throws SQLException {
		System.out.println(Server.getStudent(studentId));
		return database.getStudent(studentId);
	
	}
	
	public List<Student> getStudents() throws SQLException{
		System.out.println(Server.listStudents());
		return database.getStudents();
	}
	
}
