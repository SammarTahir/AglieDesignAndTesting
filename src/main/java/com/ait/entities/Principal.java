package com.ait.entities;

import java.sql.SQLException;
import java.util.List;

import com.ait.boundaries.*;
import com.ait.server.Server;

public class Principal {

	public void addStudent(final int studentId, final String name, final String subject, final double grade)
			throws SQLException {
		Server.addStudent(studentId, name, subject, grade);
	}

	public String getStudent(final int studentId) throws SQLException {
		return Server.getStudent(studentId);

	}

	public String getStudents() throws SQLException {
		return Server.listStudents();
	}

	public void removeStudent(final int studentId) throws SQLException {
		Server.removeStudent(studentId);
	}

	public void updateStudent(final int studentId, final String name, final String subject, final double grade)
			throws SQLException {
		Server.updateStudent(studentId, name, subject, grade);
	}
	

}
