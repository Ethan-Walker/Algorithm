package leetcode;

import org.junit.Test;

/**
 * created by Ethan-Walker on 2019/1/12
 */
public class Q008_AtoI {
    public int myAtoi(String str) {
        if (str == null || str.trim().length() == 0) return 0;
        str = str.trim();
        int i = 0;
        boolean positive = true;
        if (str.charAt(0) == '-') {
            i++;
            positive = false;
        } else if (str.charAt(0) == '+') {
            i++;
        } else if (!isDigit(str.charAt(0))) {
            // 第一个字符不是 -/+, 也不是数字
            return 0;
        }
        int cur = 0, sum = 0;
        int minq = Integer.MIN_VALUE / 10;
        int minr = Integer.MIN_VALUE % 10;
        for (; i < str.length() && isDigit(str.charAt(i)); i++) {
            cur = '0' - str.charAt(i);
            if (sum < minq || (sum == minq && cur < minr))
                return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            sum = sum * 10 + cur;
        }
        if (positive && sum == Integer.MIN_VALUE) {
            return Integer.MAX_VALUE; // 正数溢出
        }
        return positive ? -sum : sum;

    }

    public boolean isDigit(char ch) {
        if (ch >= '0' && ch <= '9') return true;
        return false;
    }

    @Test
    public void test() {
        System.out.println(myAtoi("42"));
        System.out.println(myAtoi("   -42"));
        System.out.println(myAtoi("4193 with words"));
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("+21"));
        System.out.println(myAtoi("+00021"));
        System.out.println(myAtoi("-2147483648"));
        System.out.println(myAtoi("+2147483648"));
        System.out.println(myAtoi("+2147483647"));
    }


}
