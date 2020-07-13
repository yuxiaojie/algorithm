package leetcode;

public class Q50 {

    public double fastPow(double x, int n) {
        if (n == 0)
            return 1;

        double half = fastPow(x, n / 2);
        return n % 2 == 0 ? half * half : half * half * x;
    }

    public double myPow(double x, int n) {
        if (n < 0)
            return fastPow(1 / x, -n);
        else
            return fastPow(x, n);
    }

    public static void main(String[] args) {
        Q50 q = new Q50();
        System.out.println(q.myPow(2.00000, -4));
        System.out.println(q.myPow(2.00000, 0));
        System.out.println(q.myPow(2.00000, -2147483648));
    }
}
