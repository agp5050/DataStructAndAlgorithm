package cn.alone.LeetCode;

import java.util.List;

/**
 * Created by RojerAlone on 2017-08-04.
 * https://leetcode.com/problems/replace-words/
 * 给一个单词数组和一个句子，将句子中以给定单词数组开头的单词替换为单词数组中的单词
 */
public class P648_ReplaceWords {

    /**
     * 暴力破解，效率更高的做法是构建多叉树
     */
    public String simpleReplaceWords(List<String> dict, String sentence) {
        if (dict == null || dict.size() == 0) {
            return sentence;
        }
        String[] strs = sentence.split(" ");
        StringBuilder res = new StringBuilder();
        for (String str : strs) {
            boolean find = false;
            for (String word : dict) {
                if (str.startsWith(word)) {
                    res.append(word + " ");
                    find = true;
                    break;
                }
            }
            if (!find) {
                res.append(str + " ");
            }
        }
        return res.substring(0, res.length() - 1);
    }

    /**
     * 根据字符树查找
     */
    public String replaceWords(List<String> dict, String sentence) {
        String[] tokens = sentence.split(" "); // 将句子切割为单个单词
        TreeNode trie = buildTrie(dict); // 将关键字构建为多叉树
        return replaceWords(tokens, trie); // 从树中查找单词并替换
    }

    private String replaceWords(String[] tokens, TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String token : tokens) {
            stringBuilder.append(getShortestReplacement(token, root));
            stringBuilder.append(" ");
        }
        return stringBuilder.substring(0, stringBuilder.length()-1);
    }

    /**
     * 根据单个单词从字符树中查找单词树中是否存在这样的单词
     */
    private String getShortestReplacement(String token, final TreeNode root) {
        TreeNode temp = root;
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : token.toCharArray()) {
            stringBuilder.append(c);
            if (temp.children[c - 'a'] != null) {
                if (temp.children[c - 'a'].isWord) {
                    return stringBuilder.toString();
                }
                temp = temp.children[c - 'a'];
            } else {
                return token;
            }
        }
        return token;
    }

    /**
     * 构建字符树
     */
    private TreeNode buildTrie(List<String> dict) {
        TreeNode root = new TreeNode(' ');
        for (String word : dict) {
            TreeNode temp = root;
            for (char c : word.toCharArray()) {
                if (temp.children[c - 'a'] == null) {
                    temp.children[c - 'a'] = new TreeNode(c);
                }
                temp = temp.children[c - 'a'];
            }
            temp.isWord = true;
        }
        return root;
    }

    public class TreeNode {
        char val;
        TreeNode[] children; // 子结点
        boolean isWord; // 到这里是否是一个单词

        public TreeNode(char val) {
            this.val = val;
            this.children = new TreeNode[26]; // 这里只考虑了小写字母
            this.isWord = false;
        }
    }

}
