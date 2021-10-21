package ua.com.foxminded.anagrams;

public class Anagram {

    private final String DELIMITER = "\\s+";

    public String makeAnagram(String inputSentence) {
        verify(inputSentence);
        String[] inputWords = inputSentence.split(DELIMITER);
        char[] outputSentence = inputSentence.toCharArray();        
        for (int i = 0; i < inputWords.length; i++) {
            int idxCurentLetter = inputSentence.indexOf(inputWords[i]);
            for (int j = 0; j < inputWords[i].length(); j++) {
                outputSentence[idxCurentLetter] = reversedWord(inputWords[i]).charAt(j);
                idxCurentLetter++;
            }
        }
        return String.valueOf(outputSentence);
    }

    private static void verify(String inputSentence) {
        if (inputSentence.isEmpty()) {
            throw new IllegalArgumentException("Sentence is empty");
        }
        if (inputSentence.trim().isEmpty()) {
            throw new IllegalArgumentException("Sentence contain only whitespaces");
        }
    }

    private String reversedWord(String inputWords) {
        char[] word = new char[inputWords.length()];
        int idxLeft = 0;
        int idxRight = word.length - 1;        
        while (idxLeft <= idxRight) {
            if (!Character.isLetter(inputWords.charAt(idxLeft))) {
                word[idxLeft] = inputWords.charAt(idxLeft);
                idxLeft++;
            } else if (!Character.isLetter(inputWords.charAt(idxRight))) {
                word[idxRight] = inputWords.charAt(idxRight);
                idxRight--;
            } else if ((Character.isLetter(inputWords.charAt(idxLeft))) 
                    && (Character.isLetter(inputWords.charAt(idxRight)))) {
                word[idxLeft] = inputWords.charAt(idxRight);
                word[idxRight] = inputWords.charAt(idxLeft);
                idxLeft++;
                idxRight--;
            }
        }
        return String.valueOf(word);
    }
}
