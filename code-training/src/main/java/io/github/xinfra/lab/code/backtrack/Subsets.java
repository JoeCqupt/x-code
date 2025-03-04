package io.github.xinfra.lab.code.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    class Solution {
        List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> subsets(int[] nums) {

            List<Integer> list = new ArrayList<>();
            dfs(0, nums, list);

            return result;
        }

        private void dfs(int i, int[] nums, List<Integer> list) {
            if (i == nums.length){
                result.add(new ArrayList<>(list));
                return;
            }
            list.add(nums[i]);
            dfs(i+1, nums, list);
            list.remove(list.size()-1);

            dfs(i+1, nums, list);
        }
    }

}
