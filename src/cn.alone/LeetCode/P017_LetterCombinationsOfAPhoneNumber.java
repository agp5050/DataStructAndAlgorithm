package cn.alone.LeetCode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhangrenjie on 2017-12-13
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class P017_LetterCombinationsOfAPhoneNumber {

    public List<String> letterCombinations(String digits) {
        LinkedList<String> res = new LinkedList<>();
        if (digits.isEmpty()) {
            return res;
        }
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        res.add("");
        for (int i = 0; i < digits.length(); i++) {
            int x = Character.getNumericValue(digits.charAt(i));
            while (res.peek().length() == i) {
                String t = res.remove();
                for (char s : mapping[x].toCharArray())
                    res.add(t + s);
            }
        }
        return res;
    }

}
