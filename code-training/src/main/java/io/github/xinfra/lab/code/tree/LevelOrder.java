package io.github.xinfra.lab.code.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {


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
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();

            Queue<TreeNode> queue = new LinkedList<>();
            if (root != null) {
                queue.add(root);
            }
            while (!queue.isEmpty()) {
                List<Integer> level = new ArrayList<>();
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode n = queue.poll();
                    if (n.left != null) {
                        queue.add(n.left);
                    }
                    if (n.right != null) {
                        queue.add(n.right);
                    }
                    level.add(n.val);
                }
                result.add(level);
            }

            return result;
        }
    }

}
