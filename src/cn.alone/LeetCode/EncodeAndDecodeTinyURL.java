package cn.alone.LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by RojerAlone on 2017/6/27
 * https://leetcode.com/problems/encode-and-decode-tinyurl/
 * 将长URL和短URL在map中双向映射，生成短URL时随机选取6个字符，如果有重复的，就再次生成
 */
public class EncodeAndDecodeTinyURL {

    private static final String CODE = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private Map<String, String> map = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String res = map.get(longUrl);
        if (res != null) {
            return res;
        }
        res = "http://tinyurl.com/";
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            res += CODE.charAt(random.nextInt(62));
        }
        // 有重复的就再次生成
        while (map.containsKey(res)) {
            for (int i = 0; i < 6; i++) {
                res += CODE.charAt(random.nextInt(62));
            }
        }
        map.put(longUrl, res);
        map.put(res, longUrl);
        return res;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }

}
