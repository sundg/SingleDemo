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
public class PlayerGold {

    /**获得的金币数*/
    private int gold;

    private String player;

    public PlayerGold(int gold, String player) {
        this.gold = gold;
        this.player = player;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    @Override
    public String toString() {
        return "PlayerGold{" +
                "gold=" + gold +
                ", player='" + player + '\'' +
                '}';
    }
}
