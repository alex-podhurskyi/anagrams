package ua.com.foxminded.anagrams;

public class Main {

    public static void main(String[] args) {
        if (args.length != 0) {
            Anagram anagramSentence = new Anagram();
            for (int i = 0; i < args.length; i++) {
                System.out.println(anagramSentence.makeAnagram(args[i]));
            }
        } else {
            throw new IllegalArgumentException("command line arguments is empty!");
        }
    }
}
