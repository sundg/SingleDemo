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
public class Gold {

    /**获得的金币数*/
    private int gold;

    public Gold(int gold) {
        this.gold = gold;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    @Override
    public String toString() {
        return "Gold{" +
                "gold=" + gold +
                '}';
    }
}
