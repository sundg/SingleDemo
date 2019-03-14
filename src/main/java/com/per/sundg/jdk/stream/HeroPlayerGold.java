package com.per.sundg.jdk.stream;

/**
 * <br>
 *  玩家使用的英雄以及当前获得的金币数
 * @ClassName: HeroPlayerGold
 * @Description: TODO
 * @Author sundg
 * @Date 2019/2/28 16:50
 * @VERSION 1.0
 */
public class HeroPlayerGold {

    /**使用的英雄名字*/
    private String hero;
    /**玩家的ID*/
    private String player;
    /**获得的金币数*/
    private int gold;

    public HeroPlayerGold(String hero, String player, int gold) {
        this.hero = hero;
        this.player = player;
        this.gold = gold;
    }

    public String getHero() {
        return hero;
    }

    public void setHero(String hero) {
        this.hero = hero;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    @Override
    public String toString() {
        return "HeroPlayerGold{" +
                "hero='" + hero + '\'' +
                ", player='" + player + '\'' +
                ", gold=" + gold +
                '}';
    }
}
