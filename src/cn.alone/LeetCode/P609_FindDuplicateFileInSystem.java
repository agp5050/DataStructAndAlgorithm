package cn.alone.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by RojerAlone on 2017/7/10.
 * https://leetcode.com/problems/find-duplicate-file-in-system/
 * 找出系统中的重复文件，给定文件路径及文件内容，找出文件内容重复的文件
 */
public class P609_FindDuplicateFileInSystem {

    /**
     * 以文件内容为key，文件路径为value，建立map字典
     * 遍历一遍之后，如果文件路径的大小大于1，证明有重复文件，加入结果集
     */
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> res = new ArrayList<>();
        if (paths == null || paths.length == 0) {
            return res;
        }
        Map<String, List<String>> map = new HashMap<>(); // 文件内容-文件路径的 key-value 字典
        for (String path : paths) {
            String[] strs = path.split(" "); // 将输入字符串用空格分开，第一个就是文件夹的路径
            String dirPath = strs[0];
            for (int i = 1; i < strs.length; i++) {
                int left = strs[i].indexOf('(');
                String content = strs[i].substring(left + 1, strs[i].lastIndexOf(')'));
                if (map.get(content) == null) { // 如果文件还没有出现过，放入字典中
                    List<String> list = new ArrayList<>();
                    list.add(dirPath + "/" + strs[i].substring(0, left));
                    map.put(content, list);
                } else { // 否则将文件路径添加到列表中
                    map.get(content).add(dirPath + "/" + strs[i].substring(0, left));
                }
            }
        }
        for (Map.Entry entry : map.entrySet()) {
            if (((List<String>) entry.getValue()).size() > 1) {
                res.add((List<String>) entry.getValue());
            }
        }
        return res;
    }

}
