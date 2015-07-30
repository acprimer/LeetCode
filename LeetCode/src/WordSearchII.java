import java.util.*;

/**
 * Created by yaodh on 2015/7/30.
 */
public class WordSearchII {
    class TrieNode {
        private char ch;
        public TrieNode[] child;
        public boolean isEndOfWord;
        public TrieNode(char ch) {
            this.ch = ch;
            child = new TrieNode[26];
        }
    }
    class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode('$');
        }

        // Inserts a word into the trie.
        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if(node.child[ch - 'a'] == null) {
                    node.child[ch - 'a'] = new TrieNode(ch);
                }
                node = node.child[ch - 'a'];
            }
            node.isEndOfWord = true;
        }
    }

    boolean[][] vis;
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<String>();
        Set<String> set = new HashSet<String>();
        if(board == null || board.length == 0 || board[0].length == 0) {
            return ans;
        }
        Trie trie = new Trie();
        for (int i = 0; i < words.length; i++) {
            if(words[i].length() > board.length * board[0].length) {
                continue;
            }
            trie.insert(words[i]);
        }
        boolean findAll = false;
        vis = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length && !findAll; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(i, j, board, trie.root, "", set);
                if(set.size() == words.length) {
                    findAll = true;
                    break;
                }
            }
        }
        for (String word : set) {
            ans.add(word);
        }
        return ans;
    }

    private void dfs(int x, int y, char[][] board, TrieNode root, String word, Set<String> set) {
        if(x < 0 || x >= board.length || y < 0 || y >= board[0].length || vis[x][y]) {
            return;
        }
        char ch = board[x][y];
        if(root.child[ch - 'a'] == null) {
            return ;
        }
        vis[x][y] = true;
        dfs(x + 1, y, board, root.child[ch - 'a'], word + ch, set);
        dfs(x, y + 1, board, root.child[ch - 'a'], word + ch, set);
        dfs(x - 1, y, board, root.child[ch - 'a'], word + ch, set);
        dfs(x, y - 1, board, root.child[ch - 'a'], word + ch, set);
        vis[x][y] = false;
        if(root.child[ch - 'a'].isEndOfWord) {
            set.add(word + ch);
        }
    }

    private boolean inTheBoard(int x, int y, int row, int col) {
        return x >= 0 && x <row && y >= 0 && y < col;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"a"};
        char[][] boards = new char[words.length][words[0].length()];
        for (int i = 0; i < words.length; i++) {
            boards[i] = words[i].toCharArray();
        }
        List<String> ans = new WordSearchII().findWords(boards, new String[]{"a", "a"});
        for(String word : ans) {
            System.out.println(word);
        }
    }
}
