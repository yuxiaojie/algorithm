package coding.interview;

import part3.CycleArrayQueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * 找出数组中任意一个重复的数字
 *
 * 数组长度为 n + 1，数字范围在 1 - n 范围内
 *
 */
public class Q3DuplicationInArrayNoEdit {

    public static int[] genArray(int max) {

        int[] result = new int[max];
        List<Integer> list = new ArrayList<>(max);
        for (int i = 1; i < max; i++) {
            list.add(i);
        }
        list.add(max-1);
        Collections.shuffle(list);

        for (int i = 0; i < max; i++)
            result[i] = list.get(i);
        return result;
    }

    public static int solution1(int[] dst) {

        int result = -1;
        long curr = System.currentTimeMillis();

        if (dst == null || dst.length == 0)
            return result;

        for (int i : dst)
            if (i <= 0 || i > (dst.length -1))
                return result;

        int[] tmp = new int[dst.length];

        for (int i : dst) {
            if (tmp[i-1] != 0) {
                result = i;
                break;
            } else {
                tmp[i-1] = i;
            }
        }

        System.out.println("solution1 spend time: " + (System.currentTimeMillis() - curr) + " ms");
        return result;
    }

    public static void main(String[] args) {

        System.out.println("solution1 find: " + solution1(new int[]{2, 3, 5, 4, 3, 2, 6, 7}));
//        solution2(new int[]{2, 3, 1, 0, 2, 5, 3});
//        solution3(new int[]{2, 3, 1, 0, 2, 5, 3});

//        System.out.println();
//        System.out.println("test array length: 5000");
//        int[] testArr = genArray(50000);
//        solution1(testArr.clone());
//        solution2(testArr.clone());
//        solution3(testArr.clone());
//        System.out.println(" ------------------------------------------------- ");
//        System.out.println();

//        System.out.println("test array length: 50000");
//        testArr = genArray(50000);
//        solution1(testArr.clone());
//        solution2(testArr.clone());
//        solution3(testArr.clone());
//        System.out.println(" ------------------------------------------------- ");
//        System.out.println();
//
//        System.out.println("test array length: 500000");
//        testArr = genArray(500000);
//        solution1(testArr.clone());
//        solution2(testArr.clone());
//        solution3(testArr.clone());
//        System.out.println(" ------------------------------------------------- ");
//        System.out.println();
//
//        System.out.println("test array length: 5000000");
//        testArr = genArray(5000000);
//        solution1(testArr.clone());
//        solution2(testArr.clone());
//        solution3(testArr.clone());
//        System.out.println(" ------------------------------------------------- ");
//        System.out.println();
    }
}
