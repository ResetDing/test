package net.wanho.dao.impl;

import net.wanho.dao.LoginLogDao;
import net.wanho.entity.LoginLog;
import net.wanho.util.JDBCTemplate;

public class LoginLogDaoImpl implements LoginLogDao {
    private  JDBCTemplate jdbcTemplate = new JDBCTemplate();
    private static final String INSERT_SQL =
            "INSERT INTO LOGIN_LOG(ACCOUNT, LOGIN_TIME) VALUE (?, SYSDATE())";
    @Override
    public int insert(LoginLog loginLog) {
        return jdbcTemplate.update(INSERT_SQL,
                loginLog.getAccount());
    }
}
