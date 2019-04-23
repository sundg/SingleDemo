package com.per.sundg.jdk.stream;


import org.apache.log4j.Logger;
import org.junit.Test;

import java.lang.Integer;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <br>
 *
 * @ClassName: Stream
 * @Description: java8Stream流学习
 * @Author sundg
 * @Date 2019/2/13 17:16
 * @VERSION 1.0
 */
public class StreamTest {

    private static final Logger LOGGER = Logger.getLogger(StreamTest.class);

    /**
     * stream流初体验
     * @Author sundg
     * @Date 2019/2/28 16:26
     * @Param []
     * @return void
     * @VERSION 1.0
     **/
    @Test
    public void learnStream(){
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
            System.out.print(elem + "  ");
        }
        System.out.println();
        //最小值
        System.out.print("List中最小的值为:");
        Stream<Integer> stream = lists.stream();
        Optional<Integer> min = stream.min(Integer::compareTo);
        if (min.isPresent()){
            System.out.println(min.get());
        }

        System.out.print("List中最大的值为:");
        /*Optional<Integer> max = lists.stream().max(Integer :: compareTo);
        if (max.isPresent()){
            System.out.println(max.get());
        }*/
        lists.stream().max(Integer :: compareTo).ifPresent(System.out :: println);

        LOGGER.info("将list流进行排序：");
        Stream<Integer> sorted = lists.stream().sorted();
        sorted.forEach(elem -> System.out.print(elem + "  "));

        System.out.println();
        LOGGER.info("过滤List流,只剩下那些大于3的元素:");
        lists.stream().filter(elem -> elem>3).forEach(elem -> System.out.print(elem + "  "));

        System.out.println();
        LOGGER.info("过滤List流,只剩下那些大于0并且小于4的元素:");
        lists.stream().filter(emle -> emle >0).filter(elem -> elem<4).forEach(elem -> System.out.print(elem + "  "));

