package leetcode;

import java.util.LinkedList;
import java.util.List;

public class Q95 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) { this.val = val; }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<>();
        }
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {

        List<TreeNode> allTrees = new LinkedList<>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }

        for (int i = start; i <= end; i++) {

            List<TreeNode> allLeft = generateTrees(start, i - 1);
            List<TreeNode> allRight = generateTrees(i + 1, end);

            for (TreeNode left : allLeft) {
                for (TreeNode right : allRight) {
                    TreeNode currTree = new TreeNode(i);
                    currTree.left = left;
                    currTree.right = right;
                    allTrees.add(currTree);
                }
            }
        }
        return allTrees;
    }

    public static void main(String[] args) {
        Q95 q = new Q95();
        List<TreeNode> r = q.generateTrees(3);
        r.size();
    }
}
