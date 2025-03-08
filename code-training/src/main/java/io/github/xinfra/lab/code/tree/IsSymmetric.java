package io.github.xinfra.lab.code.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class IsSymmetric {

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
        public boolean isSymmetric(TreeNode root) {
            List<Integer> left = treeToList(root.left, false);
            List<Integer> right = treeToList(root.right, true);

            return equals(left, right);
        }

        private List<Integer> treeToList(TreeNode node, boolean reverse) {
            List<TreeNode> queue = new LinkedList<>();
            queue.add(node);

            List<Integer> list = new ArrayList<>();
            boolean finish = false;
            while (!queue.isEmpty() && !finish) {
                finish = true;
                List<TreeNode> l = new ArrayList<>(queue);
                queue.clear();
                for (TreeNode n : l) {
                    if (n != null) {
                        if (n.left != null || n.right != null) {
                            finish = false;
                        }
                        if (reverse) {
                            queue.add(n.right);
                            queue.add(n.left);
                        } else {
                            queue.add(n.left);
                            queue.add(n.right);
                        }
                        list.add(n.val);
                    } else {
                        queue.add(null);
                        queue.add(null);
                        list.add(null);
                    }
                }
            }
            return list;
        }

        private boolean equals(List<Integer> leftList, List<Integer> rightList) {
            if (leftList.size() == rightList.size()) {
                for (int i = 0; i < leftList.size(); i++) {
                    if (!Objects.equals(leftList.get(i), rightList.get(i))) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }

    }


    class Solution {
        public boolean isSymmetric(TreeNode root) {
            return compareIt(root.left , root.right);
        }

        private boolean compareIt(TreeNode left, TreeNode right) {
            if (left!=null && right!=null){
                return Objects.equals(left.val, right.val) &&
                        compareIt(left.left, right.right) &&
                        compareIt(left.right, right.left);
            }
            return left == right;
        }
    }

}
