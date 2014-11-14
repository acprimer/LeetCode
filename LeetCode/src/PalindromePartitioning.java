import java.util.ArrayList;
import java.util.List;

/**
 * Created by yao on 2014/11/14.
 */
public class PalindromePartitioning {
    List<List<String>> pList;
    public List<List<String>> partition(String s) {
        pList = new ArrayList<List<String>>();
        dfs(s, null);
        return pList;
    }

    private void dfs(String s, List<String> list) {
        for(int i=0;i<s.length();i++) {
            String palindromeString = s.substring(0, i+1);
            if(testPalindrome(palindromeString)) {
                List<String> cur = new ArrayList<String>();
                if(list != null) {
                    cur.addAll(list);
                }
                cur.add(palindromeString);
                if(i == s.length() - 1) {
                    pList.add(cur);
                    return ;
                }
                dfs(s.substring(i+1, s.length()), cur);
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
        List<List<String>> lists = new PalindromePartitioning().partition("aaa");
        for(List<String> list : lists) {
            for(String s : list) {
                System.out.print(s + ",");
            }
            System.out.println();
        }
    }
}
