package cn.alone.LeetCode;

/**
 * Created by RojerAlone on 2017/7/3.
 * https://leetcode.com/problems/nim-game/
 * 桌子上有一堆石头，你和你的朋友玩游戏，每次拿走1到3个石头
 * 最后一个石头谁拿走谁赢
 * 给定一定数量的石头，你先拿，判断你是否可以赢
 */
public class P292_NimGame {

    /**
     * 讨论区大神给出了规律
     * 也就是谁拿过后剩下的石头是4的倍数，谁可以赢
     * 最后剩下了4个石头，最多拿走3个，最少一个，那么次走的人一定能拿走最后一个
     */
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }

}
