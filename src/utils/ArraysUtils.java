package utils;

public class ArraysUtils {

    public static void showIntArray(int[] a) {
        // 在单行中打印数组
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    private void printArray2(int[][] dp) {
        System.out.println("[");
        for (int[] i : dp) {
            System.out.print("[");
            for (int j : i) {
                System.out.print(j + ", ");
            }
            System.out.println("]");
        }
        System.out.println("]");
    }
}
