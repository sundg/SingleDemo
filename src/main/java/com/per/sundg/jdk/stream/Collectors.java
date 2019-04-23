package com.per.sundg.jdk.stream;




import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Classname Collectors
 * @Description TODO
 * @Date 2019/4/23 16:12
 * @Created sundg
 */
public class Collectors {


  public static void main(String[] args) {


    List strings = new ArrayList();
    strings.add("a");
    strings.add("bb");
    strings.add("cc");
    strings.add("ddd");

    Object collect = strings.stream().
        collect(java.util.stream.Collectors.groupingBy(String::length, java.util.stream.Collectors.summingInt(String::hashCode)));

    System.out.println(collect);
  }


  @Test
  public void test() {
    User user1 = new User("zhangsan", "beijing", 10);
    User user2 = new User("zhangsan", "beijing", 20);
    User user3 = new User("lisi", "shanghai", 30);
    List<User> list = new ArrayList<User>();
    list.add(user1);
    list.add(user2);
    list.add(user3);
    Map<String, List<User>> collect = list.stream().collect(java.util.stream.Collectors.groupingBy(e -> fetchGroupKey(e)));
    //{zhangsan#beijing=[User{age=10, name='zhangsan', address='beijing'}, User{age=20, name='zhangsan', address='beijing'}],
    // lisi#shanghai=[User{age=30, name='lisi', address='shanghai'}]}
    System.out.println(collect);
  }
  private static String fetchGroupKey(User user){
    return user.getName() +"#"+ user.getAddr();
  }


  static class User {

    private String name;
    private String addr;
    private int age ;

    public User(String name, String addr, int age) {
      this.name = name;
      this.addr = addr;
      this.age = age;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getAddr() {
      return addr;
    }

    public void setAddr(String addr) {
      this.addr = addr;
    }

    public int getAge() {
      return age;
    }

    public void setAge(int age) {
      this.age = age;
    }
  }
}
