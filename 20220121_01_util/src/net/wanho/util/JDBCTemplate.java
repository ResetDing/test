package net.wanho.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 数据库操作的模板
 * 
 * @author liuke
 *
 */
public class JDBCTemplate {

	public int update(String dml, Object... params) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = DBUtil.getConnection();     //静态方法通过类名调用
			pstm = conn.prepareStatement(dml);
			
			setParameter(pstm, params);
			
			int rows = pstm.executeUpdate();
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, pstm);
		}
		return 0;
	}
	
	public <T> List<T> queryForList(String dql, RowMapper<T> rm, Object... params) {
		Connection connection = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<T> list = new ArrayList<>();
		try {
			connection = DBUtil.getConnection();
			pstm = connection.prepareStatement(dql);
			setParameter(pstm, params);
			rs = pstm.executeQuery();
			while (rs.next()) {
				T t = rm.rowMap(rs);
				list.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection, pstm, rs);
		}
		return list;
	}
	
	/**
	 * 
	 * @param dql count语句
	 * @param rm
	 * @param params
	 * @return
	 */
	public Long count(String dql, Object... params) {
		Connection connection = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			connection = DBUtil.getConnection();
			pstm = connection.prepareStatement(dql);
			setParameter(pstm, params);
			rs = pstm.executeQuery();
			if (rs.next()) {
				return rs.getLong(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection, pstm, rs);
		}
		return 0L;
	}
	
	public <T> T queryForObject(String dql, RowMapper<T> rm, Object... params) {
		List<T> list = queryForList(dql, rm, params);
		if (list.size() > 1) {
			throw new RuntimeException("查到了多条记录");
		}
		if (list.size() == 1) {
			return list.get(0);
		} 
		return null;
	}

	private void setParameter(PreparedStatement pstm, Object... params) throws SQLException {
		for (int i = 0; i < params.length; i ++) {
			pstm.setObject(i + 1, params[i]);
		}
	}
}
