package net.wanho.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.wanho.dao.TeacherDao;
import net.wanho.entity.Teacher;

public class TeacherDaoImpl implements TeacherDao{

	@Override
	public int insert(Teacher teacher) {
		Connection connection = null;
		PreparedStatement pstm = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", "root", "root");
			String sql = "insert into teacher (tno, tname, dname, sal, age, tsex) value (?, ?, ?, ?, ?, ?)";
			pstm = connection.prepareStatement(sql);
			pstm.setString(1, teacher.getTno());
			pstm.setString(2, teacher.getTname());
			pstm.setString(3, teacher.getDname());
			pstm.setInt(4, teacher.getSal());
			pstm.setInt(5, teacher.getAge());
			pstm.setString(6, teacher.getTsex());
			int rows = pstm.executeUpdate();
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public int update(Teacher teacher) {
		Connection connection = null;
		PreparedStatement pstm = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "1234");
			String sql = "update teacher set tname = ?, dname = ?, sal = ?, age = ?, tsex = ? where tno = ?";
			pstm = connection.prepareStatement(sql);
			pstm.setString(1, teacher.getTname());
			pstm.setString(2, teacher.getDname());
			pstm.setInt(3, teacher.getSal());
			pstm.setInt(4, teacher.getAge());
			pstm.setString(5, teacher.getTsex());
			pstm.setString(6, teacher.getTno());
			int rows = pstm.executeUpdate();
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public int delete(String tno) {
		Connection connection = null;
		PreparedStatement pstm = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "1234");
			String sql = "delete from teacher where tno = ?";
			pstm = connection.prepareStatement(sql);
			pstm.setString(1, tno);
			int rows = pstm.executeUpdate();
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public List<Teacher> queryAll() {
		Connection connection = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<Teacher> list = new ArrayList<>();
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "1234");
			String sql = "select tno, tname, dname, sal, age, tsex from teacher";
			pstm = connection.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				String tno = rs.getString("tno");
				String tname = rs.getString("tname");
				String dname = rs.getString("dname");
				Integer sal = rs.getInt("sal");
				Integer age = rs.getInt("age");
				String tsex = rs.getString("tsex");
				
				Teacher teacher = new Teacher();
				teacher.setTno(tno);
				teacher.setTname(tname);
				teacher.setDname(dname);
				teacher.setSal(sal);
				teacher.setAge(age);
				teacher.setTsex(tsex);
				
				list.add(teacher);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			try {
				if(pstm != null) {
					pstm.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public Teacher queryOne(String tno) {
		Connection connection = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", "root", "root");
			String sql = "select tno, tname, dname, sal, age, tsex from teacher where tno = ?";
			pstm = connection.prepareStatement(sql);
			pstm.setString(1, tno);
			rs = pstm.executeQuery();
			if (rs.next()) {
				String tname = rs.getString("tname");
				String dname = rs.getString("dname");
				Integer sal = rs.getInt("sal");
				Integer age = rs.getInt("age");
				String tsex = rs.getString("tsex");
				
				Teacher teacher = new Teacher();
				teacher.setTno(tno);
				teacher.setTname(tname);
				teacher.setDname(dname);
				teacher.setSal(sal);
				teacher.setAge(age);
				teacher.setTsex(tsex);
				
				return teacher;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			try {
				if(pstm != null) {
					pstm.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public Teacher queryOne() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
