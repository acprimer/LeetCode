/**
 * Created by yaodh on 2017/12/18.
 */
public class AddStrings {
    public String addStrings(String x, String y) {
        StringBuilder sbx = new StringBuilder(x).reverse();
        StringBuilder sby = new StringBuilder(y).reverse();
        int carry = 0;
        StringBuilder ans = new StringBuilder();
        for (int i = 0, j = 0; i < sbx.length() || j < sby.length(); i++, j++) {
            int nx = (i < sbx.length()) ? sbx.charAt(i) - '0' : 0;
            int ny = (j < sby.length()) ? sby.charAt(i) - '0' : 0;
            int sum = nx + ny + carry;
            ans.append((char) (sum % 10 + '0'));
            carry = sum / 10;
        }
        if (carry > 0) {
            ans.append((char) (carry + '0'));
        }
        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new AddStrings().addStrings("10", "10"));
    }
}
