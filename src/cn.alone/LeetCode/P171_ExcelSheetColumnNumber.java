package cn.alone.LeetCode;

/**
 * Created by RojerAlone on 2017-08-11.
 * https://leetcode.com/problems/excel-sheet-column-number/
 * A = 1
 * B = 2
 * Z = 26
 * AA = 27
 * 给定一个字符串，返回对应的值
 */
public class P171_ExcelSheetColumnNumber {

    public int titleToNumber(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            res += (s.charAt(i) - 'A' + 1) * Math.pow(26, s.length() - i - 1);
        }
        return res;
    }

}
