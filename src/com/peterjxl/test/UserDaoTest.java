package com.peterjxl.test;

import com.peterjxl.dao.UserDao;
import com.peterjxl.domain.User;
import org.junit.Test;

public class UserDaoTest {
    @Test
    public void testLogin(){
        User loginUser = new User();
        loginUser.setName("peterjxl");
        loginUser.setPassword("123456");

        UserDao dao = new UserDao();
        User user = dao.login(loginUser);
        System.out.println(user);
    }
}
