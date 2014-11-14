import java.util.ArrayList;
import java.util.List;

/**
 * Created by yao on 2014/11/14.
 */
public class PalindromePartitioningII {
    int ans = Integer.MAX_VALUE;
    public int minCut(String s) {
        dfs(s, 0);
        return ans-1;
    }

    private void dfs(String s, int cnt) {
        for(int i=0;i<s.length();i++) {
            String palindromeString = s.substring(0, i+1);
            if(testPalindrome(palindromeString)) {
                int curCnt = cnt+1;
                if(i == s.length() - 1) {
                    ans = Math.min(ans, curCnt);
                    return ;
                }
                dfs(s.substring(i+1, s.length()), curCnt);
            }
        }
    }

    private boolean testPalindrome(String s) {
        int i=0, j=s.length()-1;
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) return false;
            i++; j--;
        }
        return true;
    }

    public static void main(String[] args) {
        int ans = new PalindromePartitioningII().minCut("aab");
        System.out.println(ans);
    }
}
