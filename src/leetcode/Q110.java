package leetcode;

/*
110. 平衡二叉树
给定一个二叉树，判断它是否是高度平衡的二叉树。

本题中，一棵高度平衡二叉树定义为：

一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1
* */
public class Q110 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        TreeNode(int x, TreeNode l, TreeNode r) {
            val = x;
            left = l;
            right = r;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        return height(root, 0) != -1;
    }

    private int height(TreeNode root, int level) {
        if (root == null)
            return level;

        int maxLeft = height(root.left, level + 1);
        int maxRight = height(root.right, level + 1);

        if (maxLeft == -1 || maxRight == -1 || Math.abs(maxLeft - maxRight) > 1)
            return -1;
        return Math.max(maxLeft, maxRight);
    }

    public static void main(String[] args) {
//        System.out.println(new Q110().isBalanced(new TreeNode()));
    }
}
