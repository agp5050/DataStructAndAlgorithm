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

    public TrieNode(char character, int depth) {
        this.character = character;
        this.depth = depth;
    }

    public char getCharacter() {
        return character;
    }

    public int getDepth() {
        return depth;
    }

    public boolean isWord() {
        return word;
    }

    public void setWord() {
        word = true;
    }

    public TrieNode getNext(char character) {
        return next.get(character);
    }

    public Collection<TrieNode> getNextValues() {
        return next.values();
    }

    public int getNextSize() {
        return next.size();
    }

    public synchronized TrieNode addNext(TrieNode node) {
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
