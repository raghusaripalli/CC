package LC.math;

public class PalindromeNumber {
    public boolean isPalindromeUsingString(int x) {
        String s = String.valueOf(x);
        int N = s.length();
        for (int i = 0; i < N / 2; i++) {
            if (s.charAt(i) != s.charAt(N - i - 1))
                return false;
        }
        return true;
    }

    public boolean isPalindromeUsingLong(int x) {
        if (x < 0)
            return false;
        long res = 0, num = x;
        while (x != 0) {
            res = res * 10 + (x % 10);
            x /= 10;
        }
        return res == num;
    }

    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        int res = 0, num = x;
        int imax = Integer.MAX_VALUE / 10;
        while (x != 0) {
            int rem = x % 10;
            if (res > imax || (res == imax && rem > 7)) return false;
            res = res * 10 + rem;
            x /= 10;
        }
        return res == num;
    }

    public static void main(String[] args) {
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        System.out.println(palindromeNumber.isPalindrome(-121));
        System.out.println(palindromeNumber.isPalindrome(-1101));
        System.out.println(palindromeNumber.isPalindrome(-3669987));
        System.out.println(palindromeNumber.isPalindrome(121));
        System.out.println(palindromeNumber.isPalindrome(0));
        System.out.println(palindromeNumber.isPalindrome(10));
        System.out.println(palindromeNumber.isPalindrome(1999991));
        System.out.println(palindromeNumber.isPalindrome(2147483647));
    }
}
