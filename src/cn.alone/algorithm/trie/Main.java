package cn.alone.algorithm.trie;

/**
 * Created by RojerAlone on 2018-01-09
 */
public class Main {

    public static void main(String[] args) {
        PrefixTrie trie = new PrefixTrie();

        String query = "北京天气";
        trie.addWord(query);
        String bj = "北京";
        String hdweather = "海淀天气";
        String bjweather = "北京天气";
        System.out.println(trie.isWord(bj));
        System.out.println(trie.isWord(hdweather));
        System.out.println(trie.isWord(bjweather));

        System.out.println(trie.containsWord(hdweather + bjweather));

        System.out.println(trie.getWordSet());

        trie.addWord("北京天安门");
        System.out.println(trie.getPrefixWord(bj));

        trie.addWord(bj);
        System.out.println(trie.getPrefixWord(bj));
        System.out.println(trie.getPrefixWord("北"));

        trie.addWord("地铁跑酷1");
        trie.addWord("地铁跑酷2");
        trie.addWord("地铁跑酷3");
        trie.addWord("地铁跑酷是什么东西");
        System.out.println(trie.getPrefixWord("地铁"));

        System.out.println(trie.getPrefixWord("nihao"));

        trie.addWord("123456");
        System.out.println(trie.getPrefixWord("1"));

        System.out.println(trie.getWordSet());
        trie.deleteWord("123456");
        System.out.println(trie.getWordSet());

        System.out.println(trie.getPrefixWord("1"));

        System.out.println(trie.getPrefixWord(bj));
        trie.deleteWord(bj);
        System.out.println(trie.getPrefixWord(bj));

    }

}
