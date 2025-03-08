package io.github.xinfra.lab.code.tree;

import java.util.ArrayList;
import java.util.List;

public class IsValidBST {

    /**
     * Definition for a binary tree node.
     */
    public static class TreeNode {
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
        public boolean isValidBST(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            inorder(root, list);
            if (list.isEmpty()) {
                return true;
            }
            int pre = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                Integer value = list.get(i);
                if (value <= pre) {
                    return false;
                }
                pre = value;
            }
            return true;
        }

        private void inorder(TreeNode node, List<Integer> list) {
            if (node == null) {
                return;
            }
            inorder(node.left, list);
            list.add(node.val);
            inorder(node.right, list);
        }
    }


    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(4);
        n1.left = n2;
        n1.right = n3;
        Solution solution = new Solution();
        solution.isValidBST(n1);
    }

    static class Solution {
        public boolean isValidBST(TreeNode root) {
            return valid(root, null, null);
        }

        private boolean valid(TreeNode node, Integer leftBound, Integer rightBound) {

            if (node == null) {
                return true;
            }
            boolean leftValid = true;
            if (node.left != null) {
                leftValid = node.left.val < node.val && (leftBound == null || leftBound < node.left.val);
            }

            boolean rightValid = true;
            if (node.right != null) {
                rightValid = node.val < node.right.val && (rightBound == null || node.right.val < rightBound);
            }

            return leftValid && rightValid && valid(node.left, leftBound, node.val)
                    && valid(node.right, node.val, rightBound);
        }
    }
}
