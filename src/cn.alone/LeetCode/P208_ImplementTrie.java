package cn.alone.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by RojerAlone on 2018-01-21
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 * 实现一个拥有 插入、查询、前缀查询的前缀树
 */
public class P208_ImplementTrie {

    class Trie {

        class TrieNode {
            private char character;
            private boolean isWord;
            private Map<Character, TrieNode> next = new HashMap<>();

            public TrieNode(char character) {
                this.character = character;
            }

            public char getCharacter() {
                return character;
            }

            public boolean isWord() {
                return isWord;
            }

            public void setWord() {
                this.isWord = true;
            }

            public TrieNode getNext(char character) {
                return next.get(character);
            }

            public TrieNode addNext(TrieNode node) {
                TrieNode nextNode = next.get(node.getCharacter());
                if (nextNode == null) {
                    next.put(node.getCharacter(), node);
                    nextNode = node;
                } else if (!nextNode.isWord && node.isWord) {
                    nextNode.setWord();
                }
                return nextNode;
            }

            public int getNextSize() {
                return next.size();
            }
        }

        private TrieNode root = new TrieNode(' ');

        /**
         * Initialize your data structure here.
         */
        public Trie() {

        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            if (word == null || word.isEmpty()) {
                return;
            }
            TrieNode node = new TrieNode(word.charAt(0));
            node = root.addNext(node);
            if (word.length() == 1) {
                node.setWord();
                return;
            }

            for (int i = 1; i < word.length(); i++) {
                TrieNode tmpNode = new TrieNode(word.charAt(i));
                node = node.addNext(tmpNode);
                if (i == word.length() - 1) {
                    node.setWord();
                }
            }
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            if (word == null || word.isEmpty()) {
                return false;
            }
            TrieNode node = getWordLastNode(word);
            if (node != null && node.isWord()) {
                return true;
            }
            return false;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            if (prefix == null || prefix.isEmpty()) {
                return false;
            }
            TrieNode node = getWordLastNode(prefix);
            if (node != null && (node.isWord() || node.getNextSize() > 0)) {
                return true;
            }
            return false;
        }

        /**
         * Return the word's last character locate TrieNode, if not exists return null
         */
        private TrieNode getWordLastNode(String word) {
            TrieNode node = root.getNext(word.charAt(0));
            if (node == null) {
                return null;
            }
            for (int i = 1; i < word.length(); i++) {
                node = node.getNext(word.charAt(i));
                if (node == null) {
                    return null;
                }
            }
            return node;
        }
    }

}
