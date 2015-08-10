import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by yaodh on 2015/3/22.
 */
public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<String>();
        int len = s.length();
        if (len <= 10) {
            return ans;
        }
        Set<String> set = new HashSet<String>();
        for(int i =0;i<len-10;i++) {
            String target = s.substring(i, i+10);
            if(!set.contains(target) && s.lastIndexOf(target) != i) {
                set.add(target);
            }
        }
        for(String str : set) {
            ans.add(str);
        }
        return ans;
    }

    private int getHashCode(String str) {
        int code = 0;
        for(int i=0;i<str.length();i++) {
            code = (code * 11 + str.charAt(i)) % 0x7fffffff;
        }
        return code;
    }

    public int find(int[] num, int target, int start) {
        for (int i = start; i < num.length; i++) {
            if (num[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        List<String> ans = new RepeatedDNASequences().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        for (String str : ans) {
            System.out.println(str);
        }
    }
}
