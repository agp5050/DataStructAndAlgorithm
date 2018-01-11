package cn.alone.algorithm.trie;

/**
 * Created by RojerAlone on 2018-01-09
 */
public class Main {

    public static void main(String[] args) {
        PrefixTrie trie = new PrefixTrie();

        String query = "北京天气";
        trie.addWord(query);
        String str1 = "北京";
        String str2 = "海淀天气";
        String str3 = "北京天气";
        System.out.println(trie.isWord(str1));
        System.out.println(trie.isWord(str2));
        System.out.println(trie.isWord(str3));

        System.out.println(trie.containsWord(str2 + str3));

        System.out.println(trie.getWordSet());

        trie.addWord("北京天安门");
        System.out.println(trie.getPrefixWord(str1));

        trie.addWord(str1);
        System.out.println(trie.getPrefixWord(str1));

        trie.addWord("地铁跑酷1");
        trie.addWord("地铁跑酷2");
        trie.addWord("地铁跑酷3");
        trie.addWord("地铁跑酷是什么东西");
        System.out.println(trie.getPrefixWord("地铁"));
    }

}
