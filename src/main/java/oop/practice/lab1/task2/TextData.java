package oop.practice.lab1.task2;

public class TextData {
    private String fileName;
    private String content;
    private int vowelCount;
    private int consonantCount;
    private int letterCount;
    private int sentenceCount;
    private String longestWord;

    // Constructor to initialize file name and content, and analyze the text
    public TextData(String fileName, String content) {
        this.fileName = fileName;
        this.content = content;
        analyzeText();
    }

    // Analyze the text and gather statistics
    private void analyzeText() {
        vowelCount = countVowels(content);
        consonantCount = countConsonants(content);
        letterCount = countLetters(content);
        sentenceCount = countSentences(content);
        longestWord = findLongestWord(content);
    }

    // Count the number of vowels in the content
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

    // Count the number of consonants in the content
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

    // Count the total letters in the content
    private int countLetters(String text) {
        int count = 0;
        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                count++;
            }
        }
        return count;
    }

    // Count the number of sentences in the content
    private int countSentences(String text) {
        String[] sentences = text.split("[.!?]");
        return sentences.length;
    }

    // Find the longest word in the content
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

    // Getter methods for accessing private fields
    public String getFileName() {
        return fileName;
    }

    public String getContent() {
        return content;
    }

    public int getNumberOfVowels() {
        return vowelCount;
    }

    public int getNumberOfConsonants() {
        return consonantCount;
    }

    public int getNumberOfLetters() {
        return letterCount;
    }

    public int getNumberOfSentences() {
        return sentenceCount;
    }

    public String getLongestWord() {
        return longestWord;
    }

    // Print analysis results in a structured format
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
