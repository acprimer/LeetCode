/**
 * Created by yaodh on 2015/7/30.
 */
public class AddAndSearchWord {
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
                if (node.child[ch - 'a'] == null) {
                    node.child[ch - 'a'] = new TrieNode(ch);
                }
                node = node.child[ch - 'a'];
            }
            node.isEndOfWord = true;
        }
    }

    class WordDictionary {
        private Trie trie = new Trie();
        // Adds a word into the data structure.
        public void addWord(String word) {
            trie.insert(word);
        }

        // Returns if the word is in the data structure. A word could
        // contain the dot character '.' to represent any one letter.
        public boolean search(String word) {
            return search(word, trie.root);
        }

        public boolean search(String word, TrieNode root) {
            if(word.length() == 0) {
                return root.isEndOfWord;
            }
            char first = word.charAt(0);
            if(first == '.') {
                for (int i = 0; i < 26; i++) {
                    if(root.child[i] != null && search(word.substring(1), root.child[i])) {
                        return true;
                    }
                }
                return false;
            }
            if(root.child[first - 'a'] != null) {
                return search(word.substring(1), root.child[first - 'a']);
            }
            return false;
        }
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new AddAndSearchWord().new WordDictionary();
        wordDictionary.addWord("a");
        System.out.println(wordDictionary.search("."));
    }
}
