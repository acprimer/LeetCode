/**
 * Created by yaodh on 2014/12/17.
 * <p/>
 * LeetCode: Compare Version Numbers
 * Link: https://oj.leetcode.com/problems/compare-version-numbers/
 * Description:
 * -----------------------------
 * Compare two version numbers version1 and version1.
 * If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
 * You may assume that the version strings are non-empty and contain only digits and the . character.
 * The . character does not represent a decimal point and is used to separate number sequences.
 * For instance, 2.5 is not "two and a half" or "half way to version three",
 * it is the fifth second-level revision of the second first-level revision.
 * Here is an example of version numbers ordering:
 * 0.1 < 1.1 < 1.2 < 13.37
 * -----------------------------
 * <p/>
 * Tag: String
 */
public class CompareVersionNumbers {
    // 1.0 1
    // 0.1 0.0.1
    public int compareVersion(String version1, String version2) {
        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");
        for (int i = 0; i < split1.length || i < split2.length; i++) {
            int x, y;
            if (i >= split1.length) {
                x = 0;
            } else {
                x = Integer.parseInt(split1[i]);
            }
            if (i >= split2.length) {
                y = 0;
            } else {
                y = Integer.parseInt(split2[i]);
            }
            if (x > y) return 1;
            else if (x < y) return -1;
        }
        return 0;
    }

    public static void main(String[] args) {
        int ans = new CompareVersionNumbers().compareVersion("1.0", "1.0.1");
        System.out.println(ans);
    }
}
