package io.github.xinfra.lab.code.tree;

public class Flatten {

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
        public void flatten(TreeNode root) {
            preOrder(root);
        }

        public TreeNode[] preOrder(TreeNode node) {
            if (node == null) {
                return new TreeNode[]{null, null};
            }
            TreeNode[] leftPart = preOrder(node.left);
            TreeNode[] rightPart = preOrder(node.right);
            node.left = null;
            if (leftPart[0] != null) {
                node.right = leftPart[0];
            }
            if (leftPart[1] != null && rightPart[0] != null) {
                leftPart[1].right = rightPart[0];
            }
            if (rightPart[1] != null) {
                return new TreeNode[]{node, rightPart[1]};
            } else if (rightPart[0] != null) {
                return new TreeNode[]{node, rightPart[0]};
            } else if (leftPart[1] != null) {
                return new TreeNode[]{node, leftPart[1]};
            } else if (leftPart[0] != null) {
                return new TreeNode[]{node, leftPart[0]};
            }
            return new TreeNode[]{node, node};
        }
    }
}
