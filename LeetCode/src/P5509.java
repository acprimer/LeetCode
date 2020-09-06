import java.util.*;

public class P5509 {

    public int minCost(String s, int[] cost) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int len = 0;
            int start = i;
            while (i < s.length() && s.charAt(i) == ch) {
                i++;
                len++;
            }
            if (len > 1) {
                Arrays.sort(cost, start, i);
                for (int j = start; j < i - 1; j++) {
                    ans += cost[j];
                }
            }
            i--;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new P5509().minCost("abaac", new int[]{1,2,3,4,5}));
        System.out.println(new P5509().minCost("abc", new int[]{1,2,3}));
        System.out.println(new P5509().minCost("aabaa", new int[]{1,2,3,4,1}));
        System.out.println(new P5509().minCost("aaaaaaaaaaaaaa", new int[]{1,3,6,5,4,5,4,4,2,8,3,10,6,6}));
        System.out.println(new P5509().minCost("cddcdcae", new int[]{4,8,8,4,4,5,4,2}));
    }
}
