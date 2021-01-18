package com.ait.boundaries;

import java.util.List;

import com.ait.entities.*;
import com.ait.server.Server;

public interface StudentDAO {
	Server addStudent(int studentId, Student student);
	Server getStudent(int studentId);
	Server removeStudent(int studentId);
	Server updateStudent(int studentId, Student student);
}
