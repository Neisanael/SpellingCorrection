package spellingcorrection;

import java.util.ArrayList;
import java.util.List;

public class SpellingCorrectionSystem {

    private Trie trie;

    public SpellingCorrectionSystem() {
        trie = new Trie();
    }

    public void buildDictionary(String[] words) {
        for (String word : words) {
            trie.insert(word);
        }
    }

    public boolean isWordCorrect(String word) {
        return trie.search(word);
    }

    public List<String> getSuggestions(String word) {
        List<String> suggestions = new ArrayList<>();
        searchSuggestions(trie.getRoot(), word, new StringBuilder(), suggestions);
        return suggestions;
    }

    private void searchSuggestions(TrieNode node, String target, StringBuilder current, List<String> suggestions) {
    if (suggestions.size() >= 5) {
        return;
    }

    if (node == null) {
        return;
    }

    if (current.length() >= target.length()) {
        if (node.isEndOfWord() && calculateLevenshteinDistance(current.toString(), target) == 1) {
            suggestions.add(current.toString());
        }
        return;
    }

    for (int i = 0; i < 26; i++) {
        char c = (char) ('a' + i);
        current.append(c);
        searchSuggestions(node.getChildren()[i], target, current, suggestions);
        current.deleteCharAt(current.length() - 1);
    }
}


    public int calculateLevenshteinDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }

        return dp[m][n];
    }
}
