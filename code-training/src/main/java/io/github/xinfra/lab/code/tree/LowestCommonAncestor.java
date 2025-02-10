package io.github.xinfra.lab.code.tree;

public class LowestCommonAncestor {

    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) {
                return null;
            }

            TreeNode left = null;
            if (root.left !=null) {
                left = lowestCommonAncestor(root.left, p, q);
            }
            TreeNode right = null;
            if (root.right != null) {
                right = lowestCommonAncestor(root.right, p, q);
            }
            if (left != null && right != null) {
                return root;
            }
            if (root.val == p.val || root.val == q.val) {
                return root;
            }

            return left != null ? left : right;
        }
    }
}
