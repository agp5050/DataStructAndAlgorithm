package cn.alone.SwordToOffer;

/**
 * Created by RojerAlone on 2017-09-02.
 * 变态跳台阶
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class JumpFloorII {

    /**
     * 递归
     */
    public int JumpFloorII(int target) {
        if (target <= 0) {
            return 0;
        }
        helper(target);
        return res;
    }

    private int res = 0;
    private void helper(int target) {
        if (target == 0) {
            res++;
            return;
        } else if (target < 0) {
            return;
        }
        for (int i = 1; i <= target; i++) {
            helper(target - i);
        }
    }

}
