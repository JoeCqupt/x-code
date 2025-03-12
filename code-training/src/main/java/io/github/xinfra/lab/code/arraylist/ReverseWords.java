package io.github.xinfra.lab.code.arraylist;

public class ReverseWords {

    class Solution_BAD {
        public String reverseWords(String s) {
            StringBuilder sb = new StringBuilder();

            char[] charArray = s.toCharArray();
            int left = charArray.length - 1;
            int right = charArray.length - 1;
            while (left >= 0) {
                if (charArray[left] == ' ') {
                    if (left < right) {
                        sb.append(String.valueOf(charArray, left + 1, right - left));
                        sb.append(' ');
                    }
                    right = left - 1;
                }

                left--;
            }

            if (left + 1 <= right) {
                sb.append(String.valueOf(charArray, left + 1, right - left));
            }

            if (sb.charAt(sb.length() - 1) == ' ') {
                sb.deleteCharAt(sb.length() - 1);
            }
            return sb.toString();
        }
    }

    class Solution {
        public String reverseWords(String s) {
            StringBuilder sb = new StringBuilder();

            char[] chars = s.toCharArray();
            int length = 0;
            for (int i = chars.length - 1; i >= 0; i--) {
                char aChar = chars[i];
                if (aChar != ' ') {
                    length++;
                } else if (aChar == ' ') {
                    if (length != 0) {
                        if (sb.length() != 0) {
                            sb.append(' ');
                        }
                        sb.append(
                                String.valueOf(chars, i + 1, length)
                        );
                        length = 0;
                    }
                }
            }

            if (length != 0) {
                if (sb.length() != 0) {
                    sb.append(' ');
                }
                sb.append(
                        String.valueOf(chars, 0, length)
                );
            }


            return sb.toString();
        }
    }

}
