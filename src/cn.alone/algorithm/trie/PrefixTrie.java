package cn.alone.algorithm.trie;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by RojerAlone on 2018-01-09
 */
public class PrefixTrie {

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

}
