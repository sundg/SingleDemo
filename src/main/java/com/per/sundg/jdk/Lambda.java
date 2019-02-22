package com.per.sundg.jdk;

import org.junit.jupiter.api.Test;

/**
 * <br>
 *
 * @ClassName: LambdaTest
 * @Description: lambda表达式学习
 * @Author sundg
 * @Date 2019/2/12 9:52
 * @VERSION 1.0
 */
public class Lambda {

    public static void main(String[] args) {

        System.out.println("dasd111");
    }

    @Test
    public void testTwo(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World!");
            }
        });

        new Thread(() -> System.out.println("Hello World123!"));
    }

    @Test
    public  void  testOne(){
        Lambda tester = new Lambda();

        // 类型声明
        MathOperation addition = (int a, int b) -> a + b;

        // 不用类型声明
        MathOperation subtraction = (a, b) -> a - b;

        // 大括号中的返回语句
        MathOperation multiplication = (int a, int b) -> { return a * b; };

        // 没有大括号及返回语句
        MathOperation division = (int a, int b) -> a / b;

        System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
        System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + tester.operate(10, 5, division));

        // 不用括号
        GreetingService greetService1 = message ->
                System.out.println("Hello " + message);

        // 用括号
        GreetingService greetService2 = (message) ->
                System.out.println("Hello " + message);

        greetService1.sayMessage("Runoob");
        greetService2.sayMessage("Google");

    }



        interface MathOperation {
            int operation(int a, int b);
        }

        interface GreetingService {
            void sayMessage(java.lang.String message);
        }

        private int operate(int a, int b, MathOperation mathOperation){
            return mathOperation.operation(a, b);
        }

}
