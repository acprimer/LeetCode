public class FlipStringToMonotoneIncreasing {
    public int minFlipsMonoIncr(String S) {
        int[][] cnt = new int[2][S.length()+1];
        for (int i = 1; i < S.length() + 1; i++) {
            char ch = S.charAt(i-1);
            cnt[0][i] = cnt[0][i-1] + (ch == '0' ? 1 : 0);
            cnt[1][i] = cnt[1][i-1] + (ch == '1' ? 1 : 0);
        }

        int ans = S.length();
        for (int i = 0; i < S.length() + 1; i++) {
            ans = Math.min(ans, cnt[1][i] + cnt[0][S.length()] - cnt[0][i]);
        }
        return ans;
    }
}
