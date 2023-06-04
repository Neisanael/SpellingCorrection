package spellingcorrection;

import java.util.ArrayList;
import java.util.List;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String s) {
        TrieNode temp = root;
        for (int i = 0; i < s.length(); i++) {
            if (temp.Trie[s.charAt(i)] == null) {
                temp.Trie[s.charAt(i)] = new TrieNode();
            }
            temp = temp.Trie[s.charAt(i)];
        }
        temp.isEnd = true;
    }

    public boolean search(String key) {
        TrieNode temp = root;
        for (int i = 0; i < key.length(); i++) {
            if (temp.Trie[key.charAt(i)] == null) {
                return false;
            }
            temp = temp.Trie[key.charAt(i)];
        }
        return temp.isEnd;
    }

    public List<String> getSuggestions(String key) {
        TrieNode temp = root;
        List<String> suggestions = new ArrayList<>();
        StringBuilder currentPrefix = new StringBuilder();

        for (int i = 0; i < key.length(); i++) {
            if (temp.Trie[key.charAt(i)] == null) {
                break;
            }
            temp = temp.Trie[key.charAt(i)];
            currentPrefix.append(key.charAt(i));
        }

        getSuggestionsUtil(temp, currentPrefix, suggestions);
        return suggestions;
    }

    private void getSuggestionsUtil(TrieNode node, StringBuilder currentPrefix, List<String> suggestions) {
        if (node.isEnd) {
            suggestions.add(currentPrefix.toString());
        }

        for (int i = 0; i < 256; i++) {
            if (node.Trie[i] != null) {
                currentPrefix.append((char) i);
                getSuggestionsUtil(node.Trie[i], currentPrefix, suggestions);
                currentPrefix.deleteCharAt(currentPrefix.length() - 1);
            }
        }
    }
}
