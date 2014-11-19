import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaodh on 2014/11/19.
 *
 * LeetCode: Restore IP Addresses
 * Link: https://oj.leetcode.com/problems/restore-ip-addresses/
 * Description:
 * -----------------------------
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * For example:
 * Given "25525511135",
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 * -----------------------------
 *
 * Tag: Backtracking
 */
public class RestoreIPAddresses {
    int[] address = new int[4];
    List<String> ans = new ArrayList<String>();
    public List<String> restoreIpAddresses(String s) {
        if(s == null || s.length() < 4) {
            return ans;
        }
        dfs(s, 0, 0);
        return ans;
    }

    private void dfs(String s, int start, int count) {
        int num = 0;
        if(count >= 3) {
            if(validNumber(s.substring(start, s.length()))) {
                address[count] = Integer.valueOf(s.substring(start, s.length()));
                validAddress();
            }
            return;
        }
        if(s.charAt(start) == '0') {
            address[count] = 0;
            dfs(s, start+1, count+1);
            return;
        }
        for(int i=start;i<s.length()-3+count;i++) {
            num = num*10 + s.charAt(i) - '0';
            if(num > 255) break;
            address[count] = num;
            dfs(s, i+1, count+1);
        }
    }

    private boolean validNumber(String s) {
        if(s.length() == 1) return true;
        if(s.charAt(0) == '0') return false;
        if(s.length() > 3 || Integer.valueOf(s) > 255) return false;
        return true;
    }

    private void validAddress() {
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<3;i++) {
            builder.append(String.valueOf(address[i]) + ".");
        }
        builder.append(String.valueOf(address[3]));
        ans.add(builder.toString());
    }

    public static void main(String[] args) {
        List<String> ans = new RestoreIPAddresses().restoreIpAddresses("0279245587303");
        for(String line : ans) {
            System.out.println(line);
        }
    }
}
