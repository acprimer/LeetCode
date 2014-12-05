import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaodh on 2014/11/28.
 * <p/>
 * LeetCode: Letter Combinations of a Phone Number
 * Link: https://oj.leetcode.com/problems/letter-combinations-of-a-phone-number/
 * Description:
 * -----------------------------
 * Given a digit string, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 * -----------------------------
 * <p/>
 * Tag: Backtracking
 */
public class LetterCombinationsOfAPhoneNumber {
    public static final String[] letters = new String[]{" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> ans = new ArrayList<String>();

    public List<String> letterCombinations(String digits) {
        dfs(digits, 0, "");
        return ans;
    }

    private void dfs(String digits, int start, String str) {
        if (start >= digits.length()) {
            ans.add(str);
            return;
        }
        for (int i = 0; i < letters[digits.charAt(start) - '0'].length(); i++) {
            dfs(digits, start + 1, str + letters[digits.charAt(start) - '0'].charAt(i));
        }
    }

    public static void main(String[] args) {
        List<String> ans = new LetterCombinationsOfAPhoneNumber().letterCombinations("23");
        for (String str : ans) {
            System.out.println(str);
        }
    }
}
