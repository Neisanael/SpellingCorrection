package spellingcorrection;

public class TrieNode {
    TrieNode[] Trie;
    boolean isEnd;

    public TrieNode() {
        Trie = new TrieNode[256];
        for (int i = 0; i < 256; i++) {
            Trie[i] = null;
        }
        isEnd = false;
    }
}
