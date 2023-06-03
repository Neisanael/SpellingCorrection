package spellingcorrection;

import java.util.List;
import java.util.Scanner;

public class SpellingCorrection {

    public static void main(String[] args) {
        SpellingCorrectionSystem system = new SpellingCorrectionSystem();
        String[] dictionary = {
            "cat", "dog", "fish", "bird", "apple", "banana", "tiger", "lion", "elephant", "giraffe", 
            "zebra", "monkey", "bear", "panda", "koala", "kangaroo", "crocodile", "hippopotamus", 
            "rhinoceros", "gorilla", "snake", "turtle", "frog", "lizard", "shark", "whale", "dolphin", 
            "seal", "penguin", "ostrich", "parrot", "eagle", "hawk", "owl", "sparrow", "butterfly", 
            "bee", "ant", "grasshopper", "spider", "crab", "lobster", "octopus", "starfish", "jellyfish", 
            "snail", "worm", "scorpion", "camel", "horse", "cow", "sheep", "goat", "pig", "chicken", 
            "duck", "turkey", "rooster", "deer", "rabbit", "mouse", "squirrel", "kitten", "puppy", 
            "dove", "peacock", "dinosaur", "crocodile", "chameleon", "whale", "dolphin", "shrimp", 
            "lobster", "crab", "clam", "oyster", "bat", "fox", "wolf", "leopard", "cheetah", "panther", 
            "hyena", "bee", "ant", "mosquito", "fly", "ladybug", "beetle", "dragonfly", "caterpillar", 
            "snail", "slug", "starfish", "jellyfish", "coral", "shark", "ray", "eel", "clownfish", 
            "goldfish", "koi", "tropical fish"
        };
        system.buildDictionary(dictionary);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String wordToCheck = scanner.nextLine().toLowerCase();

        if (system.isWordCorrect(wordToCheck)) {
            System.out.println(wordToCheck + " is spelled correctly.");
        } else {
            System.out.println(wordToCheck + " is misspelled. Word suggestions:");
            List<String> suggestions = system.getSuggestions(wordToCheck);
            if (suggestions.isEmpty()) {
                System.out.println("No suggestions found.");
            } else {
                for (String suggestion : suggestions) {
                    int distance = system.calculateLevenshteinDistance(wordToCheck, suggestion);
                    System.out.println(suggestion + " (Distance: " + distance + ")");
                }
            }
        }
        scanner.close();
    }

}
