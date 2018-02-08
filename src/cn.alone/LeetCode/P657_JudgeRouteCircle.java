package cn.alone.LeetCode;

/**
 * @author RojerAlone
 * @Date 2018-02-08 20:42
 * https://leetcode.com/problems/judge-route-circle/
 * 在原点有一个机器人，给出机器人的动作，判断机器人最后是否在原位置。
 * U 表示向上，D 表示向下，L 表示向左，R 表示向右。
 */
public class P657_JudgeRouteCircle {

    public boolean judgeCircle(String moves) {
        if (moves == null || moves.isEmpty()) {
            return false;
        }
        int leftRight = 0; // 表示左右走动的情况
        int upDown = 0; // 表示上下走动的情况
        for (char c : moves.toCharArray()) {
            switch (c) {
                case 'U':
                    upDown++;
                    break;
                case 'D':
                    upDown--;
                    break;
                case 'L':
                    leftRight++;
                    break;
                case 'R':
                    leftRight--;
                    break;
                    default:
                        break;
            }
        }
        if (upDown == 0 && leftRight == 0) {
            return true;
        }
        return false;
    }

}
