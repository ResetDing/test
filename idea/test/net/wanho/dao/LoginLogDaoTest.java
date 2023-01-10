package net.wanho.dao;

import net.wanho.dao.impl.LoginLogDaoImpl;
import net.wanho.entity.LoginLog;
import org.junit.Test;

public class LoginLogDaoTest {
    private LoginLogDao loginLogDao = new LoginLogDaoImpl();
    @Test
    public void testInsert(){
        LoginLog loginLog = new LoginLog();
        loginLog.setAccount("zhangsan");
        loginLogDao.insert(loginLog);
    }
}
