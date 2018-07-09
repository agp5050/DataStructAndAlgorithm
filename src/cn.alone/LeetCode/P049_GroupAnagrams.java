package cn.alone.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by RojerAlone on 2018-07-09
 * 给定小写字母组成的字符串数组,将它们分类到一起(字符相同的为一组,eat tea ate为一组)
 */
public class P049_GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        return solveWithSignCharArray(strs);
    }

    /**
     * 使用字符数组来标识字符串中出现字符的次数
     *
     * 定义一个大小为 26 的 char 数组,一个字符串出现一次,将该字符在字母表中的数字为下标的位置 +1
     * 这样如果两个字符串中字符相同,最后组成的数组也是相同的,然后将字符串数组转化为字符串,用 map 记录该字符串和对应的字符组
     */
    private List<List<String>> solveWithSignCharArray(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return res;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] tmp = new char[26];
            for (char c : str.toCharArray()) {
                tmp[c - 'a']++;
            }
            String key = new String(tmp);
            List<String> groupStr = map.get(key);
            if (groupStr == null) {
                groupStr = new ArrayList<>();
                res.add(groupStr);
                map.put(key, groupStr);
            }
            groupStr.add(str);
        }
        return res;
    }

    /**
     * 最开始的想法是只要能记录字符串中每个字符出现的次数就可以了,但是想不到用什么方法,看了 discuss 之后发现有人用素数标识一个字符,
     * 遍历字符串每出现一个字符就相乘之前出现过的,由于素数的特性(素数只能被 1 和它自身整除),那么最后计算出来的乘积一定可以标识一种字符串
     * 有人在评论区指出了可能会因为乘积过大而溢出,猜测由于测试用例没有特别长的字符串所以是可以 ac 的
     */
    private List<List<String>> solveWithComputeUniqueNum(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return res;
        }
        int[] base = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        Map<Integer, Integer> map = new HashMap<>();
        for (String str : strs) {
            int compute = 1;
            for (char c : str.toCharArray()) {
                compute *= base[c - 'a'];
            }
            List<String> list;
            if (map.containsKey(compute)) {
                list = res.get(map.get(compute));
            } else {
                list = new ArrayList<>();
                res.add(list);
                map.put(compute, res.size() - 1);
            }
            list.add(str);
        }
        return res;
    }

}
