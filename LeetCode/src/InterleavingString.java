/**
 * Created by yaodh on 2014/11/18.
 */
public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        int size = s3.length();
        boolean[][] dp = new boolean[size + 1][size + 1];
        for (int i = 0; i < dp.length; i++) dp[0][i] = true;
        for (int i = 1; i <= size; i++) {
            if (i >= s1.length()) {
                int j;
                for (j = i; j <= size; j++) {
                    if (s2.charAt(i - 1) == s3.charAt(j - 1) && dp[i - 1][j - 1]) {
                        break;
                    }
                }
                if (j > size) return false;
                for (; j <= size; j++) dp[i][j] = true;
            }
            if (i >= s2.length()) {
                int j;
                for (j = i; j <= size; j++) {
                    if (s1.charAt(i - 1) == s3.charAt(j - 1) && dp[i - 1][j - 1]) {
                        break;
                    }
                }
                if (j > size) return false;
                for (; j <= size; j++) dp[i][j] = true;
            }
            int j;
            for (j = i; j <= size; j++) {
                if (s1.charAt(i - 1) == s3.charAt(j - 1) && dp[i - 1][j - 1]) {
                    break;
                }
            }
            if (j > size) return false;
            int idx1 = j;
            for (j = i; j <= size; j++) {
                if (s2.charAt(i - 1) == s3.charAt(j - 1) && dp[i - 1][j - 1]) {
                    break;
                }
            }
            if (j > size) return false;
            int idx2 = j;
            if (s1.charAt(i - 1) != s2.charAt(i - 1)) {
                j = Math.max(idx1, idx2);
                for (; j <= size; j++) dp[i][j] = true;
            } else {
                for (; j <= size; j++) {
                    if (s1.charAt(i - 1) == s3.charAt(j - 1)) {
                        break;
                    }
                }
                if (j > size) return false;
                for (; j <= size; j++) dp[i][j] = true;
            }
            for(int k=1;k<=size;k++) {
                System.out.print(dp[i][k] + " ");
            }
            System.out.println();
        }
        return true;
    }

    public static void main(String[] args) {
        boolean ans = new InterleavingString().isInterleave("aabcc", "dbbca", "aadbbcbcac");
        System.out.println(ans);
    }
}
