/**
 * Created by yaodh on 15/7/30.
 */
public class ImplementTrie {
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

        // Returns if the word is in the trie.
        public boolean search(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if(node.child[ch - 'a'] == null) {
                    return false;
                }
                node = node.child[ch - 'a'];
            }
            return node.isEndOfWord;
        }

        // Returns if there is any word in the trie
        // that starts with the given prefix.
        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for (int i = 0; i < prefix.length(); i++) {
                char ch = prefix.charAt(i);
                if(node.child[ch - 'a'] == null) {
                    return false;
                }
                node = node.child[ch - 'a'];
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Trie trie = new ImplementTrie().new Trie();
        trie.insert("word");
        System.out.println(trie.search("wo"));
        System.out.println(trie.startsWith("wo"));
    }
}
