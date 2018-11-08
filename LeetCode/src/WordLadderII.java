import java.util.*;

/**
 * Created by yaodh on 2014/11/14.
 * <p/>
 * LeetCode: Word Ladder II
 * Link: https://oj.leetcode.com/problems/word-ladder-ii/
 * Description:
 * -----------------------------
 * Given two words (start and end), and a dictionary,
 * find all shortest transformation sequence(s) from start to end, such that:
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * For example,
 * Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * Return
 * [
 * ["hit","hot","dot","dog","cog"],
 * ["hit","hot","lot","log","cog"]
 * ]
 * Note:
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * -----------------------------
 * <p/>
 * Tag: BFS
 */

public class WordLadderII {
//    class Node {
//        int pre;
//        String label;
//        int cost;
//
//        public Node(String label, int cost, int pre) {
//            this.label = label;
//            this.cost = cost;
//            this.pre = pre;
//        }
//    }
//
//    private String[] arc;
//    private int arcCnt = 0;
//    private List<List<String>> ans = new ArrayList<List<String>>();
//    private Set<String> hash1 = new HashSet<String>();
//    private Set<String> hash2 = new HashSet<String>();
//
//    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
//        arc = new String[dict.size()];
//        generateHash(end, dict);
//        dict.add(end);
//        Set<String> vis = new HashSet<String>();
//        List<Node> queueBackup = new ArrayList<Node>();
//        int queuePointer = 0;
//        queueBackup.add(new Node(start, 1, -1));
//        int minLen = Integer.MAX_VALUE;
//        while (queuePointer < queueBackup.size()) {
//            Node node = queueBackup.get(queuePointer++);
//            int pre = queuePointer - 1;
//            String label = node.label;
//            int cost = node.cost;
//            if (cost > minLen) break;
//            vis.add(label);
//            if (label.equals(end)) {
//                minLen = cost;
//                constructWordLadder(pre, queueBackup);
//            }
//            if (cost == minLen) continue;
//            if (cost == minLen - 1 && !hash1.contains(label)) continue;
//            if (cost == minLen - 2 && !hash2.contains(label)) continue;
//            getArc(label, dict);
//            for (int j = 0; j < arcCnt; j++) {
//                if (!arc[j].equals(end) && vis.contains(arc[j])) continue;
//                queueBackup.add(new Node(arc[j], cost + 1, pre));
//            }
//        }
//        return ans;
//    }
//
//    private void generateHash(String end, Set<String> dict) {
//        getArc(end, dict);
//        String[] tmp = new String[arcCnt];
//        for (int j = 0; j < tmp.length; j++) {
//            tmp[j] = arc[j];
//        }
//        for (int j = 0; j < tmp.length; j++) {
//            hash1.add(tmp[j]);
//            getArc(tmp[j], dict);
//            for (int k = 0; k < arcCnt; k++) {
//                hash2.add(arc[k]);
//            }
//        }
//    }
//
//    private void constructWordLadder(int pre, List<Node> queue) {
//        List<String> list = new LinkedList<String>();
//        while (pre != -1) {
//            Node node = queue.get(pre);
//            list.add(0, node.label);
//            pre = node.pre;
//        }
//        ans.add(list);
//    }
//
//    private void getArc(String start, Set<String> set) {
//        arcCnt = 0;
//        char[] word = new char[start.length()];
//        start.getChars(0, start.length(), word, 0);
//        for (int i = 0; i < start.length(); i++) {
//            for (char ch = 'a'; ch <= 'z'; ch++) {
//                if (ch == start.charAt(i)) continue;
//                word[i] = ch;
//                String str = new String(word);
//                if (set.contains(str)) {
//                    arc[arcCnt++] = str;
//                }
//            }
//            word[i] = start.charAt(i);
//        }
//    }

    public static void main(String[] args) {
        List<List<String>> ans = new WordLadderII().findLadders("a", "c",
                Arrays.asList("a", "b", "c", "d", "e"));
        for (List<String> list : ans) {
            for (String str : list) {
                System.out.print(str + "-->");
            }
            System.out.println();
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Map<String, Integer> map = getMap(beginWord, wordList);
        if (!map.containsKey(endWord)) return new ArrayList<>();
        int start = map.get(beginWord);
        int end = map.get(endWord);
        int[][] arc = new int[map.size()][];
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            arc[entry.getValue()] = getArc(entry.getKey(), map);
        }
        int[][] path = new int[arc.length][];
        int min = dijstra(arc, path, start, end);
        if (min > wordList.size()) return new ArrayList<>();

        List<List<String>> ans = new ArrayList<>();
        List<String> last = new ArrayList<>();
        last.add(endWord);
        ans.add(last);
        int u = end;
        while (u != start) {
            List<List<String>> list = new ArrayList<>();
            for (int i = 0; i < ans.size(); i++) {
                int v = map.get(ans.get(i).get(0));
                u = path[v][1];
                ans.get(i).add(0, u >= wordList.size() ? beginWord : wordList.get(u));
                for (int j = 1; j < path[v][0]; j++) {
                    List<String> temp = new ArrayList<>(ans.get(i));
                    u = path[v][j + 1];
                    temp.set(0, u >= wordList.size() ? beginWord : wordList.get(u));
                    list.add(temp);
                }
            }
            if (list.size() > 0) ans.addAll(list);
        }

        return ans;
    }

    private Map<String, Integer> getMap(String beginWord, List<String> wordList) {
        int count = 0;
        Map<String, Integer> map = new HashMap<>(wordList.size() + 1);
        for (String word : wordList) {
            map.put(word, count++);
        }
        if (!map.containsKey(beginWord)) {
            map.put(beginWord, count);
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
    private int dijstra(int[][] graph, int[][] path, int s, int t) {
        int[] dist = new int[graph.length];
        for (int i = 0; i < path.length; i++) {
            path[i] = new int[graph.length];
        }
        boolean[] vis = new boolean[graph.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for (int v : graph[s]) dist[v] = 1;
        for (int v : graph[s]) path[v][++path[v][0]] = s;
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
                if (vis[j]) continue;
                if (dist[v] < dist[j] - 1) {
                    dist[j] = dist[v] + 1;
                    path[j][path[j][0] = 1] = v;
                } else if (dist[v] == dist[j] - 1) {
                    path[j][++path[j][0]] = v;
                }
            }
        }

        return dist[t];
    }
}