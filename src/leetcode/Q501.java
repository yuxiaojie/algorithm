package leetcode;

import java.util.HashSet;
import java.util.Set;

/*
501. 二叉搜索树中的众数
给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。

假定 BST 有如下定义：

结点左子树中所含结点的值小于等于当前结点的值
结点右子树中所含结点的值大于等于当前结点的值
左子树和右子树都是二叉搜索树
例如：
给定 BST [1,null,2,2],

   1
    \
     2
    /
   2
返回[2]
* */
public class Q501 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private int maxRepeat = 0;
    private int currRepeat = 0;
    private int last = Integer.MIN_VALUE;
    private Set<Integer> result = new HashSet<>();

    public int[] findMode(TreeNode root) {

        recur(root);
        int i = 0;
        int[] res = new int[result.size()];
        for (int v : result)
            res[i++] = v;
        return res;
    }

    private void recur(TreeNode root) {
        if (root == null)
            return;

        recur(root.left);

        if (last == root.val)
            currRepeat++;
        else
            currRepeat = 1;

        last = root.val;
        if (currRepeat > maxRepeat) {
            result.clear();
            maxRepeat = currRepeat;
        }
        if (currRepeat == maxRepeat)
            result.add(root.val);

        recur(root.right);
    }
}
