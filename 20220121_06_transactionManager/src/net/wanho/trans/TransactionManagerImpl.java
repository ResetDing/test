package net.wanho.trans;

import java.sql.Connection;
import java.sql.SQLException;

import net.wanho.util.DBUtil;

public class TransactionManagerImpl implements TransactionManager {

	@Override
	public void start() {
		Connection con = DBUtil.getConnection();
		try {
			con.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	@Override
	public void commit() {
		Connection con = DBUtil.getConnection();
		try {
			con.commit();
			con.setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(con);
		}

	}

	@Override
	public void rollback() {
		Connection con = DBUtil.getConnection();
		try {
			con.rollback();
			con.setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(con);
		}

	}

}
