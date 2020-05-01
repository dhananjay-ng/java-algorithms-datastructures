package problems.ontrie;

import java.util.HashMap;
import java.util.Map;

public class TrieImpl {
    class TrieNode {
        Map<Character, TrieNode> nodes;
        boolean isEnd;

        public TrieNode() {
            nodes = new HashMap<>();
            isEnd = false;
        }
    }

    TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public TrieImpl() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if (!current.nodes.containsKey(c)) {
                current.nodes.put(c, new TrieNode());
            }
            current = current.nodes.get(c);
        }
        current.isEnd = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if (!current.nodes.containsKey(c)) {
                return false;
            }
            current = current.nodes.get(c);
        }
        return current.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (int i = 0; i < prefix.length(); i++) {
            Character c = prefix.charAt(i);
            if (!current.nodes.containsKey(c)) {
                return false;
            }
            current = current.nodes.get(c);
        }
        return current != null;
    }
}
