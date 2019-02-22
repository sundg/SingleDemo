package com.per.sundg.exception;

/**
 * <br>
 *
 * @ClassName: ExceptionDemo
 * @Description: TODO
 * @Author sundg
 * @Date 2019/2/21 17:16
 * @VERSION 1.0
 */
public class ExceptionDemo {

    public static void main(String[] args) {
       String a = deleteById("2");
       System.out.println(a);
    }


    public static String deleteById(String one) {
        String result = "";
        try{
            if ("1".equals(one)) {
                result = "1";
            } else {
                result = "2";
                throw new RuntimeException();
            }
        }catch (Exception e){
            result = "网络异常";
            e.printStackTrace();
            throw new RuntimeException();
            //return "网络异常";
        }

        return result;
    }
}
