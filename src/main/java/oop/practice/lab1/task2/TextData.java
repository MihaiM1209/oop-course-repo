package oop.practice.lab1.task2;

public class TextData {
    private String fileName;
    private String content;
    private int vowelCount;
    private int consonantCount;
    private int letterCount;
    private int sentenceCount;
    private String longestWord;

    public TextData(String fileName, String content) {
        this.fileName = fileName;
        this.content = content;  // Assign content
        analyzeText();
    }

    private void analyzeText() {
        vowelCount = countVowels(content);
        consonantCount = countConsonants(content);
        letterCount = countLetters(content);
        sentenceCount = countSentences(content);
        longestWord = findLongestWord(content);
    }

    private int countVowels(String text) {
        int count = 0;
        String lowerText = text.toLowerCase();
        for (char character : lowerText.toCharArray()) {
            if ("aeiou".indexOf(character) != -1) {
                count++;
            }
        }
        return count;
    }

    private int countConsonants(String text) {
        int count = 0;
        String lowerText = text.toLowerCase();
        for (char character : lowerText.toCharArray()) {
            if (Character.isLetter(character) && "aeiou".indexOf(character) == -1) {
                count++;
            }
        }
        return count;
    }

    private int countLetters(String text) {
        int count = 0;
        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                count++;
            }
        }
        return count;
    }

    private int countSentences(String text) {
        String[] sentences = text.split("[.!?]");
        return sentences.length;
    }

    private String findLongestWord(String text) {
        String[] words = text.split("\\W+");
        String longest = "";
        for (String word : words) {
            if (word.length() > longest.length()) {
                longest = word;
            }
        }
        return longest;
    }

    public void printInfo() {
        System.out.println("----- Text Data Analysis -----");
        System.out.printf("File Name       : %s%n", fileName);
        System.out.printf("Total Letters   : %d%n", letterCount);
        System.out.printf("Vowels          : %d%n", vowelCount);
        System.out.printf("Consonants      : %d%n", consonantCount);
        System.out.printf("Sentences       : %d%n", sentenceCount);
        System.out.printf("Longest Word    : %s%n", longestWord);
        System.out.println("------------------------------");
    }
}
