package io.github.xinfra.lab.code.tree;

public class KthSmallest {

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

    class Solution {
        int i = 0;

        public int kthSmallest(TreeNode root, int k) {
            if (root == null) {
                return Integer.MIN_VALUE;
            }
            int l = kthSmallest(root.left, k);
            i++;
            if (i == k) {
                return root.val;
            }
            int r = kthSmallest(root.right, k);

            return Math.max(l, r);
        }
    }

}
