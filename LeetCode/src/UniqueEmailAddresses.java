import java.util.HashSet;
import java.util.Set;

/**
 * Created by yaodh on 2018/11/6.
 */
public class UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>(emails.length);
        for (String s : emails) {
            set.add(parseEmail(s));
        }
        return set.size();
    }

    private String parseEmail(String email) {
        String[] splits = email.split("@");
        char[] arr = new char[email.length()];
        int count = 0;
        for (char ch : splits[0].toCharArray()) {
            if (ch == '+') break;
            if (ch == '.') continue;
            arr[count++] = ch;
        }
        return String.valueOf(arr, 0, count) + splits[1];
    }

    public static void main(String[] args) {
        System.out.println(new UniqueEmailAddresses().numUniqueEmails(new String[]{"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"}));
    }
}
