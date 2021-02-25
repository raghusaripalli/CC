package LC.math;

public class ReverseInteger {

    // frowned solution
    public int reverseFrowned(int x) {
        boolean neg = false;
        if (x < 0) {
            neg = true;
            x = -x;
        }
        long rev = 0L;
        while (x != 0) {
            rev = (rev * 10) + (x % 10);
            x /= 10;
        }
        if (neg)
            rev = -rev;
        if (rev < Integer.MIN_VALUE || rev > Integer.MAX_VALUE)
            return 0;
        return (int) rev;
    }

    // authentic solution
    public int reverse(int x) {
        int rev = 0, rem;
        int imax = Integer.MAX_VALUE / 10, imin = Integer.MIN_VALUE / 10;
        while (x != 0) {
            rem = x % 10;
            if (rev > imax || (rev == imax && rem > 7)) return 0;
            if (rev < imin || (rev == imin && rem < -8)) return 0;
            rev = rev * 10 + rem;
            x /= 10;
        }
        return rev;
    }

    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        System.out.println(reverseInteger.reverse(123));
        System.out.println(reverseInteger.reverse(-123));
        System.out.println(reverseInteger.reverse(120));
        System.out.println(reverseInteger.reverse(0));
    }
}
