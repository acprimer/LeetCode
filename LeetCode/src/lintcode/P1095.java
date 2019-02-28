package lintcode;

public class P1095 {
    public static void main(String[] args) {
        System.out.println(new P1095().maximumSwap(7236));
    }

    public int maximumSwap(int num) {
        int ans = num;
        int len = getLen(num);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                ans = Math.max(ans, swap(num, i, j));
            }
        }
        return ans;
    }

    private int getLen(int num) {
        int len = 0;
        while (num > 0) {
            num /= 10;
            len++;
        }
        return len;
    }

    private int swap(int num, int i, int j) {
        if (i == j) return num;
        char[] ch = String.valueOf(num).toCharArray();
        char t = ch[i];
        ch[i] = ch[j];
        ch[j] = t;
        return Integer.parseInt(String.valueOf(ch));
    }
}
