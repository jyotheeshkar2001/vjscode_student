package com.Jyotheesh.StudentController;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import StudentModel.Students;

import StudentSer.StudentServic;

@RestController
public class StudentController {

	@Autowired
	public StudentServic ss;
	
	/*
	 * get the student values from the Database
	 * 
	 */

	@GetMapping("/userinformation")
	public List<Students> getuserDetails() throws SQLException {
		return ss.userinfo();
		

	}
	
	/*
	 * Insert Student values to the database
	 * 
	 */
	
	@PostMapping("/inserinformation")
		public String InsertInfo(@RequestBody List<Students> st) throws SQLException {
		
		      
			return ss.insertUser(st);
			
		
	}
}
