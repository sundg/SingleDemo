package com.per.sundg.jdk.stream;

/**
 * <br>
 * 玩家获得的金币数
 * @ClassName: Gold
 * @Description: TODO
 * @Author sundg
 * @Date 2019/2/28 16:52
 * @VERSION 1.0
 */
public class Hero {

    /**获得的金币数*/
    private String hero;

    public Hero(String hero) {
        this.hero = hero;
    }

    public String getHero() {
        return hero;
    }

    public void setHero(String hero) {
        this.hero = hero;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "hero=" + hero +
                '}';
    }
}
