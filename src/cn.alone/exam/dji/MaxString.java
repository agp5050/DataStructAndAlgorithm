package cn.alone.exam.dji;

import java.util.*;

/**
 * Created by RojerAlone on 2017-09-03.
 * 字符串最大
 * 给出一个字符串(len <= 500，字符范围为a ~ j)，可以用数字0~9替换字符串中的字符，要求一个数字对应一种字符，不能重复使用字符，
 * 求出替换后的最大值。
 * 但是Tom觉得这样太简单了，所以他决定给出n个字符串(len <= 500，字符范围为a ~ j)，对于每个字符串Si，
 * 都需要找出一种数字替换方式一次性替换全部字符串，在这个替换方式下，当前字符串Si代表的数字比其他的都大，
 * 如果不存在这种替换方式，输出"no"，否则输出“yes"
 *
 * 2
 * a
 * ba
 *
 * no
 * yes
 */
public class MaxString {

    /**
     * 转换一下思想
     * 10个字母组成的字符串，用 0 - 9 10个数字替换对应字母，使得当前的数字可以是所有中最大的
     * 首先，长度短的替换后一定不是最大的（a ba 替换为 a,0a，此时两个字符串相等）
     * 所以只需要找出长度相等的字符串再进行比较
     * 然后，比较字母的位置
     * abaacd 和 babbdc
     * 对 abaacd 而言，如果要最大，那么最高位应该是最大的，即替换为 9b99cd
     * 对 babbdc 而言，如果要最大，那么最高位应该是最大的，即替换为 9a99dc
     * 然后，要使自己最大，再替换低位的，9b99cd 替换为 9899cd，9a99dc 替换为 9899dc
     * 再次替换，9899cd 替换为 98997d，9899dc 替换为 98997c
     * 最后替换结果为 989976 989976
     * 也就是说不能比较替换后的结果，因为相对于其他的字符串，总有办法使自己最大，而应该比较字符串的每个字母的位置
     * abaacd 中 a 的第一个下标为 0，b 的第一个下标为 1，c 的第一个下标为 4，d 的第一个下标为 5
     * babbdc 中 a 的第一个下标为 1，b 的第一个下标为 0，c 的第一个下标为 5，d 的第一个下标为 4
     * 可以把字母第一次出现的位置当做权值，所有字母的权值相加，abaacd 的权值和为 10，babbdc 的权值和为 10
     * 比如 abbc 和 aabc，权值和为 6 和 3，aabc > abbc (9987 > 9887)
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] strs = new String[n];
        List<Integer> list = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < n; i++) {
                strs[i] = sc.nextLine();
                if (strs[i].length() == max) {
                    list.add(i);
                } else if (strs[i].length() > max) {
                    list.clear();
                    list.add(i);
                }
        }
        sc.close();
        Set<Integer> set = maxString(strs, list, max);
        for (int i = 0; i < n; i++) {
            if (set.contains(i)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }

    /**
     * 找出最大的下标
     */
    private static Set<Integer> maxString(String[] strs, List<Integer> list, int length) {
        Set<Integer> res = new HashSet<>();
        if (list.size() == 1) { // 如果只有一个，直接输出
            res.add(list.get(0));
            return res;
        }
        int min = Integer.MAX_VALUE;
        for (int num : list) {
            char[] chars = strs[num].toCharArray();
            int count = 0;
            Map<Character, Integer> map = new HashMap<>(); // 记录字符以及对应的下标
            for (int i = 0; i < length; i++) {
                if (map.get(chars[i]) == null) {
                    map.put(chars[i], i);
                } else {
                    count += map.get(chars[i]);
                }
            }
            if (count == min) {
                res.add(num);
            } else if (count < min) {
                res.clear();
                res.add(num);
            }
        }
        return res;
    }

}
