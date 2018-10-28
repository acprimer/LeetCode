public class LongPressedName {
    public boolean isLongPressedName(String name, String typed) {
        if (name == null && typed == null) {
            return true;
        }
        if (name == null || typed == null || name.length() > typed.length()) {
            return false;
        }
        int i = 0;
        for (int j = 0; i < name.length() && j < typed.length();j++) {
            if (name.charAt(i) == typed.charAt(j)) {
                i++;
                continue;
            }
        }
        return i>= name.length();
    }

    public static void main(String[] args) {
        System.out.println(new LongPressedName().isLongPressedName("alex", "aaleex"));
    }
}
