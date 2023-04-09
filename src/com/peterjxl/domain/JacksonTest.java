package com.peterjxl.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.util.*;

public class JacksonTest {

    @Test
    public void ObjectToJSON() throws Exception{
        Person p = new Person();
        p.setName("peter");
        p.setAge(18);
        p.setGender("男");

        // 2。创建jackon的核心对象 ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(p);
        System.out.println(json);

        mapper.writeValue(new File("Jackson.txt"), p);
        mapper.writeValue(new FileWriter("Jackson2.txt"), p);
    }

    @Test
    public void ObjectToJSON2() throws Exception{
        Person p = new Person();
        p.setName("peter");
        p.setAge(18);
        p.setGender("男");
        p.setBirthday(new Date());

        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(p));
    }

    @Test
    public void ObjectToJSON3() throws Exception{
        Person p = new Person("peter", 18,"男", new Date());
        Person p2 = new Person("peter2", 19,"男", new Date());
        Person p3 = new Person("peter3", 20,"男", new Date());
        List<Person> persons = new ArrayList<Person>();
        persons.add(p);
        persons.add(p2);
        persons.add(p3);

        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(persons));
    }

    @Test
    public void ObjectToJSON4() throws Exception{
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "张三");
        map.put("age", "23");
        map.put("gender", "男");

        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(map));
    }

    // 演示JSON字符串转为Java字符串
    @Test
    public void JSONToObject() throws Exception{
        // 1. 初始化JSON字符串
        String json ="{\"gender\":\"男\",\"name\":\"张三\",\"age\":\"23\"}";
        // 2.创建ObjectMapper
        ObjectMapper mapper = new ObjectMapper();

        // 3.转为Java对象
        Person person = mapper.readValue(json, Person.class);
        System.out.println(person);
    }
}
