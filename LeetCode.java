import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode {

    /**
     * Given a string, find the length of the longest substring without repeating characters.
     */
    public static int lengthOfLongestSubstring(String s) {

        String result = "";
        String subString = "";
        int i;
        int j = 0;

        while (j < s.length()) {
            i = 0;
            subString = "";
            while (i < s.length() - j) {
                if (subString.indexOf(s.charAt(j + i)) == -1) {
                    subString = subString + s.charAt(j + i);
                } else break;
                i++;
            }
            if (result.length() < subString.length()) {
                result = subString;
                subString = "";
            }
            j++;
        }
        return result.length();
    }

    /**
     * Given a string, find the length of the longest substring without repeating characters.
     */
    public static int lengthOfLongestSubstringS(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;

    }

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
