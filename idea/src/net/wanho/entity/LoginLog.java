package net.wanho.entity;

import java.util.Date;

public class LoginLog {

    private Integer id;
    private String account;
    private Date loginTime;

    public LoginLog(){
    }

    public LoginLog(String account, Date loginTime){
        this.account = account;
        this.loginTime = loginTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }
}
