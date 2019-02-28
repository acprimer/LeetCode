package lintcode;

import java.util.Arrays;

public class P8 {
    public static void main(String[] args) {
        char[] ch = "abcdefg".toCharArray();
        new P8().rotateString(ch, 20);
        System.out.println(ch);
    }

    public void rotateString(char[] str, int offset) {
        if (str == null || str.length == 0) return;
        int len = str.length;
        offset %= len;
        if (offset == 0) return;
        char[] ch = Arrays.copyOf(str, len);
        System.arraycopy(ch, len - offset, str, 0, offset);
        System.arraycopy(ch, 0, str, offset, len - offset);
    }
}
