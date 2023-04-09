package com.peterjxl.domain;

public class UserTest {
    private String name;
    private String gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHehe() {
        return gender;
    }

    public void setHehe(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "UserTest{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
