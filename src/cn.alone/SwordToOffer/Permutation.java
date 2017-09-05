package cn.alone.SwordToOffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by RojerAlone on 2017-09-05.
 * 字符串的排列
 */
public class Permutation {

    private ArrayList<String> res = null;

    private Set<String> set = new HashSet<>();

    /**
     * 遍历，依次交换当前值和后面的值
     */
    public ArrayList<String> Permutation(String str) {
        res = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return res;
        }
        helper(str.toCharArray(), 0);
        res.addAll(set);
        Collections.sort(res);
        return res;
    }

    private void helper(char[] str, int num) {
        if (num == str.length) {
            set.add(new String(str));
        }
        for (int i = num; i < str.length; i++) {
            swap(str, i, num);
            helper(str, num + 1);
            swap(str, i, num);
        }
    }

    private void swap(char[] str, int i, int j) {
        if (i != j) {
            char tmp = str[i];
            str[i] = str[j];
            str[j] = tmp;
        }
    }

}
