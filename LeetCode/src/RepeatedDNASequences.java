import java.util.*;

/**
 * Created by yaodh on 2015/3/22.
 */
public class RepeatedDNASequences {
//    public List<String> findRepeatedDnaSequences(String s) {
//        List<String> ans = new ArrayList<String>();
//        int len = s.length();
//        if (len <= 10) {
//            return ans;
//        }
//        Set<String> set = new HashSet<String>();
//        for(int i =0;i<len-10;i++) {
//            String target = s.substring(i, i+10);
//            if(!set.contains(target) && s.lastIndexOf(target) != i) {
//                set.add(target);
//            }
//        }
//        for(String str : set) {
//            ans.add(str);
//        }
//        return ans;
//    }
//
//    private int getHashCode(String str) {
//        int code = 0;
//        for(int i=0;i<str.length();i++) {
//            code = (code * 11 + str.charAt(i)) % 0x7fffffff;
//        }
//        return code;
//    }
//
//    public int find(int[] num, int target, int start) {
//        for (int i = start; i < num.length; i++) {
//            if (num[i] == target) {
//                return i;
//            }
//        }
//        return -1;
//    }

    private int getNum(String s, int idx) {
        if (idx < 0) return 0;
        switch (s.charAt(idx)) {
            case 'A': return 0;
            case 'C': return 1;
            case 'G': return 2;
            case 'T': return 3;
        }
        return 0;
    }

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>();
        if (s.length() <= 10) {
            return ans;
        }

        int x = 0;
        for (int i = 0; i < 9; i++) {
            x = (x << 2) + getNum(s, i);
        }

        int first = -1;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 9; i < s.length(); i++) {
            x = ((x - (getNum(s, first++) << 18)) << 2) + getNum(s, i);
            if (!map.containsKey(x)) {
                map.put(x, i);
            } else {
                // find the string
                if (map.get(x) > 0) {
                    ans.add(s.substring(i - 9, i + 1));
                    map.put(x, -1);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<String> ans = new RepeatedDNASequences().findRepeatedDnaSequences("AAAAAAAAAAAAAA");
        for (String str : ans) {
            System.out.println(str);
        }
    }
}
