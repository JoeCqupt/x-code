package io.github.xinfra.lab.code.backtrack;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> strings = solution.letterCombinations("23");
        System.out.println(strings);
    }

    static class Solution {


        public List<String> letterCombinations(String digits) {
            if (digits.length() == 0) {
                return new ArrayList<>();
            }
            List<String> result = new ArrayList<>();
            char[] charArray = digits.toCharArray();
            track(charArray, new StringBuilder(), result);
            return result;
        }

        private void track(char[] numCharArray, StringBuilder stringBuilder, List<String> result) {
            if (numCharArray.length == stringBuilder.length()) {
                result.add(stringBuilder.toString());
                return;
            }
            int idx = stringBuilder.length();
            char numChar = numCharArray[idx];
            char[] chars = map(numChar);
            for (char c: chars){
                stringBuilder.append(c);
                track(numCharArray, stringBuilder, result);
                stringBuilder.deleteCharAt(stringBuilder.length()-1);
            }
        }

        private char[] map(char numChar) {
            switch (numChar) {
                case '2':
                    return new char[]{'a', 'b', 'c'};
                case '3':
                    return new char[]{'d', 'e', 'f'};
                case '4':
                    return new char[]{'g', 'h', 'i'};
                case '5':
                    return new char[]{'j', 'k', 'l'};
                case '6':
                    return new char[]{'m', 'n', 'o'};
                case '7':
                    return new char[]{'p', 'q', 'r', 's'};
                case '8':
                    return new char[]{'t', 'u', 'v'};
                case '9':
                    return new char[]{'w', 'x', 'y', 'z'};
            }
            throw new IllegalArgumentException("unsupported" + numChar);
        }
    }

}
