package cn.alone.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by RojerAlone on 2017/6/27.
 * https://leetcode.com/problems/keyboard-row/
 * 给一个字符串数组，返回这些字符串中 所有字符在美式键盘中在同一行的字符串
 * 比如 qwe 和 asd 都在同一行，qaz 就不在同一行
 * 思路：
 *      将每一行的字符放在 map 中，每一行的每个字符对应该行的 index
 *      获取字符串的第一个字符，遍历字符串中的每个字符，如果和第一个字符所在行不一致就进入下一轮遍历
 */
public class P500_KeyboardRow {

    private static final String TOP = "qwertyuiop";
    private static final String MIDDLE = "asdfghjkl";
    private static final String BOTTOM = "zxcvbnm";


    public String[] findWords(String[] words) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : TOP.toCharArray()) {
            map.put(c, 1);
        }
        for (char c : MIDDLE.toCharArray()) {
            map.put(c, 2);
        }
        for (char c : BOTTOM.toCharArray()) {
            map.put(c, 3);
        }
        List<String> resList = new ArrayList<>();
        for (String word : words) {
            String tmpWord = word.toLowerCase();
            if (tmpWord.equals("")) {
                continue;
            }
            if (tmpWord.charAt(0) < 'a' || tmpWord.charAt(0) > 'z') {
                return null;
            }
            int index = map.get(tmpWord.charAt(0));
            boolean flag = true;
            for (char c : tmpWord.toCharArray()) {
                if (c < 'A' || c > 'z') {
                    return null;
                }
                if (map.get(c) != index) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                resList.add(word);
            }
        }
        return resList.toArray(new String[resList.size()]);
    }

}
