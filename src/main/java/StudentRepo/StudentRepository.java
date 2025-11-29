package StudentRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import StudentModel.Students;

@Repository
public class StudentRepository {

	@Autowired
	DataSource datasource;

	public List<Students> getUser() throws SQLException {

		Connection con = datasource.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("Select * from student");
		List<Students> list = new ArrayList<>();

		while (rs.next()) {

			Students student = new Students();
			student.setId(rs.getInt("id"));
			student.setName(rs.getString("name"));
			student.setPlace(rs.getString("place"));

			list.add(student);
		}

		return list;
	}
	
	public String InsertStudent(List<Students> sts) throws SQLException {
		
		String sql="insert into student (id,name,place) values(?,?,?)";
		Connection con = datasource.getConnection();
		PreparedStatement st = con.prepareStatement(sql);
		for(Students s: sts) {
			st.setInt(1, s.getId());
			st.setString(2,s.getName());
			st.setString(3,s.getPlace());
			 st.executeUpdate();
		}
		return "Insert done";
	}

}
