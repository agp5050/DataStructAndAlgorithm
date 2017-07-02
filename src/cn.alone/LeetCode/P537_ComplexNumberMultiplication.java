package cn.alone.LeetCode;

/**
 * Created by RojerAlone on 2017/6/27.
 * https://leetcode.com/problems/complex-number-multiplication/
 * 输入两个 a+bi格式的字符串，计算它们的乘积，i^2=-1，输出结果也为a+bi的形式
 * 如 输入"1+1i", "1+1i" (1 + i) * (1 + i) = 1 + i^2 + 2 * i = 2i，输出0+2i
 */
public class P537_ComplexNumberMultiplication {

    public String complexNumberMultiply(String a, String b) {
        if (a == null || b == null || a.equals("") || b.equals("")) {
            return "";
        }
        // 将输入用 + 号分割开
        String[] tmpa = a.split("\\+");
        String[] tmpb = b.split("\\+");
        // 提取出所有的数字
        int numA1 = Integer.valueOf(tmpa[0]);
        int numA2 = Integer.valueOf(tmpa[1].replaceAll("i", ""));
        int numB1 = Integer.valueOf(tmpb[0]);
        int numB2 = Integer.valueOf(tmpb[1].replaceAll("i", ""));
        int res1 = -1 * numA2 * numB2 + numA1 * numB1;
        int res2 = numA1 * numB2 + numA2 * numB1;
        return res1 + "+" + res2 + "i";
    }

}
