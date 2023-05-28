package spellingcorrection;

import java.util.List;
import java.util.Scanner;

public class SpellingCorrection {

    public static void main(String[] args) {
        SpellingCorrectionSystem system = new SpellingCorrectionSystem();
        String[] dictionary = {"cat", "dog", "fish", "bird", "apple", "banana"};
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
