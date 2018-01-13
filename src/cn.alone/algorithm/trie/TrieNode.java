package cn.alone.algorithm.trie;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by RojerAlone on 2018-01-09
 */
public class TrieNode {

    private char character;
    private boolean word;
    private int depth;
    private Map<Character, TrieNode> next = new HashMap<>();

    public TrieNode() {
    }

    TrieNode(char character, int depth) {
        this.character = character;
        this.depth = depth;
    }

    char getCharacter() {
        return character;
    }

    int getDepth() {
        return depth;
    }

    boolean isWord() {
        return word;
    }

    void setWord() {
        word = true;
    }

    void clearWord() {
        word = false;
    }

    TrieNode getNext(char character) {
        return next.get(character);
    }

    Collection<TrieNode> getNextValues() {
        return next.values();
    }

    void removeNext(char c) {
        next.remove(c);
    }

    int getNextSize() {
        return next.size();
    }

    synchronized TrieNode addNext(TrieNode node) {
        TrieNode nextNode = this.next.get(node.getCharacter());
        if (nextNode == null) {
            this.next.put(node.getCharacter(), node);
            nextNode = node;
        } else if (node.isWord() && !nextNode.isWord()) {
            nextNode.setWord();
        }
        return nextNode;
    }
}
