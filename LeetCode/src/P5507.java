public class P5507 {

    public static void main(String[] args) {
        System.out.println(new P5507().modifyString("?zs"));
        System.out.println(new P5507().modifyString("ubv?w"));
        System.out.println(new P5507().modifyString("j?qg??b"));
        System.out.println(new P5507().modifyString("??yw?ipkj?"));
        System.out.println(new P5507().modifyString("??"));
    }

    public String modifyString(String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '?') {
                int left = i;
                int right = i;
                while (i < s.length() && s.charAt(i) == '?') {
                    right=i;
                    i++;
                }
                i--;
                builder.append(gen(right - left + 1, left -1 >= 0 ? s.charAt(left-1) : '0', right + 1 < s.length() ? s.charAt(right+1) : '0'));
            } else {
                builder.append(s.charAt(i));
            }
        }
        return builder.toString();
    }

    public String gen(int len, char left, char right) {
        char x = 0;
        char y = 0;
        for (char i = 'a'; i <= 'z'; i++) {
            if (i == left || i == right) continue;
            if (x == 0) x = i;
            else if (y == 0) {
                y = i;
                break;
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (i % 2 == 0) builder.append(x);
            else builder.append(y);
        }
        return builder.toString();
    }
}
