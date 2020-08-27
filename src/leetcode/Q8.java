package leetcode;


public class Q8 {

    public int myAtoi(String str) {
        if (str == null || !str.matches("\\s*(-?\\d+).*"))
            return 0;

        boolean start = false, overflow = false;
        int result = 0, bit = 0;
        for (int i = str.length() - 1; i >= 0; i--) {

            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {

                if (!start) {
                    start = true;
                    result =  0;
                    overflow = false;
                    bit = 0;
                }

                int newResult = result + (int)((str.charAt(i) - '0') * Math.pow(10, bit++));
                if (newResult < result)
                    overflow = true;
                else
                    result = newResult;
            } else if (start && str.charAt(i) == '-') {
                result = -result;
                start = false;
            } else if (start) {
                start = false;
            }
        }

        return overflow ? (result < 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE) : result;
    }

    public static void main(String[] args) {
        System.out.println(new Q8().myAtoi("        2147483648    dsdsdsd        "));
        System.out.println(new Q8().myAtoi("   0-1"));
    }
}
