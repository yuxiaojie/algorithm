package leetcode;

import java.util.*;

/*
589. N叉树的前序遍历
给定一个 N 叉树，返回其节点值的前序遍历。
* */
public class Q589 {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public List<Integer> preorder(Node root) {
        // 递归写法
        return treeRecur(new ArrayList<>(), root);
    }

    private List<Integer> treeRecur(List<Integer> result, Node root) {
        if (root == null)
            return result;

        result.add(root.val);
        for (Node node : root.children)
            treeRecur(result, node);
        return result;
    }

    private List<Integer> dfs(Node root) {

        // 迭代写法，深度优先

        if (root == null)
            return new ArrayList<>();

        List<Integer> result = new ArrayList<>();
        Deque<Node> stack = new LinkedList<>();
        stack.addFirst(root);

        while (!stack.isEmpty()) {

            Node node = stack.pollFirst();
            result.add(node.val);
            Collections.reverse(node.children);
            for (Node c : node.children)
                stack.addFirst(c);
        }
        return result;
    }
}
