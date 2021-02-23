package LC.dp;

import java.util.HashSet;
import java.util.Set;

public class LongestPalindromicSubstring {
    boolean isPalindrome(String s) {
        int N = s.length();
        for (int i = 0; i < N / 2; i++) {
            if (!(s.charAt(i) == s.charAt(N - i - 1)))
                return false;
        }
        return true;
    }

    public String longestPalindrome(String s) {
        Set<String> mem = new HashSet<>();
        String res = "";
        int N = s.length();
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                String part = s.substring(i, j + 1);
                if (!mem.contains(part)) {
                    if (isPalindrome(part)) {
                        mem.add(part);
                        if (part.length() > res.length())
                            res = part;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
        longestPalindromicSubstring.longestPalindrome("a");
        longestPalindromicSubstring.longestPalindrome("bb");
        longestPalindromicSubstring.longestPalindrome("jkexvzsqshsxyytjmmhauoyrbxlgvdovlhzivkeixnoboqlfemfzytbolixqzwkfvnpacemgpotjtqokrqtnwjpjdiidduxdprngvitnzgyjgreyjmijmfbwsowbxtqkfeasjnujnrzlxmlcmmbdbgryknraasfgusapjcootlklirtilujjbatpazeihmhaprdxoucjkynqxbggruleopvdrukicpuleumbrgofpsmwopvhdbkkfncnvqamttwyvezqzswmwyhsontvioaakowannmgwjwpehcbtlzmntbmbkkxsrtzvfeggkzisxqkzmwjtbfjjxndmsjpdgimpznzojwfivgjdymtffmwtvzzkmeclquqnzngazmcfvbqfyudpyxlbvbcgyyweaakchxggflbgjplcftssmkssfinffnifsskmsstfclpjgblfggxhckaaewyygcbvblxypduyfqbvfcmzagnznquqlcemkzzvtwmfftmydjgvifwjoznzpmigdpjsmdnxjjfbtjwmzkqxsizkggefvztrsxkkbmbtnmzltbchepwjwgmnnawokaaoivtnoshywmwszqzevywttmaqvncnfkkbdhvpowmspfogrbmuelupcikurdvpoelurggbxqnykjcuoxdrpahmhiezaptabjjulitrilkltoocjpasugfsaarnkyrgbdbmmclmxlzrnjunjsaefkqtxbwoswbfmjimjyergjygzntivgnrpdxuddiidjpjwntqrkoqtjtopgmecapnvfkwzqxilobtyzfmeflqobonxiekvizhlvodvglxbryouahmmjtyyxshsqszvxekj");
    }
}
