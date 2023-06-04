package spellingcorrection;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] words = {"cat", "dog", "fish", "bird", "apple", "banana", "tiger", "lion", "elephant", "giraffe",
                "zebra", "monkey", "bear", "panda", "koala", "kangaroo", "crocodile", "hippopotamus",
                "rhinoceros", "gorilla", "snake", "turtle", "frog", "lizard", "shark", "whale", "dolphin",
                "seal", "penguin", "ostrich", "parrot", "eagle", "hawk", "owl", "sparrow", "butterfly",
                "bee", "ant", "grasshopper", "spider", "crab", "lobster", "octopus",
                "snail", "worm", "scorpion", "camel", "horse", "cow", "sheep", "goat", "pig", "chicken",
                "duck", "turkey", "rooster", "deer", "rabbit", "mouse", "squirrel", "kitten", "puppy",
                "dove", "peacock", "dinosaur", "crocodile", "chameleon", "whale", "dolphin", "shrimp",
                "lobster", "crab", "clam", "oyster", "bat", "fox", "wolf", "leopard", "cheetah", "panther",
                "hyena", "bee", "ant", "mosquito", "fly", "ladybug", "beetle", "dragonfly", "caterpillar",
                "snail", "slug"};

        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        String key = "geek";
        if (trie.search(key)) {
            System.out.println("Found: " + key);
        } else {
            List<String> suggestions = trie.getSuggestions(key);
            if (suggestions.isEmpty()) {
                System.out.println("No suggestions found.");
            } else {
                System.out.println("Suggestions:");
                for (String suggestion : suggestions) {
                    System.out.println(suggestion);
                }
            }
        }
    }
}
