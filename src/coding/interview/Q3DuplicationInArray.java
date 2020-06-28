package coding.interview;

import java.util.*;

/**
 * 找出数组中任意一个重复的数字
 *
 * 数组长度为 n，数字范围在 0 - n-1 范围内
 *
 */
public class Q3DuplicationInArray {

    /**
     *
     * 先对数据数据排序，然后遍历一次找出所有重复的数字
     *
     * 时间开销主要在排序上，排序基本按比较稳定的 O(nlogn) 计算
     * 空间开销
     *
     * @param dst
     */
    public static int solution1(int[] dst) {

        int result = -1;
        int last = -1, loop = 0;
        long curr = System.currentTimeMillis();

        if (dst == null || dst.length == 0)
            return result;

        for (int i : dst)
            if (i < 0 || i > (dst.length -1))
                return result;

        Arrays.sort(dst);
        for (int i : dst) {
            loop++;
            if (i == last) {
                result = i;
                System.out.println("find -> " + i);
                break;
            }
            last = i;
        }
        System.out.println("solution1 spend time: " + (System.currentTimeMillis() - curr) + " ms, loop: " + loop);
        return result;
    }

    /**
     * 创建hash表记录已经检查的数值
     *
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     *
     * @param dst
     */
    public static int solution2(int[] dst) {

        int loop = 0;
        int result = -1;
        long curr = System.currentTimeMillis();

        if (dst == null || dst.length == 0)
            return result;

        for (int i : dst)
            if (i < 0 || i > (dst.length -1))
                return result;

        HashSet<Integer> numHash = new HashSet<>();
        for (int i : dst) {
            loop++;
            if (numHash.contains(i)) {
                result = i;
                System.out.println("find -> " + i);
                break;
            } else {
                numHash.add(i);
            }
        }
        System.out.println("solution2 spend time: " + (System.currentTimeMillis() - curr) + " ms, loop: " + loop);
        return result;
    }

    /**
     * 这个方法非常的巧妙，利用了数值范围在 0 - n-1 范围内的特点
     * 循环次数会比 n 大，假设没有重复的数值，每个数值最多交换一次即可将数值放回原处
     * 假设有重复的数组，那么数值交换时就会发现重复然后结束
     *
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     *
     * @param dst
     */
    public static int solution3(int[] dst) {
        int result = -1;
        int loop = 0;
        long curr = System.currentTimeMillis();

        if (dst == null || dst.length == 0)
            return result;

        for (int i : dst)
            if (i < 0 || i > (dst.length -1))
                return result;

        for(int i = 0; i < dst.length;) {

            loop++;
            if (dst[i] != i) {
                int tmp = dst[i];
                if (dst[tmp] == tmp) {
                    result = tmp;
                    System.out.println("find -> " + tmp);
                    break;
                }

                // 将数值放置到对应索引的位置
                dst[i] = dst[tmp];
                dst[tmp] = tmp;
            } else {
                i++;
            }
        }
        System.out.println("solution3 spend time: " + (System.currentTimeMillis() - curr) + " ms, loop: " + loop);
        return result;
    }

    public static int[] genArray(int max) {

        Random rand = new Random();
        int[] result = new int[max];
        List<Integer> list = new ArrayList<>(max);
        for (int i = 0; i < max-1; i++) {
            list.add(i);
        }
//        list.add(rand.nextInt(max-1));
        list.add(max/2);
        Collections.shuffle(list);

        for (int i = 0; i < max; i++)
            result[i] = list.get(i);
        return result;
    }

    public static void main(String[] args) {

//        solution1(new int[]{2, 3, 1, 0, 2, 5, 3});
//        solution2(new int[]{2, 3, 1, 0, 2, 5, 3});
//        solution3(new int[]{2, 3, 1, 0, 2, 5, 3});

        System.out.println();
        System.out.println("test array length: 5000");
        int[] testArr = genArray(50000);
        solution1(testArr.clone());
        solution2(testArr.clone());
        solution3(testArr.clone());
        System.out.println(" ------------------------------------------------- ");
        System.out.println();

        System.out.println("test array length: 50000");
        testArr = genArray(50000);
        solution1(testArr.clone());
        solution2(testArr.clone());
        solution3(testArr.clone());
        System.out.println(" ------------------------------------------------- ");
        System.out.println();

        System.out.println("test array length: 500000");
        testArr = genArray(500000);
        solution1(testArr.clone());
        solution2(testArr.clone());
        solution3(testArr.clone());
        System.out.println(" ------------------------------------------------- ");
        System.out.println();

        System.out.println("test array length: 5000000");
        testArr = genArray(5000000);
        solution1(testArr.clone());
        solution2(testArr.clone());
        solution3(testArr.clone());
        System.out.println(" ------------------------------------------------- ");
        System.out.println();
    }
}
