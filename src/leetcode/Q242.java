package leetcode;

public class Q242 {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null)
            return false;

        int[] c = new int[26];
        for (int i = 0; i < s.length(); i++) {
            c[s.charAt(i) - 'a']++;
            c[t.charAt(i) - 'a']--;
        }

        for (int i : c) if (i != 0) return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Q242().isAnagram("a", "ab"));
    }
}
