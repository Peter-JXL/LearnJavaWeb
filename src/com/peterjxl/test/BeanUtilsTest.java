package com.peterjxl.test;
import com.peterjxl.domain.User;
import com.peterjxl.domain.UserTest;
import org.apache.commons.beanutils.BeanUtils;
/**
 * 演示BeanUtils的使用
 */
public class BeanUtilsTest {
    public static void main(String[] args) throws Exception{
        User user = new User();
        BeanUtils.setProperty(user, "name", "peterjxl");
        System.out.println(user);

        String name = BeanUtils.getProperty(user, "name");
        System.out.println(name);


        UserTest userTest= new UserTest();
        BeanUtils.setProperty(userTest, "hehe", "male");
        System.out.println(userTest);
        String gender = BeanUtils.getProperty(userTest, "hehe");
        System.out.println(gender);
    }
}