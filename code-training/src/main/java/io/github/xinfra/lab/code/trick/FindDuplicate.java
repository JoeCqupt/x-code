package io.github.xinfra.lab.code.trick;

public class FindDuplicate {

    public static void main(String[] args) {
//        nums = [3,1,3,4,2]
//
//        slow: 3 -> 4 -> 2
//        fast: 3 -> 4 -> 2 -> 3 ->  4 -> 2

        Solution solution = new Solution();
        int duplicate = solution.findDuplicate(new int[]{3, 1, 3, 4, 2});
        System.out.println(duplicate);
    }

    static class Solution_Trick {
        public int findDuplicate(int[] nums) {
            for (int num : nums){
                int idx = Math.abs(num);
                if (nums[idx] < 0){
                    return idx;
                }
                nums[idx] = -nums[idx];
            }

            return -1;
        }
    }

   static class Solution {
        public int findDuplicate(int[] nums) {
            int head = nums[0];
            int slow = nums[head];
            int fast = nums[nums[head]];

            while (slow != fast) {
                slow = nums[slow];
                fast = nums[nums[fast]];
            }

            slow = head;
            while (slow!=fast){
                slow = nums[slow];
                fast = nums[fast];
            }

            return slow;
        }
    }
}
