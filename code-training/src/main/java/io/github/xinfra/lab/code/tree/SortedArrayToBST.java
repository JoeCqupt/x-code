package io.github.xinfra.lab.code.tree;

public class SortedArrayToBST {


    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    class Solution_BAD {
        public TreeNode sortedArrayToBST(int[] nums) {
            int left = 0;
            int right = nums.length - 1;
            return toBST(nums, left, right);
        }

        public TreeNode toBST(int[] nums, int start, int end) {
            int len = end - start + 1;
            if (len > 3) {
                int mid = start + (end - start) / 2;
                TreeNode leftTree = toBST(nums, start, mid - 1);
                TreeNode rightTree = toBST(nums, mid + 1, end);
                TreeNode root = new TreeNode(nums[mid]);
                root.left = leftTree;
                root.right = rightTree;
                return root;
            }
            if (start == end) {
                return new TreeNode(nums[start]);
            }

            int leftNums = len / 2 + 1;
            TreeNode leftPart = null;
            for (int i = 0; i < leftNums; i++) {
                TreeNode n = new TreeNode(nums[start + i]);
                n.left = leftPart;
                leftPart = n;
            }

            TreeNode rightPart = null;
            for (int i = leftNums; (start + i) <= end; i++) {
                TreeNode n = new TreeNode(nums[start + i]);
                n.left = rightPart;
                rightPart = n;
            }

            leftPart.right = rightPart;

            return leftPart;
        }
    }


    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            int left = 0;
            int right = nums.length - 1;
            return toBST(nums, left, right);
        }

        public TreeNode toBST(int[] nums, int start, int end) {
            if (start == end) {
                return new TreeNode(nums[start]);
            }
            if (start > end) {
                return null;
            }
            // always choose mid-left
            int mid = start + (end - start) / 2;
            TreeNode leftTree = toBST(nums, start, mid - 1);
            TreeNode rightTree = toBST(nums, mid + 1, end);
            TreeNode root = new TreeNode(nums[mid]);
            root.left = leftTree;
            root.right = rightTree;
            return root;

        }
    }
}
