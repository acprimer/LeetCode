import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yaodh on 2014/11/23.
 * <p/>
 * LeetCode: Text Justification
 * Link: https://oj.leetcode.com/problems/text-justification/
 * Description:
 * -----------------------------
 * Given an array of words and a length L,
 * format the text such that each line has exactly L characters and is fully (left and right) justified.
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line.
 * Pad extra spaces ' ' when necessary so that each line has exactly L characters.
 * Extra spaces between words should be distributed as evenly as possible.
 * If the number of spaces on a line do not divide evenly between words,
 * the empty slots on the left will be assigned more spaces than the slots on the right.
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 * For example,
 * words: ["This", "is", "an", "example", "of", "text", "justification."]
 * L: 16.
 * Return the formatted lines as:
 * [
 * "This    is    an",
 * "example  of text",
 * "justification.  "
 * ]
 * Note: Each word is guaranteed not to exceed L in length.
 * -----------------------------
 * <p/>
 * Tag: Greedy
 */
public class TextJustification {
//    public List<String> fullJustify(String[] words, int L) {
//        List<String> ans = new ArrayList<String>();
//        int i = 0;
//        while (i < words.length) {
//            StringBuilder builder = new StringBuilder(words[i]);
//            int j = i + 1, len = words[i].length();
//            while (j < words.length) {
//                len += words[j].length() + 1;
//                if (len > L) {
//                    len -= words[j].length() + 1;
//                    break;
//                }
//                j++;
//            }
//            int spaceCount, left;
//            if (j >= words.length) {
//                // the last line
//                spaceCount = 1;
//                left = 0;
//            } else if (j - i - 1 == 0) {
//                spaceCount = 1;
//                left = 0;
//            } else {
//                spaceCount = (L - len) / (j - i - 1) + 1;
//                left = (L - len) % (j - i - 1);
//            }
//            char[] spaces1 = new char[spaceCount];
//            char[] spaces2 = new char[spaceCount + 1];
//            for (int k = 0; k < spaceCount; k++) {
//                spaces1[k] = ' ';
//                spaces2[k] = ' ';
//            }
//            spaces2[spaceCount] = ' ';
//            for (int k = i + 1; k < j; k++) {
//                builder.append(left >= k - i ? spaces2 : spaces1);
//                builder.append(words[k]);
//            }
//            int remaining = L - builder.length();
//            for (int k = 0; k < remaining; k++) {
//                builder.append(' ');
//            }
//            i = j;
//            ans.add(builder.toString());
//        }
//        return ans;
//    }

    public static void main(String[] args) {
        List<String> ans = new TextJustification().fullJustify(new String[]{"Listen", "to", "many,", "speak", "to", "a", "few."}, 6);
        for (String line : ans) {
            System.out.println(line);
        }
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int start = 0;
        int len = 0;
        for (int i = 0; i < words.length; i++) {
            len += words[i].length();
            if (len + i - start > maxWidth) {
                ans.add(fill(words, maxWidth, start, --i));
                start = i + 1;
                len = 0;
            } else if (i >= words.length - 1) {
                ans.add(fill(words, maxWidth, start, i));
            }
        }
        return ans;
    }

    private String fill(String[] words, int maxWidth, int start, int end) {
        boolean lastLine = (end >= words.length - 1 || start == end);
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += words[i].length();
        }
        int space = maxWidth - sum;
        StringBuilder builder = new StringBuilder();
        int count = 1;
        int mod = 0;
        if (!lastLine) {
            count = space / (end - start);
            mod = space % (end - start);
        }
        char[] arr = spaceArray(count);
        for (int i = start; i < end; i++) {
            builder.append(words[i]);
            if (i - start < mod) {
                builder.append(' ');
            }
            builder.append(arr);
        }
        builder.append(words[end]);
        if (builder.length() < maxWidth) {
            builder.append(spaceArray(maxWidth - builder.length()));
        }
        return builder.toString();
    }

    private char[] spaceArray(int n) {
        char[] arr = new char[n];
        Arrays.fill(arr, ' ');
        return arr;
    }
}
