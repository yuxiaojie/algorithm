package part2;

import java.util.Random;

public class MaxSubSum {

    private static int maxSumRec(int[] a, int left, int right) {

        if (left == right)
            return a[right] > 0 ? a[right] : 0;

        int center = (left + right) / 2;
        int maxLeft = maxSumRec(a, left, center);
        int maxRight = maxSumRec(a, center + 1, right);

        int maxLeftBorderSum = 0, leftBorderSum = 0;
        for (int i = center; i >= left; i--) {
            leftBorderSum += a[i];
            if (leftBorderSum > maxLeftBorderSum)
                maxLeftBorderSum = leftBorderSum;
        }

        int maxRightBorderSum = 0, rightBorderSum = 0;
        for (int i = center + 1; i <= right; i++) {
            rightBorderSum += a[i];
            if (rightBorderSum > maxRightBorderSum)
                maxRightBorderSum = rightBorderSum;
        }

        int maxBorderSum = maxLeftBorderSum + maxRightBorderSum;
        if (maxLeft > maxRight)
            return maxLeft > maxBorderSum ? maxLeft : maxBorderSum;
        else
            return maxRight > maxBorderSum ? maxRight : maxBorderSum;
    }

    private static void show(Comparable[] a) {
        // 在单行中打印数组
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }


    /**
     *
     * 分治法求最大的子序和
     * 共三种情况，一种是左边大，一种是右边大，一种是左右相连的中间部分大
     *
     * @param a
     * @return
     */
    public static int maxSubSum3(int[] a) {
        return maxSumRec(a, 0, a.length - 1);
    }

    /**
     *
     * 遍历求最大的子序
     *
     * @param a
     * @return
     */
    public static int maxSubSum2(int[] a) {

        int maxSum = 0;
        for (int i = 0; i < a.length; i++) {

            int loopMax = 0;
            for (int j = i; j < a.length; j++) {
                loopMax += a[j];
                if (loopMax > maxSum)
                    maxSum = loopMax;
            }
        }

        return maxSum;
    }

    /**
     *
     * 通过结果，一个最大序列，a[i] 肯定不是负数，因为如果是负数那就可以通过 a[i + 1] 来改进
     *
     * @param a
     * @return
     */
    public static int maxSubSum4(int[] a) {

        int maxSum = 0, thisSum = 0;
        for (int i = 0; i < a.length; i++) {
            thisSum += a[i];
            if (thisSum > maxSum)
                maxSum = thisSum;
            else if (thisSum < 0)
                thisSum = 0;
        }
        return maxSum;
    }

    public static void main(String[] args) {

//        int[] a = new int[40000000];
//        Random sead = new Random();
//        for (int i = 0; i < 40000000; i++) {
//            a[i] = sead.nextInt(100000) - 40000;
//        }
        int[] a = {-1, -2, 1, -4, -5, -6};

        long curr = System.currentTimeMillis();
        System.out.println(maxSubSum3(a));
        System.out.println("spend = " + (System.currentTimeMillis() - curr));
        curr = System.currentTimeMillis();
        System.out.println(maxSubSum4(a));
        System.out.println("spend = " + (System.currentTimeMillis() - curr));
    }
}
