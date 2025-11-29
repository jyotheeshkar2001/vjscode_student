package StudentSer;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import StudentRepo.StudentRepository;
import StudentModel.Students;

@Service
public class StudentServic {

	@Autowired
	public StudentRepository sr;

	public List<Students> userinfo() throws SQLException {
		return sr.getUser();
	}
	
	public String insertUser(List<Students> student) throws SQLException {
		
		return sr.InsertStudent(student);
	}

	
	

}
