package com.ait.boundaries;

public class SchoolDAO {
	private static StudentDAO sDAO = new StudentDB();
	
	public static StudentDAO getStudentDAO() {
		return sDAO;
	}
}
