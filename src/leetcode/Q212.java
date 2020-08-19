package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q212 {
    static class Trie {

        private boolean isEnd;
        private Trie[] next;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            isEnd = false;
            next = new Trie[26];
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            if (word == null || word.length() == 0) return;
            Trie curr = this;
            for (int i = 0; i < word.length(); i++) {
                int inx = word.charAt(i) - 'a';
                if (curr.next[inx] == null)
                    curr.next[inx] = new Trie();
                curr = curr.next[inx];
            }
            curr.isEnd = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            Trie node = searchPrefix(word);
            return node != null && node.isEnd;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            Trie node = searchPrefix(prefix);
            return node != null;
        }

        private Trie searchPrefix(String word) {
            Trie node = this;
            char[] words = word.toCharArray();
            for (int i = 0; i < words.length; i++) {
                node = node.next[words[i] - 'a'];
                if (node == null) return null;
            }
            return node;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {

        if (board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0)
            return new ArrayList<>();

        int m = board.length, n = board[0].length, maxLen = 0;
        Trie tree = new Trie();
        for (String word : words) {
            tree.insert(word);
            maxLen = Math.max(maxLen, word.length());
        }

        Set<String> result = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                StringBuilder tmp = new StringBuilder();
                check(board, tree, result, new HashSet<>(), tmp, maxLen, i, j);
            }
        }
        return new ArrayList<>(result);
    }

    private void check(char[][] board, Trie tree, Set<String> result, Set<Long> paths, StringBuilder tmp, int maxLen, int i, int j) {

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || paths.contains(i * 100000L + j))
            return;

        tmp.append(board[i][j]);
        paths.add(i * 100000L + j);
        String tmpStr = tmp.toString();
        if (tree.search(tmpStr)) result.add(tmpStr);
        if (tmp.length() < maxLen && tree.startsWith(tmpStr)) {
            check(board, tree, result, paths, tmp, maxLen, i + 1, j);
            check(board, tree, result, paths, tmp, maxLen, i - 1, j);
            check(board, tree, result, paths, tmp, maxLen, i, j + 1);
            check(board, tree, result, paths, tmp, maxLen, i, j - 1);
        }
        paths.remove(i * 100000L + j);
        tmp.deleteCharAt(tmp.length() - 1);
    }

    public static void main(String[] args) {
//        System.out.println(new Q212().findWords(new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}}, new String[]{"oath", "pea", "eat", "rain"}));
        System.out.println(new Q212().findWords(new char[][]{{'a', 'b'}, {'c', 'd'}}, new String[]{"ab","cb","ad","bd","ac","ca","da","bc","db","adcb","dabc","abb","acb"}));
    }
}
