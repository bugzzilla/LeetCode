public class LeetCode {

    /**
     * Given a 32-bit signed integer, reverse digits of an integer.
     */
    public static int reverse(int x) {
        try {
            if (x >= 0) {
                return Integer.parseInt(new StringBuilder(Integer.toString(x)).reverse().toString());
            } else {
                return -Integer.parseInt(new StringBuilder(Integer.toString(Math.abs(x))).reverse().toString());
            }
        } catch (Exception ignored) {
            return 0;
        }
    }

    /**
     * Implement atoi to convert a string to an integer.
     */
    public static int atoi(String x) {

        double result = 0;
        int i = 0;

        if (x == null) { return 0; }
        x = x.trim();
        if (x.isEmpty()) { return 0; }

        char sign = '+';

        if (x.charAt(0) == '-') {
            sign = '-';
            i++;
        } else if (x.charAt(0) == '+') {
            i++;
        }

        while (x.length() > i && x.charAt(i) >= '0' && x.charAt(i) <= '9') {
            result = result * 10 + (x.charAt(i) - '0');
            i++;
        }

        if (sign == '-')
            result = -result;

        if (result > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        if (result < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        return (int)result;

    }

}
