package LC.string;

public class Atoi {

    public int myAtoi(String s) {
        int N = s.length();
        if (N == 0)
            return 0;
        long res = 0;
        int i = 0;
        int neg = 1;
        char space = ' ';
        while (i < N && s.charAt(i) == space)
            i++;
        if (i < N) {
            if (s.charAt(i) == '-') {
                neg = -1;
                ++i;
            } else if (s.charAt(i) == '+') {
                ++i;
            }
        }
        while (i < N) {
            char c = s.charAt(i++);
            if (Character.isDigit(c)) {
                res = (res * 10) + Character.digit(c, 10);
            } else {
                break;
            }
            if (neg == -1 && neg * res <= Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            } else if (neg != -1 && res >= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
        }
        return (int) (neg * res);
    }

    public static void main(String[] args) {
        Atoi atoi = new Atoi();
        System.out.println(atoi.myAtoi("42"));
        System.out.println(atoi.myAtoi("-42"));
        System.out.println(atoi.myAtoi("4193 with words"));
        System.out.println(atoi.myAtoi(""));
        System.out.println(atoi.myAtoi(" "));
        System.out.println(atoi.myAtoi(" DA"));
        System.out.println(atoi.myAtoi("words and 987"));
        System.out.println(atoi.myAtoi("-91283472332"));
        System.out.println(atoi.myAtoi("+91283472332"));
        System.out.println(atoi.myAtoi("-147483648"));
        System.out.println(atoi.myAtoi("-2147483647"));
    }
}
