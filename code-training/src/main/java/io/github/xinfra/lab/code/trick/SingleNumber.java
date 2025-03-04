package io.github.xinfra.lab.code.trick;

public class SingleNumber {

    class Solution {
        public int singleNumber(int[] nums) {
            int res = 0;

            for (int n : nums){
                res = res^n;
            }
            return res;
        }
    }
}
