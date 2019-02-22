package com.per.sundg.jdk;

import java.lang.Integer;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * <br>
 *
 * @ClassName: Stream
 * @Description: java8Stream流学习
 * @Author sundg
 * @Date 2019/2/13 17:16
 * @VERSION 1.0
 */
public class Stream {

    private void learnStream(){
        List<Integer> lists = new ArrayList<>();
        //首先,创建一个1-6乱序的List
        lists.add(4);
        lists.add(3);
        lists.add(6);
        lists.add(1);
        lists.add(5);
        lists.add(2);

        //看看List里面的数据是什么样子的先
        System.out.println("List里面的数据:");
        for (Integer elem : lists){
            System.out.print(elem + "");
        }
        System.out.println();
        //最小值
        System.out.print("List中最小的值为:");
        java.util.stream.Stream<Integer>  stream = lists.stream();
        Optional<Integer> min = stream.min(Integer::compareTo);

    }
}

