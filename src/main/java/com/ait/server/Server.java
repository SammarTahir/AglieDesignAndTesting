package com.ait.server;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;

import com.ait.entities.Student;

import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Server {
	private Connection con = null;
	private static Statement stmt = null;
	private PreparedStatement ps = null;

	public void initDBConnection() {
		try {
			//
			String url = "jdbc:mysql://localhost:3306/studentDB";
			con = DriverManager.getConnection(url, "root", "admin");
			stmt = con.createStatement();
			ps = con.prepareStatement("select * from studentDB");
		} catch (Exception e) {
			System.out.println("Failed to initialise DB Connection");
			System.exit(0);
		}
	}

	public static String listStudents() throws SQLException {
		ResultSet rs = stmt.executeQuery("select * from student;");
		StringBuilder resultText = new StringBuilder();

		while (rs.next()) {
			resultText.append("\nID: ").append(rs.getString(1)).append(" NAME: ").append(rs.getString(2))
					.append(" SUBJECT: ").append(rs.getString(3)).append(" GRADE: ").append(rs.getString(4));
		}
		return resultText.toString();
	}

	public static void addStudent(final int studentId, final String name, final String subject, final double grade)
			throws SQLException {
		String cmd = "INSERT INTO student VALUES ('" + studentId + "'," + " '" + name + "', '" + subject + "', '"
				+ grade + "')";
		stmt.execute(cmd);
	}

	public static String getStudent(final int studentId) throws SQLException {
		StringBuilder resultText = new StringBuilder();
		String cmd;
		ResultSet rs;

		cmd = "select * from student where id = " + studentId + ";";
		rs = stmt.executeQuery(cmd);

		while (rs.next()) {
			resultText.append("\nID: ").append(rs.getString(1)).append(" NAME: ").append(rs.getString(2))
					.append(" SUBJECT: ").append(rs.getString(3)).append(" GRADE: ").append(rs.getString(4));
		}
		return resultText.toString();
	}

	public static void removeStudent(final int studentId) throws SQLException {
		String cmd = "DELETE FROM student where id = " + studentId + ";";
		stmt.execute(cmd);
	}

	public static void updateStudent(final int studentId, final String name, final String subject, final double grade)
			throws SQLException {
		String cmd = "UPDATE student SET name = '" + name + "', subject = '" + subject + "', grade = '" + grade
				+ "' where id = " + studentId + ";";
		stmt.execute(cmd);
	}
}
