import java.util.*;

/**
 * Created by yaodh on 2014/11/14.
 * <p>
 * LeetCode: Word Ladder
 * Link: https://oj.leetcode.com/problems/word-ladder/
 * Description:
 * -----------------------------
 * Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:
 * ---Only one letter can be changed at a time
 * ---Each intermediate word must exist in the dictionary
 * For example,
 * Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * -----------------------------
 * <p>
 * Tag: BFS Hash Dijstra
 */

public class WordLadder {
//    class Node implements Comparable<Node>{
//        String label;
//        int cost;
//        public Node(String label, int cost) {
//            this.label = label;
//            this.cost = cost;
//        }
//
//        @Override
//        public int compareTo(Node o) {
//            return this.cost > o.cost ? 1 : -1;
//        }
//    }
//
//    public int ladderLength(String start, String end, Set<String> dict) {
//        dict.add(end);
//        Queue<Node> queue = new PriorityQueue<Node>();
//        queue.offer(new Node(start, 1));
//        Set<String> vis = new HashSet<String>();
//        while(!queue.isEmpty()) {
//            Node node = queue.poll();
//            String label = node.label;
//            int cost = node.cost;
//            if(vis.contains(label)) continue;
//            vis.add(label);
//            if(label.equals(end)) return cost;
//            List<String> nextNodes = getArc(label, dict);
//            for(String next : nextNodes) {
//                if(vis.contains(next)) continue;
//                queue.offer(new Node(next, cost+1));
//            }
//        }
//        return 0;
//    }
//
//    private List<String> getArc(String start, Set<String> set) {
//        List<String> arc = new ArrayList<String>();
//        char[] word = new char[start.length()];
//        start.getChars(0, start.length(), word, 0);
//        for(int i=0;i<start.length();i++) {
//            for(char ch = 'a'; ch <= 'z'; ch++) {
//                if(ch == start.charAt(i)) continue;
//                word[i] = ch;
//                String str = new String(word);
//                if(set.contains(str)) {
//                    arc.add(str);
//                }
//            }
//            word[i] = start.charAt(i);
//        }
//        return arc;
//    }

//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//
//    }



    // 邻接矩阵
//    private int dijstra(int[][] graph, int s, int t) {
//        int[] dist = new int[graph.length];
//        boolean[] vis = new boolean[graph.length];
//        for (int i = 0; i < graph.length; i++) {
//            dist[i] = graph[s][i];
//        }
//        dist[s] = 0;
//        vis[s] = true;
//        for (int i = 1; i < graph.length; i++) {
//            int min = Integer.MAX_VALUE;
//            int v = 0;
//            for (int j = 0; j < graph.length; j++) {
//                if (!vis[j] && dist[j] < min) {
//                    v = j;
//                    min = dist[j];
//                }
//            }
//            if (v == t) break;
//            vis[v] = true;
//            for (int j = 0; j < graph.length; j++) {
//                if (!vis[j] && (dist[v] < dist[j] - graph[v][j])) {
//                    dist[j] = dist[v] + graph[v][j];
//                }
//            }
//        }
//        return dist[t];
//    }
    public static void main(String[] args) {
        int ans = new WordLadder().ladderLength("hit", "cog",
                Arrays.asList("hot", "dot", "dog", "lot", "log"));
        System.out.println(ans);
//        int[][] g = new int[][]{
//                {0, 10, Integer.MAX_VALUE},
//                {10, 0, 5},
//                {Integer.MAX_VALUE, 5, 30}
//        };
//        System.out.println(new WordLadder().dijstra(g, 0, 2));
//        g = new int[][]{
//                {1},
//                {0,2},
//                {0}
//        };
//        System.out.println(new WordLadder().dijstra2(g, 0, 2));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, Integer> map = getMap(beginWord, wordList);
        if (!map.containsKey(endWord)) return 0;
        int end = map.get(endWord);
        int[][] arc = new int[map.size()][];
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            arc[entry.getValue()] = getArc(entry.getKey(), map);
        }
        int ans = dijstra(arc, 0, end);
        return ans > wordList.size() ? 0 : ans + 1;
    }

    private Map<String, Integer> getMap(String beginWord, List<String> wordList) {
        int count = 0;
        Map<String, Integer> map = new HashMap<>(wordList.size() + 1);
        map.put(beginWord, count++);
        for (String word : wordList) {
            if (map.containsKey(word)) continue;
            map.put(word, count++);
        }
        return map;
    }

    private int[] getArc(String start, Map<String, Integer> map) {
        int[] arc = new int[map.size()];
        int count = 0;
        char[] word = start.toCharArray();
        for (int i = 0; i < start.length(); i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (ch == start.charAt(i)) continue;
                word[i] = ch;
                String key = String.valueOf(word);
                if (map.containsKey(key)) {
                    arc[count++] = map.get(key);
                }
            }
            word[i] = start.charAt(i);
        }
        return Arrays.copyOf(arc, count);
    }

    // 邻接表
    private int dijstra(int[][] graph, int s, int t) {
        int[] dist = new int[graph.length];
        boolean[] vis = new boolean[graph.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for (int v : graph[s]) dist[v] = 1;
        dist[s] = 0;
        vis[s] = true;
        for (int i = 1; i < graph.length; i++) {
            int min = Integer.MAX_VALUE;
            int v = 0;
            for (int j = 0; j < graph.length; j++) {
                if (!vis[j] && dist[j] < min) {
                    v = j;
                    min = dist[j];
                }
            }
            if (v == t) break;
            vis[v] = true;
            for (int j : graph[v]) {
                if (!vis[j] && (dist[v] < dist[j] - 1)) {
                    dist[j] = dist[v] + 1;
                }
            }
        }
        return dist[t];
    }

}
