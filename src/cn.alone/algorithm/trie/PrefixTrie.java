package cn.alone.algorithm.trie;

import sun.text.normalizer.Trie;

import java.util.*;

/**
 * Created by RojerAlone on 2018-01-09
 */
public class PrefixTrie {

    // TODO: init size
    private Map<Character, TrieNode> next = new HashMap<>();
    private Set<String> words = new HashSet<>();

    public TrieNode getNode(char c) {
        return next.get(c);
    }

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
        TrieNode node = new TrieNode(str.charAt(0));
        if (length == 1) {
            node.setWord();
        }
        node = this.addNode(node);
        for (int i = 1; i < length; i++) {
            TrieNode tmpNode = new TrieNode(str.charAt(i));
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

        return result;
    }

    public void deleteWord(String word) {
        if (word == null || word.isEmpty() || !words.contains(word)) {
            return;
        }
        words.remove(word);
        // TODO : remove word for trie
    }

    public void clear() {
        next.clear();
        words.clear();
    }

}
