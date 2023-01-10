package net.wanho.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import net.wanho.dao.StudentDao;
import net.wanho.entity.Student;
import net.wanho.entity.mapper.StudentMapper;
import net.wanho.util.DBUtil;
import net.wanho.util.JDBCTemplate;
import net.wanho.util.RowMapper;

public class StudentDaoImpl implements StudentDao {
	private static final String STUDENT_INSERT_SQL = "insert into Student (sno, sname, dname, sage, ssex) value (?, ?, ?, ?, ?)";
	private static final String STUDENT_UPDATE_SQL = "update student set sname = ?, dname = ?, sage = ?, ssex = ? where sno = ?";
	private static final String STUDENT_DELETE_SQL = "DELETE FROM STUDENT WHERE SNO = ?";
	
	private JDBCTemplate jdbcTemplate = new JDBCTemplate();

	RowMapper<Student> rowMapper = new StudentMapper();
	
	@Override
	public int insert(Student student) {
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = DBUtil.getConnection();
			pstm = conn.prepareStatement(STUDENT_INSERT_SQL);
			pstm.setString(1, student.getSno());
			pstm.setString(2, student.getSname());
			pstm.setString(3, student.getDname());
			pstm.setInt(4, student.getSage());
			pstm.setString(5, student.getSsex());
			int rows = pstm.executeUpdate();
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, pstm);
		}
		return 0;
	}

	@Override
	public int update(Student student) {
		int rows = jdbcTemplate.update(STUDENT_UPDATE_SQL, student.getSname(), 
				student.getDname(), student.getSage(), student.getSsex(), student.getSno());
		return rows;
	}

	@Override
	public int delete(String sno) {
		int rows = jdbcTemplate.update(STUDENT_DELETE_SQL, sno);
		return rows;
	}

	@Override
	public List<Student> queryAll() {
		String sql = "select * from student";
		return jdbcTemplate.queryForList(sql, rowMapper);
	}

	@Override
	public Student queryOne(String sno) {
		String sql = "select * from student where sno = ?";
		List<Student> list = jdbcTemplate.queryForList(sql, rowMapper, sno);
		return list.isEmpty() ? null : list.get(0);
	}

}
