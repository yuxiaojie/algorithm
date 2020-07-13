package leetcode;

import java.util.Arrays;

/*
105. 从前序与中序遍历序列构造二叉树
根据一棵树的前序遍历与中序遍历构造二叉树。

注意:
你可以假设树中没有重复的元素。

例如，给出

前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7
* */
public class Q105 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private TreeNode genTree(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {

        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }

        int rootInx = 0;
        TreeNode rootNode = new TreeNode(preorder[preStart]);
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootNode.val) {
                rootInx = i;
                break;
            }
        }

        // 左子树就是中序遍历根节点位置左边的所有元素
        rootNode.left = genTree(preStart + 1, inStart, rootInx - 1, preorder, inorder);
        // 右子树就是中序遍历根节点位置右边的所有元素
        rootNode.right = genTree(preStart + rootInx - inStart + 1, rootInx + 1, inEnd, preorder, inorder);
        return rootNode;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return genTree(0, 0, inorder.length - 1, preorder, inorder);
    }

    public static void main(String[] args) {
        Q105 q = new Q105();
        System.out.println(q.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}));
    }
}
