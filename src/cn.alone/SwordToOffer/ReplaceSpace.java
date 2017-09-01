package cn.alone.SwordToOffer;

/**
 * Created by RojerAlone on 2017-09-01.
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class ReplaceSpace {

    /**
     * 先遍历一遍找出空格个数，计算出最终结果的长度，然后从后往前遍历并替换空格
     * 这样消除了替换时的移动操作
     */
    public String replaceSpace(StringBuffer str) {
        if (str == null || str.length() == 0) {
            return str.toString();
        }
        int numOfSpace = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                numOfSpace++;
            }
        }
        if (numOfSpace == 0) { // 如果没有空格，就直接退出
            return str.toString();
        }
        int index = str.length() + numOfSpace * 2 - 1; // 记录最终结果遍历到的位置
        char[] res = new char[index + 1];
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) != ' ') {
                res[index--] = str.charAt(i);
            } else {
                res[index--] = '0';
                res[index--] = '2';
                res[index--] = '%';
            }
        }
        return new String(res);
    }

}