        System.out.println();
        LOGGER.info("原List里面的数据:");
        for (Integer elem : lists){
            System.out.print(elem + "  ");
        }
    }

    /**
     * stream流的缩减操作
     * @Author sundg
     * @Date 2019/2/28 16:27
     * @Param []
     * @return void
     * @VERSION 1.0
     **/
    @Test
    public void learnReduceStream(){
        List<Integer> lists = new ArrayList<>();
        //首先,创建一个1-6乱序的List
        lists.add(4);
        lists.add(3);
        lists.add(6);
        lists.add(1);
        lists.add(5);
        lists.add(2);

        Optional<Integer> sum = lists.stream().reduce((a, b) -> a + b);
        if (sum.isPresent()) {
            System.out.println("lists的总和为："+ sum.get());
        }

        Integer sum2 = lists.stream().reduce(0, (a, b) -> a + b);
        System.out.println("lists的总和为："+sum2);

        Optional<Integer> product = lists.stream().reduce((a, b) -> a * b);
        if (product.isPresent()) {
            System.out.println("lists的乘积为："+product.get());
        }

        Integer product2 = lists.stream().reduce(1, (a, b) -> a * b);
        System.out.println("lists的乘积为："+product2);

        Optional<Integer> product3 = lists.stream().reduce((a, b) -> {
            if (b % 2 == 0) {
                return a * b;
            } else {
                return a;
            }
        });
        if (product3.isPresent()) {
            System.out.println("list的偶数的积为:"+product3.get());
        }
        Integer product4 = lists.stream().reduce(1, (a, b) -> {
            if (b % 2 == 0) {
                return a * b;
            } else {
                return a;
            }
        });
        System.out.println("list的偶数的积为:"+product4);
    }

    /**
     * 并行流操作
     * @Author sundg
     * @Date 2019/2/28 16:27
     * @Param []
     * @return void
     * @VERSION 1.0
     **/
    @Test
    public void learnParallelStream(){
        List<Integer> lists = new ArrayList<>();
        //首先,创建一个1-6乱序的List
        lists.add(4);
        lists.add(3);
        lists.add(6);
        lists.add(1);
        lists.add(5);
        lists.add(2);

        Optional<Integer> sum = lists.parallelStream().reduce((a, b) -> a + b);
        if (sum.isPresent()){
            System.out.println("lists的总和为："+ sum.get());
        }

        Integer sum2 = lists.stream().reduce(0, (a, b) -> a + b);
        System.out.println("lists的总和为："+sum2);

        Optional<Integer> product = lists.stream().reduce((a, b) -> a * b);
        if (product.isPresent()) {
            System.out.println("lists的乘积为："+product.get());
        }

        Integer product2 = lists.parallelStream().reduce(1, (a, b) -> a * b);
        System.out.println("lists的乘积为："+product2);

        Integer product3 = lists.parallelStream().reduce(1, (a, b) -> a * b, (a, b) -> a * b);
        System.out.println("lists的乘积为："+product3);

        //现在的需求是分别让List里面的每个元素都放大两倍后，再求积
        Integer product4 = lists.parallelStream().reduce(1, (a, b) -> a * (b * 2), (a, b) -> a * b);
        System.out.println("lists放大2倍之后的乘积为："+product4);
    }


    /**
     * stream流map映射
     * @Author sundg
     * @Date 2019/2/28 16:29
     * @Param []
     * @return void
     * @VERSION 1.0
     **/
    @Test
    public void learnStreamMap(){
        List<Integer> lists = new ArrayList<>();
        lists.add(1);
        lists.add(2);
        lists.add(3);

        //使用并行流处理
        Integer product = lists.parallelStream().reduce(1, (a, b) -> a * (b * 2), (a, b) -> a * b);
        System.out.println("lists放大2倍之后的乘积为："+product);

        //使用映射处理
        Stream<Integer> productNewMapStream = lists.parallelStream().map((a) -> 2 * a);
        Integer productMap = productNewMapStream.reduce(1, (a, b) -> a * b);
        System.out.println("lists放大2倍之后的乘积为："+productMap);
    }

    /**
     * stream流map映射
     * @Author sundg
     * @Date 2019/2/28 17:14
     * @Param []
     * @return void
     * @VERSION 1.0
     **/
    @Test
    public void learnStreamMap2th(){
        List<HeroPlayerGold> lists = new ArrayList<HeroPlayerGold>();
        lists.add(new HeroPlayerGold("盖伦1","RNG-Letme1",100));
        lists.add(new HeroPlayerGold("盖伦2","RNG-Letme2",110));
        lists.add(new HeroPlayerGold("盖伦3","RNG-Letme3",120));
        lists.add(new HeroPlayerGold("盖伦4","RNG-Letme4",130));
        lists.add(new HeroPlayerGold("盖伦5","RNG-Letme5",140));
        //计算团队经济
        int teamGold = lists.stream().map(player -> new Gold(player.getGold()))
                .mapToInt(Gold::getGold)
                .reduce(0, (a, b) -> a + b);
        System.out.println("团队经济："+teamGold);

        OptionalDouble teamGold2 = lists.stream().mapToDouble(HeroPlayerGold::getGold).reduce((a, b) -> a + b);
        if (teamGold2.isPresent()){
            System.out.println("团队经济："+teamGold2.getAsDouble());
        }

        //计算两个C位的经济和
        long teamGold3 = lists.stream().filter(player -> "RNG-Letme3".equals(player.getPlayer()) || "RNG-Letme4".equals(player.getPlayer()))
                .mapToLong(HeroPlayerGold::getGold)
                .reduce(0, (a, b) -> a + b);
        System.out.println("C经济："+teamGold3);
    }

    /**
     * stream流flatMap映射
     * @Author sundg
     * @Date 2019/2/28 17:14
     * @Param []
     * @return void
     * @VERSION 1.0
     **/
    @Test
    public void learnFlatMap(){
        List<String> citys = Arrays.asList("GuangZhou ShangHai","GuangZhou ShenZhen","ShangHai ShenZhen","BeiJing ShangHai","GuangZhou BeiJing","ShenZhen BeiJing");
        citys.stream().map(mCitys -> Arrays.stream(mCitys.split(" "))).forEach(System.out::println);
        citys.stream().map(mCitys -> Arrays.stream(mCitys.split(" ")))
                .forEach(cities -> cities.forEach(city -> System.out.print(city + "  ")));

        System.out.println();
        //直接一个flatMap()就把数组合并到映射流里面了
        citys.stream().flatMap(mCities -> Arrays.stream(mCities.split(" "))).forEach(System.out::println);


        System.out.println();

        //citys.stream()
        System.out.println();
        //使用distinct()方法去重！
        citys.stream().flatMap(mCities -> Arrays.stream(mCities.split(" "))).distinct().forEach(System.out::println);

   }


    
   /**
    * stream流收集
    * @Author sundg
    * @Date 2019/3/1 13:30
    * @Param []
    * @return void
    * @VERSION 1.0
    **/
   @Test
   public void learnCollect1th(){
       List<HeroPlayerGold> lists = new ArrayList<HeroPlayerGold>();
       lists.add(new HeroPlayerGold("盖伦1","RNG-Letme1",100));
       lists.add(new HeroPlayerGold("盖伦2","RNG-Letme2",110));
       lists.add(new HeroPlayerGold("盖伦3","RNG-Letme3",120));
       lists.add(new HeroPlayerGold("盖伦4","RNG-Letme4",130));
       lists.add(new HeroPlayerGold("盖伦5","RNG-Letme5",140));

       List<PlayerGold> playerGolds = lists.stream().map(plary -> new PlayerGold(plary.getGold(),plary.getPlayer())).collect(Collectors.toList());
       System.out.println("============PlayerGold begin==============");
       playerGolds.forEach(System.out::println);
       System.out.println("============PlayerGold end==============");


       Set<Hero> heroes = lists.stream().map(player -> new Hero(player.getHero())).collect(Collectors.toSet());
       System.out.println("============Hero begin==============");
       heroes.forEach(System.out::println);
       System.out.println("============Hero end==============");
   }


   /**
    * 由stream流转换为collection集合
    * @Author sundg
    * @Date 2019/3/1 14:55
    * @Param []
    * @return void
    * @VERSION 1.0
    **/
   @Test
   public void learnCollect2th(){
       List<HeroPlayerGold> lists = new ArrayList<HeroPlayerGold>();
       lists.add(new HeroPlayerGold("盖伦1","RNG-Letme1",100));
       lists.add(new HeroPlayerGold("盖伦2","RNG-Letme2",110));
       lists.add(new HeroPlayerGold("盖伦3","RNG-Letme3",120));
       lists.add(new HeroPlayerGold("盖伦4","RNG-Letme4",130));
       lists.add(new HeroPlayerGold("盖伦5","RNG-Letme5",140));


       //传统方法将stream流转换为集合
       lists.stream().collect(new Supplier<HashSet<HeroPlayerGold>>() {
           @Override
           public HashSet<HeroPlayerGold> get() {
               return new HashSet<>();
           }
       }, new BiConsumer<HashSet<HeroPlayerGold>, HeroPlayerGold>() {
           @Override
           public void accept(HashSet<HeroPlayerGold> heroPlayerGolds, HeroPlayerGold heroPlayerGold) {
                heroPlayerGolds.add(heroPlayerGold);
           }
       }, new BiConsumer<HashSet<HeroPlayerGold>, HashSet<HeroPlayerGold>>() {
           @Override
           public void accept(HashSet<HeroPlayerGold> heroPlayerGolds, HashSet<HeroPlayerGold> heroPlayerGolds2) {
                heroPlayerGolds.addAll(heroPlayerGolds2);
           }
       }).forEach(System.out::println);

       System.out.println();

       //使用lambda表达式
       lists.stream().collect(() -> new HashSet<>(),(set,elem) -> set.add(elem),(set1,set2) -> set1.addAll(set2))
               .forEach(System.out::println);

       System.out.println();

       //使用方法引用和构造函数引用
       lists.stream().collect(HashSet::new,HashSet::add,HashSet::addAll)
               .forEach(System.out::println);
   }


   /**
    * stream迭代器
    * @Author sundg
    * @Date 2019/3/1 15:20
    * @Param []
    * @return void
    * @VERSION 1.0
    **/
   @Test
   public void learnSpliterator(){
       List<String> lists = Arrays.asList("A","B","C","D");

       //传统方法遍历
       Iterator<String> iterator = lists.stream().iterator();
       while (iterator.hasNext()) {
           System.out.println(iterator.next());
       }

       System.out.println();


       //java8
       Spliterator<String> spliterator = lists.stream().spliterator();
       while (spliterator.tryAdvance(System.out::println));

       System.out.println();

       lists.stream().spliterator().forEachRemaining(System.out::println);

       System.out.println();
       List<String> lists1 = Arrays.asList("A");
       Spliterator<String> spliterator1 = lists1.stream().spliterator();
       Spliterator<String> stringSpliterator = spliterator1.trySplit();
       if (stringSpliterator != null) {
           stringSpliterator.forEachRemaining(System.out::println);
       }
       System.out.println("-----------------------");
       spliterator1.forEachRemaining(System.out::println);
   }
}

