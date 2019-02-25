public class AdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        if (num == null || num.length() < 3) return false;
        for (int i = 0; i < num.length(); i++) {
            for (int j = i + 1; j < num.length(); j++) {
                if (isValid(num.substring(0, i + 1), num.substring(i + 1, j + 1), 2, num.substring(j + 1))) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isValid(String a, String b, int count, String left) {
        if (!isNumberValid(a) || !isNumberValid(b)) return false;
        if (count >= 3 && left.equals("")) return true;
        String c = add(a, b);
        if (left.startsWith(String.valueOf(c))) {
            return isValid(b, c, count + 1, left.substring(c.length()));
        } else {
            return false;
        }
    }

    private boolean isNumberValid(String x) {
        return x.length() == 1 || !x.startsWith("0");
    }

    private String add(String a, String b) {
        int carry = 0;
        char[] arr = new char[Math.max(a.length(), b.length())];
        int k = arr.length - 1;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = charAt(a, i) + charAt(b, j) + carry;
            carry = sum / 10;
            arr[k--] = (char) ('0' + sum % 10);
        }
        if (carry > 0) return carry + String.valueOf(arr);
        else return String.valueOf(arr);
    }

    private int charAt(String str, int index) {
        if (index >= 0 && index < str.length()) return str.charAt(index) - '0';
        else return 0;
    }

    public static void main(String[] args) {
        System.out.println(new AdditiveNumber().isAdditiveNumber("101"));
    }
}
