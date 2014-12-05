/**
 * Created by yaodh on 2014/11/27.
 * <p/>
 * LeetCode: Count and Say
 * Link: https://oj.leetcode.com/problems/count-and-say/
 * Description:
 * -----------------------------
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 * Note: The sequence of integers will be represented as a string.
 * -----------------------------
 * <p/>
 * Tag: String
 */
public class CountAndSay {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        StringBuilder pre = new StringBuilder("1");
        StringBuilder builder = new StringBuilder();
        while (--n > 0) {
            builder = new StringBuilder();
            for (int i = 0; i < pre.length(); i++) {
                char ch = pre.charAt(i);
                int count = 0;
                while (i < pre.length() && ch == pre.charAt(i)) {
                    i++;
                    count++;
                }
                i--;
                builder.append((char) (count + '0'));
                builder.append(ch);
            }
            pre = builder;
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        for (int i = 1; i < 30; i++) {
            String ans = new CountAndSay().countAndSay(i);
            System.out.println(ans);
        }
    }
}
