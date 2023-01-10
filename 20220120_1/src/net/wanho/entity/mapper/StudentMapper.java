package net.wanho.entity.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.wanho.entity.Student;
import net.wanho.util.RowMapper;

public class StudentMapper implements RowMapper<Student> {

	@Override
	public Student rowMap(ResultSet rs) {
		try {
			String sno = rs.getString("sno");
			String sname =  rs.getString("sname");
			String ssex = rs.getString("ssex");
			Student student = new Student();
			student.setSno(sno);
			student.setSname(sname);
			student.setSsex(ssex);
			return student;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
