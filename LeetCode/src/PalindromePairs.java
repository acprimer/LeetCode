import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        int n = words.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (isPalindrome(words[i], words[j])) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }

    private boolean isPalindrome(String s, String t) {
        String cat = s + t;
        for (int i = 0, j = cat.length() - 1; i < j; i++, j--) {
            if (cat.charAt(i) != cat.charAt(j)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<Integer>> ans = new PalindromePairs().palindromePairs(new String[]{
                "abcd","dcba","lls","s","sssll"
        });
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i).get(0) + " " + ans.get(i).get(1));
        }
    }
}
