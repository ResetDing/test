package net.wanho.util;

import java.sql.Connection;

import org.junit.Test;

import junit.framework.Assert;

public class DBUtilTest {

	@Test
	public void test1() {
		Connection connection = DBUtil.getConnection();
		Assert.assertNotNull(connection);
	}

}
