package cn.alone.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by RojerAlone on 2018-07-04
 */
public class P804_UniqueMorseCodeWords {

    public int uniqueMorseRepresentations(String[] words) {
        String[] dict = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",
                ".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set = new HashSet<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (char c : word.toCharArray()) {
                sb.append(dict[c - 'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }

}
