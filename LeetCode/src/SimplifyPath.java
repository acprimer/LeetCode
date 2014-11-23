import java.util.Stack;

/**
 * Created by yaodh on 2014/11/23.
 * <p/>
 * LeetCode: Simplify Path
 * Link: https://oj.leetcode.com/problems/simplify-path/
 * Description:
 * -----------------------------
 * Given an absolute path for a file (Unix-style), simplify it.
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * click to show corner cases.
 * Corner Cases:
 * Did you consider the case where path = "/../"?
 * In this case, you should return "/".
 * Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
 * In this case, you should ignore redundant slashes and return "/home/foo".
 * -----------------------------
 * <p/>
 * Tag: Stack
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        if (path == null || path.equals("")) return path;
        String[] split = path.split("/");
        Stack<String> stack = new Stack<String>();
        for (String dir : split) {
            if (dir.equals("") || dir.equals(".")) {
                continue;
            }
            if (dir.equals("..")) {
                if (!stack.empty()) stack.pop();
            } else {
                stack.push(dir);
            }
        }
        if (stack.empty()) {
            return "/";
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.empty()) {
            builder.insert(0, "/" + stack.peek());
            stack.pop();
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String ans = new SimplifyPath().simplifyPath("/abc/...");
        System.out.println(ans);
    }
}
