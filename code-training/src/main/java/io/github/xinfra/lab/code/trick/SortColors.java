package io.github.xinfra.lab.code.trick;

public class SortColors {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.sortColors(
                new int[]{2, 0, 2, 1, 1, 0}
        );
    }

    static class Solution {
        public void sortColors(int[] nums) {
            int red = 0;
            int blue = nums.length - 1;
            for (int i = 0; i <= blue; ) {
                int num = nums[i];
                if (num == 0) {
                    nums[i] = 1;
                    nums[red] = 0;
                    red++;
                    i++;
                }
                if (num == 1) {
                    i++;
                } else if (num == 2) {
                    int tmp = nums[blue];
                    nums[blue] = 2;
                    blue--;
                    nums[i] = tmp;
                }
            }

        }
    }

}
