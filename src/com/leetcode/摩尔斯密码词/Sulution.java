package com.leetcode.摩尔斯密码词;

import java.util.HashSet;
import java.util.Set;

/**
 * @author heibai
 * @date 2021/1/13 16:59
 */
public class Sulution {
    public int uniqueMorseRepresentations(String[] words) {
        if (words.length ==0)
            return 0;
        String[] codes={".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set=new HashSet<>();
        for (String word:words
             ) {
            StringBuilder stringBuilder=new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                char letter=word.charAt(i);
                int num=0;
                if (letter >= 'A' && letter <= 'Z')
                    num=letter-'A';
                if (letter >= 'a' && letter <= 'z')
                    num=letter-'a';
                stringBuilder.append(codes[num]);
            }
            set.add(stringBuilder.toString());
        }
        return set.size();
    }



    public static void main(String[] args) {
        String[] testString={"gin", "zen", "gig", "msg"};
        System.out.println((new Sulution().uniqueMorseRepresentations(testString)));
    }
}
