package com.per.sundg.jdk.stream;




import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collector;

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
    List<User> list = generateUser();

    Map<String, List<User>> collect = list.stream().collect(java.util.stream.Collectors.groupingBy(e -> fetchGroupKey(e)));
    Set<Map.Entry<String, List<User>>> entries = collect.entrySet();
    for (Map.Entry<String,List<User>> entry : entries) {
      List<User> users = entry.getValue();
      int count =0;
      for (User user :users){
        count += Integer.parseInt(user.getAge());
      }
      System.out.println(entry.getKey() +"   "+ count);
    }
  }
  private static String fetchGroupKey(User user){
    return user.getName() +"#"+ user.getAddr();
  }


  /**
   * @author sundg
   * @date 2019/4/23 17:29
   * @description 对同一对象的多个字段进行分组，并且按某一个字段进行求和
   * @return : void
   */
  @Test
  public void test1(){
    List<User> users = generateUser();
    users.stream().collect(java.util.stream.Collectors.groupingBy(user ->new User(user.getName(),user.getAddr()),
        java.util.stream.Collectors.summarizingInt(user -> Integer.parseInt(user.age))))
        .forEach((k,v)->{
          long sum = v.getSum();
          k.age = sum+"";
          System.out.println(k);
          //System.out.println(v);
        });
  }


  private List<User> generateUser(){
    User user1 = new User("zhangsan", "beijing", 10+"","1");
    User user2 = new User("zhangsan", "beijing", 20+"","2");
    User user3 = new User("lisi", "shanghai", 30+"","3");
    User user4 = new User("lisi", "shanghai", 60+"","4");
    List<User> list = new ArrayList<User>();
    list.add(user1);
    list.add(user2);
    list.add(user3);
    list.add(user4);
    return list;
  }
  static class User {

    private String name;
    private String addr;
    private String age ;
    private String add ;

    public User(String name, String addr, String age,String add) {
      this.name = name;
      this.addr = addr;
      this.age = age;
      this.add = add;
    }

    public User(String name, String addr, String add) {
      this.name = name;
      this.addr = addr;
      this.add = add;
    }

    public User(String name, String addr) {
      this.name = name;
      this.addr = addr;
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

    public String getAge() {
      return age;
    }

    public void setAge(String age) {
      this.age = age;
    }

    public String getAdd() {
      return add;
    }

    public void setAdd(String add) {
      this.add = add;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      User user = (User) o;
      return age == user.age &&
          Objects.equals(name, user.name) &&
          Objects.equals(addr, user.addr) &&
          Objects.equals(add, user.add);
    }

    @Override
    public int hashCode() {
      return Objects.hash(name, addr, age, add);
    }

    @Override
    public String toString() {
      return "User{" +
          "name='" + name + '\'' +
          ", addr='" + addr + '\'' +
          ", age=" + age +
          ", add='" + add + '\'' +
          '}';
    }
  }
}
