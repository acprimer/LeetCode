import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaodh on 2015/3/22.
 */
public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<String>();
        for(int i=0;i<s.length()-10;i++) {
            String target = s.substring(i,i+10);
            if(s.indexOf(target, i+10) != -1) {
                ans.add(target);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<String> ans = new RepeatedDNASequences().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        for(String str : ans) {
            System.out.println(str);
        }
    }
}
