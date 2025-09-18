 import java.util.*;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) return false;

        Map<Character, String> mapCharToWord = new HashMap<>();
        Map<String, Character> mapWordToChar = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String w = words[i];

            if (mapCharToWord.containsKey(c)) {
                if (!mapCharToWord.get(c).equals(w)) return false;
            } else {
                mapCharToWord.put(c, w);
            }

            if (mapWordToChar.containsKey(w)) {
                if (mapWordToChar.get(w) != c) return false;
            } else {
                mapWordToChar.put(w, c);
            }
        }

        return true;
    }
}

        
    
