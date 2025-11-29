package com.Jyotheesh.StudentController;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import StudentModel.Students;

import StudentSer.StudentServic;

@RestController
public class StudentController {

	@Autowired
	public StudentServic ss;

	@GetMapping("/userinformation")
	public List<Students> getuserDetails() throws SQLException {
		return ss.userinfo();
	}
}
