package cn.alone.LeetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by RojerAlone on 2017-08-01.
 * https://leetcode.com/problems/sort-characters-by-frequency/
 * 给一个字符串，根据字符串中字符出现的频率排序输出，如果频率相同，顺序可以替换
 */
public class P451_SortCharactersByFrequency {

    /**
     * 遍历一遍字符串中的字符，然后找出出现次数最多的字符即可，关键在于要记录频率相同的字符的出现顺序
     */
    public String frequencySort(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int max = 0; // 记录出现最多的次数
        Map<Character, Integer> map = new HashMap<>(); // 记录字符对应出现的次数
        Map<Integer, List<Character>> record = new HashMap<>(); // 出现次数为 key，对应字符为 value
        Integer times;
        List<Character> strs;
        for (char c : s.toCharArray()) {
            if ((times = map.get(c)) == null) {
                times = 1;
            } else {
                record.get(times).remove(Character.valueOf(c));
                times++; // 出现次数 +1
            }
            if (times > max) {
                max = times;
            }
            map.put(c, times);
            if ((strs = record.get(times)) == null) {
                strs = new LinkedList<>();
                strs.add(c);
                record.put(times, strs);
            } else {
                strs.add(c);
            }
        }
        for (int i = max; i > 0; i--) {
            if ((strs = record.get(i)) != null) {
                for (char c : strs) {
                   for (int j = 0; j < i; j++) {
                       sb.append(c);
                   }
                }
            }
        }
        return sb.toString();
    }

}
