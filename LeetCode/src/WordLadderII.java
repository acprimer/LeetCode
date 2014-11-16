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
    class Node{
        int pre;
        String label;
        int cost;
        public Node(String label, int cost, int pre) {
            this.label = label;
            this.cost = cost;
            this.pre = pre;
        }
    }

    private String[] arc;
    private int arcCnt = 0;
    private List<List<String>> ans = new ArrayList<List<String>>();
    private Set<String> hash1 = new HashSet<String>();
    private Set<String> hash2 = new HashSet<String>();
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        arc = new String[dict.size()];
        generateHash(end, dict);
        dict.add(end);
        Set<String> vis = new HashSet<String>();
        List<Node> queueBackup = new ArrayList<Node>();
        int queuePointer = 0;
        queueBackup.add(new Node(start, 1, -1));
        int minLen = Integer.MAX_VALUE;
        while(queuePointer < queueBackup.size()) {
            Node node = queueBackup.get(queuePointer++);
            int pre = queuePointer - 1;
            String label = node.label;
            int cost = node.cost;
            if(cost > minLen) break;
            vis.add(label);
            if(label.equals(end)) {
                minLen = cost;
                constructWordLadder(pre, queueBackup);
            }
            if(cost == minLen) continue;
            if(cost == minLen-1 && !hash1.contains(label)) continue;
            if(cost == minLen-2 && !hash2.contains(label)) continue;
            getArc(label, dict);
            for(int j=0;j<arcCnt;j++) {
                if(!arc[j].equals(end) && vis.contains(arc[j])) continue;
                queueBackup.add(new Node(arc[j], cost+1, pre));
            }
        }
        return ans;
    }

    private void generateHash(String end, Set<String> dict) {
        getArc(end, dict);
        String[] tmp = new String[arcCnt];
        for(int j=0;j<tmp.length;j++) {
            tmp[j] = arc[j];
        }
        for(int j=0;j<tmp.length;j++) {
            hash1.add(tmp[j]);
            getArc(tmp[j], dict);
            for(int k=0;k<arcCnt;k++) {
                hash2.add(arc[k]);
            }
        }
    }

    private void constructWordLadder(int pre, List<Node> queue) {
        List<String> list = new LinkedList<String>();
        while(pre != -1) {
            Node node = queue.get(pre);
            list.add(0, node.label);
            pre = node.pre;
        }
        ans.add(list);
    }

    private void getArc(String start, Set<String> set) {
        arcCnt = 0;
        char[] word = new char[start.length()];
        start.getChars(0, start.length(), word, 0);
        for(int i=0;i<start.length();i++) {
            for(char ch = 'a'; ch <= 'z'; ch++) {
                if(ch == start.charAt(i)) continue;
                word[i] = ch;
                String str = new String(word);
                if(set.contains(str)) {
                    arc[arcCnt++] = str;
                }
            }
            word[i] = start.charAt(i);
        }
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

//public class WordLadderII {
//    static class Node{
//        Node parent;
//        String str;
//        Node(Node _parent, String _str){
//            parent = _parent;
//            str = _str;
//        }
//
//        List<String> generatePath(String end){
//            List<String> result = new ArrayList<String>();
//            for(Node n= this;n != null; n = n.parent)
//                result.add(0, n.str);
//            result.add(end);
//            return result;
//        }
//    }
//
//    public static List<List<String>> findLadders(String start, String end, Set<String> dict) {
//        dict.remove(start);
//        dict.remove(end);
//        Queue<Node> queue = new LinkedList<Node>();
//        queue.add(new Node(null, start));
//        queue.add(null);  //Level indicator
//        List<List<String>> result = new ArrayList<List<String>>();
//        Set<String> pendingVisited = new HashSet<String>();  //Very important to use set instead of list as it could have repeated items.
//        String[] dictArray = dict.toArray(new String[0]);  //ArrayList has much worse performance than raw Array.
//        Map<String, List<String>> neihborMap = new HashMap<String, List<String>>();
//        while(!queue.isEmpty()){
//            Node n = queue.poll();
//            if(n == null){
//                if(queue.isEmpty())
//                    break;
//
//                dict.removeAll(pendingVisited);
//                pendingVisited.clear();
//                dictArray = dict.toArray(new String[0]);
//                queue.add(n);
//                if(result.size() > 0)
//                    break;
//                continue;
//            }
//
//            if(isOneLetterChange(n.str, end)){
//                result.add(n.generatePath(end));
//            }else{
//                List<String> nbs = neihborMap.get(n.str);
//                if(nbs == null){
//                    nbs = findNeihbors(n.str, dictArray);
//                    neihborMap.put(n.str, nbs);
//                }
//
//                for(String s : nbs){
//                    queue.add(new Node(n, s));
//                    pendingVisited.add(s);
//                }
//            }
//        }
//        return result;
//    }
//
//    private static List<String> findNeihbors(String start, String[] dict){
//        List<String> neihbors = new ArrayList<String>();
//        for(String s : dict){
//            if(isOneLetterChange(start, s))
//                neihbors.add(s);
//        }
//        return neihbors;
//    }
//
//    private static boolean isOneLetterChange(String s1, String s2){
//        boolean hasDiff = false;
//        for(int i=0; i<s1.length(); i++){
//            if(s1.charAt(i) != s2.charAt(i)){
//                if(hasDiff)
//                    return false;
//                hasDiff = true;
//            }
//        }
//        return true;
//    }
//}