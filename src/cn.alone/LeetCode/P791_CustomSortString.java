package cn.alone.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RojerAlone
 * @Date 2018-03-11 15:36
 * https://leetcode.com/problems/custom-sort-string/
 * s 和 t 是两个小写字母组成的字符串，s 中的字母不重复并且是按照某种顺序排过序的。
 * 将 t 重排序使排序规则和 s 的相同。比如 x 出现在 s 中的 y 之前，那么排序过的 t 中 x 也应该在 y 之前。
 */
public class P791_CustomSortString {

    public String customSortString(String S, String T) {
        if (S == null || S.length() < 2) {
            return T;
        }
        StringBuilder res = new StringBuilder();
        Map<Character, String> second = new HashMap<>();
        for (char c : T.toCharArray()) {
            second.put(c, second.getOrDefault(c, "") + c);
        }
        for (char c : S.toCharArray()) {
           String value = second.get(c);
           if (value != null) {
               res.append(value);
               second.remove(c);
           }
        }
        for (String value : second.values()) {
            res.append(value);
        }
        return res.toString();
    }

}
