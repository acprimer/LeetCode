public class DecodeString {
    public String decodeString(String s) {
        // 3[a2[c]] accaccacc
        
        return null;
    }

    private String multi(String s, int count) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            builder.append(s);
        }
        return builder.toString();
    }
}
