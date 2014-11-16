import java.util.*;

/**
 * Created by yaodh on 2014/11/14.
 *
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
 *
 * Tag: BFS Hash Dijstra
 */

public class WordLadder {
    class Node implements Comparable<Node>{
        String label;
        int cost;
        public Node(String label, int cost) {
            this.label = label;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost > o.cost ? 1 : -1;
        }
    }

    public int ladderLength(String start, String end, Set<String> dict) {
        dict.add(end);
        Queue<Node> queue = new PriorityQueue<Node>();
        queue.offer(new Node(start, 1));
        Set<String> vis = new HashSet<String>();
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            String label = node.label;
            int cost = node.cost;
            if(vis.contains(label)) continue;
            vis.add(label);
            if(label.equals(end)) return cost;
            List<String> nextNodes = getArc(label, dict);
            for(String next : nextNodes) {
                if(vis.contains(next)) continue;
                queue.offer(new Node(next, cost+1));
            }
        }
        return 0;
    }

    private List<String> getArc(String start, Set<String> set) {
        List<String> arc = new ArrayList<String>();
        char[] word = new char[start.length()];
        start.getChars(0, start.length(), word, 0);
        for(int i=0;i<start.length();i++) {
            for(char ch = 'a'; ch <= 'z'; ch++) {
                if(ch == start.charAt(i)) continue;
                word[i] = ch;
                String str = new String(word);
                if(set.contains(str)) {
                    arc.add(str);
                }
            }
            word[i] = start.charAt(i);
        }
        return arc;
    }

    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();
        set.add("hot");
        set.add("dot");
        set.add("dog");
        set.add("lot");
        set.add("log");
        int ans = new WordLadder().ladderLength("hit", "cog", set);
        System.out.println(ans);
    }

}
