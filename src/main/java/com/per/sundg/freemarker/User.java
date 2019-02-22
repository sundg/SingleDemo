package com.per.sundg.freemarker;

/**
 * <br>
 *
 * @ClassName: User
 * @Description: TODO
 * @Author sundg
 * @Date 2019/2/1 10:27
 * @VERSION 1.0
 */
public class User {

    private String username;
    private int age;
    private Record record;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }
}
