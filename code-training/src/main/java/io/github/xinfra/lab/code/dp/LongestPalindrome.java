package io.github.xinfra.lab.code.dp;

public class LongestPalindrome {
    public static void main(String[] args) {

    }

    class Solution {
        public String longestPalindrome(String s) {
            int length = s.length();
            boolean dp[][] = new boolean[length][length];
            // single char
            for (int i = 0; i < length; i++) {
                dp[i][i] = true;
            }
            // single char
            int maxLength = 1;
            int startIdx = 0;
            for (int l = 2; l <= length; l++) {
                for (int i = 0; (i + l - 1) < length; i++) {
                    if (s.charAt(i) == s.charAt(i + l - 1)) {
                        if ((l > 3 && dp[i + 1][i + l - 2]) || l <= 3) {
                            if (l > maxLength) {
                                startIdx = i;
                                maxLength = l;
                            }
                            dp[i][i + l - 1] = true;
                        }
                    }
                }
            }
            return s.substring(startIdx, startIdx + maxLength);
        }
    }
}
