package com.per.sundg.operator;

/**
 * @Classname ShiftOperator
 * @Description 移位操作
 * @Date 2019/4/8 17:03
 * @Created sundg
 */
public class ShiftOperator {


  public static void main(String[] args) {
    /**
     * <<      :     左移运算符，num << 1,相当于num乘以2
     * >>      :     右移运算符，num >> 1,相当于num除以2
     * >>>    :     无符号右移，忽略符号位，空位都以0补齐
     *
     * 负数的二进制是以补码的形式表示
     *    补码计算方法：
     *        step1： 取绝对值计算原码
     *        step2： 原码取反，得到反码
     *        step3： 反码加1，得到补码
     *        step4： 补码就是负数在计算机中的二进制表示方法
     */
    int i = 4;
    int j = i >> 1;
    System.out.println(j);
    int m = i << 1;
    System.out.println(m);
    int n = i >>> 1;
    System.out.println(n);
    /****************/
    i = -4;
    System.out.println(Integer.toBinaryString(i));
    j = i >> 1;
    System.out.println(j);
    m = i << 1;
    System.out.println(m);
    n = i >>> 1;
    System.out.println(n);
  }
}
