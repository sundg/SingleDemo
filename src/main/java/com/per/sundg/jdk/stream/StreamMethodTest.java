package com.per.sundg.jdk.stream;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author sundg
 * @Classname StreamMethodTest
 * @Description TODO
 * @Date 2019/5/25 16:03
 */
@Slf4j
public class StreamMethodTest {


       private static List<HeroPlayerGold> list = Arrays.asList(
                new HeroPlayerGold("英雄1","玩家1",1),
                new HeroPlayerGold("英雄2","玩家2",2),
                new HeroPlayerGold("英雄3","玩家3",3));


    @Test
    /**
     * @author sundg
     * @date 2019/5/25 16:21
     * @description TODO
     * @return : void
     */
    public void testAllMatch() {
       // List<Integer> list = Arrays.asList(1, 2, 3,2);

        boolean allMatch = list.stream().allMatch(heroPlayerGold -> heroPlayerGold.getGold() == 1 || heroPlayerGold.getGold() == 2 || heroPlayerGold.getGold() == 3);
        log.debug("allMatch:"+allMatch);

        boolean anyMatch = list.stream().anyMatch(heroPlayerGold -> "玩家1".equals(heroPlayerGold.getPlayer()) && "英雄1".equals(heroPlayerGold.getHero()));
        log.debug("anyMatch:"+anyMatch);

        boolean noneMatch = list.stream().noneMatch(heroPlayerGold -> heroPlayerGold.getGold() == 4);
        log.debug("noneMatch:"+noneMatch);

    }

    @Test
    public void testCollect(){
        List<HeroPlayerGold> collect = list.stream().collect(Collectors.toList());
        Map<HeroPlayerGold, Integer> collect1 = list.stream().collect(Collectors.toMap(h -> h, h -> h.getGold() + 100));

        log.debug("");
    }
}
