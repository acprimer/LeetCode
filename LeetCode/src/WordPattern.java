import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] split = str.trim().split("\\s+");
        if (split.length != pattern.length()) return false;

        Map<String, Character> map = new HashMap<>(pattern.length());
        Set<Character> set = new HashSet<>(pattern.length());
        for (int i = 0; i < pattern.length(); i++) {
            if (map.containsKey(split[i])) {
                char value = map.get(split[i]);
                if (value != pattern.charAt(i)) return false;
            } else {
                if (set.contains(pattern.charAt(i))) return false;
                map.put(split[i], pattern.charAt(i));
                set.add(pattern.charAt(i));
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new WordPattern().wordPattern("abba", "  dog  cat  cat  dog  "));
        System.out.println(new WordPattern().wordPattern("abba", "dog cat cat fish"));
        System.out.println(new WordPattern().wordPattern("aaaa", "dog cat cat dog"));
        System.out.println(new WordPattern().wordPattern("abba", "dog dog dog dog"));
    }
}
