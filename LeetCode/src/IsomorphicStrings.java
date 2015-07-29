/**
 * Created by yaodh on 15/7/28.
 */
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        char[] map = new char[256];
        boolean[] used = new boolean[256];
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            if(map[ch] == 0) {
                if(used[t.charAt(i)]) {
                    return false;
                }
                map[ch] = t.charAt(i);
                used[t.charAt(i)] = true;
            } else {
                if(map[ch] != t.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }
}
