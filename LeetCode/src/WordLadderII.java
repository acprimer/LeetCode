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
 * Tag: BFS
 */

public class WordLadderII {
    class Node implements Comparable<Node>{
        List<String> wordList;
        String label;
        int cost;
        public Node(String label, int cost, List<String> list) {
            this.label = label;
            this.cost = cost;
            this.wordList = new ArrayList<String>(list);
            wordList.add(label);
        }

        @Override
        public int compareTo(Node o) {
            return this.cost > o.cost ? 1 : -1;
        }
    }

    final static char[] ALPHA = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> ans = new ArrayList<List<String>>();
        dict.add(end);
        Queue<Node> queue = new PriorityQueue<Node>();
        queue.offer(new Node(start, 1, new ArrayList<String>()));
        Set<String> vis = new HashSet<String>();
        int minLen = Integer.MAX_VALUE;
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            String label = node.label;
            int cost = node.cost;
            if(cost > minLen) break;
            List<String> wordList = node.wordList;
//            if(vis.contains(label)) continue;
            vis.add(label);
            if(label.equals(end)) {
                minLen = cost;
                ans.add(wordList);
            }
            List<String> nextNodes = getArc(label, dict);
            for(String next : nextNodes) {
//                if(vis.contains(next)) continue;
                queue.offer(new Node(next, cost+1, wordList));
            }
        }
        return ans;
    }

    private List<String> getArc(String start, Set<String> set) {
        List<String> arc = new ArrayList<String>();
        char[] word = new char[start.length()];
        start.getChars(0, start.length(), word, 0);
        for(int i=0;i<start.length();i++) {
            for(int j=0;j<26;j++) {
                if(ALPHA[j] == start.charAt(i)) continue;
                word[i] = ALPHA[j];
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
        List<List<String>> ans = new WordLadderII().findLadders("hit", "cog", set);
        for(List<String> list : ans) {
            for(String str : list) {
                System.out.print(str + "-->");
            }
            System.out.println();
        }
    }
}
