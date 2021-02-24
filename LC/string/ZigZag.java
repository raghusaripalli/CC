package LC.string;

public class ZigZag {
    public String convert(String s, int numRows) {
        StringBuffer[] sb = new StringBuffer[numRows];
        for (int i = 0; i < numRows; i++) {
            sb[i] = new StringBuffer();
        }
        int i = 0, N = s.length();
        while (i < N) {
            for (int idx = 0; idx < numRows && i < N; idx++, i++) {
                sb[idx].append(s.charAt(i));
            }
            for (int idx = numRows - 2; idx > 0 && i < N; idx--, i++) {
                sb[idx].append(s.charAt(i));
            }
        }

        StringBuffer res = new StringBuffer();
        for (i = 0; i < numRows; i++) {
            res.append(sb[i]);
        }

        return res.toString();
    }

    public static void main(String[] args) {
        ZigZag zigZag = new ZigZag();
        System.out.println(zigZag.convert("PAYPALISHIRING", 3));
        System.out.println(zigZag.convert("PAYPALISHIRING", 4));
        System.out.println(zigZag.convert("A", 4));
        System.out.println(zigZag.convert("A", 1));

    }
}
