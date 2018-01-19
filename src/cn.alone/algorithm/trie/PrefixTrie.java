package cn.alone.algorithm.trie;

import java.util.*;

/**
 * Created by RojerAlone on 2018-01-09
 */
public class PrefixTrie {

    private final int MAX_DEPTH = 10;

    // TODO: init size
    private Map<Character, TrieNode> next = new HashMap<>();
    private Set<String> words = new HashSet<>();

    public Set<String> getWordSet() {
        return words;
    }

    private TrieNode addNode(TrieNode node) {
        TrieNode nextNode = next.get(node.getCharacter());
        if (nextNode == null) {
            next.put(node.getCharacter(), node);
            nextNode = node;
        } else if (node.isWord() && !nextNode.isWord()) {
            nextNode.setWord();
        }
        return nextNode;
    }

    public synchronized void addWord(String str) {
        if (str == null || str.isEmpty()) {
            System.out.println("empty query");
            return;
        }
        int length = str.length();
        TrieNode node = new TrieNode(str.charAt(0), 0);
        if (length == 1) {
            node.setWord();
        }
        node = this.addNode(node);
        for (int i = 1; i < length; i++) {
            TrieNode tmpNode = new TrieNode(str.charAt(i), i);
            if (i == length - 1) {
                tmpNode.setWord();
            }
            node = node.addNext(tmpNode);
        }
        words.add(str);
    }

    public boolean isWord(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        TrieNode node = next.get(str.charAt(0));
        if (node == null) {
            return false;
        }
        if (str.length() == 1 && node.isWord()) {
            return true;
        }
        for (int i = 1; i < str.length(); i++) {
            node = node.getNext(str.charAt(i));
            if (node == null) {
                return false;
            }
            if (i == str.length() - 1 && node.isWord()) {
                return true;
            }
        }
        return false;
    }

    public boolean containsWord(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            TrieNode node = next.get(str.charAt(i));
            if (node == null) {
                continue;
            }
            if (node.isWord()) {
                return true;
            }
            for (int j = i + 1; j < length; j++) {
                node = node.getNext(str.charAt(j));
                if (node == null) {
                    break;
                }
                if (node.isWord()) {
                    return true;
                }
            }
        }
        return false;
    }

    public List<String> getPrefixWord(String word) {
        List<String> result = new ArrayList<>();
        if (word == null || word.isEmpty()) {
            return result;
        }
        // TODO : multiple threads
        int length = word.length();
        // 先找到输入词截止的位置
        TrieNode node = next.get(word.charAt(0));
        if (node == null) {
            return result;
        }
        for (int i = 1; i < length; i++) {
            node = node.getNext(word.charAt(i));
            if (node == null) {
                return result;
            }
        }
        if (node.isWord()) { // 如果输入词也是一个完整的词，添加到结果中
            result.add(word);
        }
        // 记录出现过的字符，最终拼成 word
        Stack<TrieNode> nodeStack = new Stack<>();
        for (TrieNode tmpNode : node.getNextValues()) {
            nodeStack.push(tmpNode);
        }
        StringBuilder sb = new StringBuilder(word);
        while (!nodeStack.empty()) {
            TrieNode tmpNode = nodeStack.pop();
            if (tmpNode.getDepth() > MAX_DEPTH) { // 不能超过最大深度
                if (!nodeStack.empty()) {
                    int curDepth = tmpNode.getDepth();
                    int preDepth = nodeStack.peek().getDepth();
                    --curDepth; // 当前字符没有加入到字符串中,下标减一
                    while (curDepth - preDepth >= 0) {
                        sb.deleteCharAt(curDepth);
                        --curDepth;
                    }
                }
                continue;
            }
            sb.append(tmpNode.getCharacter());
            if (tmpNode.isWord()) {
                result.add(sb.toString());
            }
            if (tmpNode.getNextSize() > 0) {
                for (TrieNode nextNode : tmpNode.getNextValues()) {
                    nodeStack.push(nextNode);
                }
            } else {
                if (!nodeStack.empty()) {
                    int curDepth = tmpNode.getDepth();
                    int preDepth = nodeStack.peek().getDepth();
                    while (curDepth - preDepth >= 0) {
                        sb.deleteCharAt(curDepth);
                        --curDepth;
                    }
                }
            }
        }
        return result;
    }

    /**
     * 从 trie 中删除单词
     * @param word 要删除的词
     */
    public synchronized void deleteWord(String word) {
        if (word == null || word.isEmpty() || !words.contains(word)) {
            return;
        }
        words.remove(word);
        /*
         * 两种情况，假设 trie 中有 he 和 hello 两个词
         * 1. 要删除的词是其他词的一部分，要删除 he，只需要把 e 结点的状态设置为非单词
         * 2. 要删除的词下面没有其他的词，找到要删除的词和其他词的最后一个公共点（e），把 l 从 e 的下一层中删除即可
         */
        TrieNode node = next.get(word.charAt(0));
        if (word.length() == 1) {
            if (node.getNextSize() > 0) { // 第一种情况
                node.clearWord();
            } else {
                next.remove(node.getCharacter());
            }
            return;
        }
        TrieNode targetNode = node; // 要处理的目标结点
        for (int i = 1; i < word.length(); i++) {
            node = node.getNext(word.charAt(i));
            if (node.getNextSize() > 0) { // 如果有分叉点，更新目标结点
                targetNode = node;
            }
        }
        if (node.getNextSize() > 0) { // 第一种情况
            targetNode = node;
        }
        if (targetNode.getDepth() == word.length() - 1) { // 第一种情况
            targetNode.clearWord();
        } else {
            targetNode.removeNext(word.charAt(targetNode.getDepth() + 1));
        }
    }

    public int getSize() {
        return words.size();
    }

    public void clear() {
        next.clear();
        words.clear();
    }

}
