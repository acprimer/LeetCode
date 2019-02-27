package airbnb;

public class AlienDictionary {
    private static int ALPHA_COUNT = 26;

    public String alienOrder(String[] words) {
        boolean[][] graph = getGraph(words);
        boolean[] alpha = getAlpha(words);
        return topologicalSort(graph, alpha);
    }

    private boolean[] getAlpha(String[] words) {
        boolean[] alpha = new boolean[ALPHA_COUNT];
        for (String w : words) {
            for (int i = 0; i < w.length(); i++) {
                alpha[w.charAt(i) - 'a'] = true;
            }
        }
        return alpha;
    }

    private boolean[][] getGraph(String[] words) {
        boolean[][] graph = new boolean[ALPHA_COUNT][ALPHA_COUNT];
        for (int i = 1; i < words.length; i++) {
            compareWord(graph, words[i - 1], words[i]);
        }
        return graph;
    }

    private void compareWord(boolean[][] graph, String s, String t) {
        for (int i = 0; i < s.length() && i < t.length(); i++) {
            if (s.charAt(i) == t.charAt(i)) continue;
            graph[s.charAt(i) - 'a'][t.charAt(i) - 'a'] = true;
        }
    }

    private String topologicalSort(boolean[][] graph, boolean[] alpha) {
        StringBuilder builder = new StringBuilder();
        boolean found = true;
        while (found) {
            found = false;
            for (int col = 0; col < ALPHA_COUNT; col++) {
                if (!alpha[col]) continue;
                int degree = 0;
                for (int row = 0; row < ALPHA_COUNT; row++) {
                    if (graph[row][col]) degree++;
                }
                if (degree == 0) {
                    found = true;
                    builder.append((char)('a' + col));
                    alpha[col] = false;
                    for (int i = 0; i < ALPHA_COUNT; i++) {
                        graph[col][i] = false;
                    }
                }
            }
        }

        if (!checkGraph(graph)) return "";

        for (int i = 0; i < ALPHA_COUNT; i++) {
            if (alpha[i]) builder.append((char)('a' + i));
        }
        return builder.toString();
    }

    private boolean checkGraph(boolean[][] graph) {
        for (int i = 0; i < ALPHA_COUNT; i++) {
            for (int j = 0; j < ALPHA_COUNT; j++) {
                if (graph[i][j]) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new AlienDictionary().alienOrder(
                new String[]{
                        "wrt",
                        "wrf",
                        "er",
                        "ett",
                        "rftt"
                }
        ));
    }
}
