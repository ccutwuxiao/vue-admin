package com.example.vue.admin.model.antd;

public class User {

    /**
     * key : 1
     * name : John Brown
     * age : 32
     * address : New York No. 1 Lake Park
     */

    private String key;
    private String name;
    private int age;
    private String address;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
