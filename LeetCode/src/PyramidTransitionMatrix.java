import java.util.*;

public class PyramidTransitionMatrix {
    private Map<String, StringBuilder> map = null;

    private void genMap(List<String> allowed) {
        if (map != null) return;
        map = new HashMap<>();
        for (String word : allowed) {
            String key = word.substring(0, 2);
            char val = word.charAt(2);
            StringBuilder builder = map.getOrDefault(key, new StringBuilder());
            builder.append(val);
            map.put(key, builder);
        }
    }

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        genMap(allowed);
        if (bottom.length() == 1) return true;
        return dfs(bottom, "");
    }

    public boolean dfs(String bottom, String cur) {
        int start = cur.length() + 1;
        if (start >= bottom.length()) {
            if (cur.length() == 1) return true;
            // next line
            return dfs(cur, "");
        }

        String key = bottom.substring(start - 1, start + 1);
        if (!map.containsKey(key)) return false;
        StringBuilder builder = map.get(key);
        for (int j = 0; j < builder.length(); j++) {
            char ch = builder.toString().charAt(j);
            if (dfs(bottom, cur + ch)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new PyramidTransitionMatrix()
                .pyramidTransition("X", Arrays.asList("XXX", "XXY", "XYX", "XYY", "YXZ")));
    }

}
