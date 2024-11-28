package com.ssginc.login.service;

import com.ssginc.login.model.dao.LoginDAO;
import com.ssginc.login.model.dto.UsersDTO;
import com.ssginc.login.model.dto.UsersDTOTest;
import com.ssginc.util.HikariCPDataSource;

import javax.sql.DataSource;
import java.sql.Connection;

public class LoginServiceImpl implements LoginService {
//    DBConnectionMgr dbcp;
    DataSource dataSource;

    LoginDAO loginDAO;

    public LoginServiceImpl() {
//        dbcp =  new DBConnectionMgr(); // 싱글톤 인스턴스 활용
        loginDAO = new LoginDAO();
        dataSource = HikariCPDataSource.getInstance().getDataSource();
    }

    @Override
    public int insertUsers(UsersDTOTest user) {
        int res = 0;
        try(Connection con = dataSource.getConnection()) {
            res = loginDAO.insertUsers(con, user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    @Override
    public UsersDTO matchUsersId(String id) {
        UsersDTO user = null;
        try(Connection con = dataSource.getConnection()) {
            user = loginDAO.matchUsersId(con, id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public boolean matchUsersPw(UsersDTO users, String pwd) {
        return pwd.equals(users.getUsersPw());
    }

}
