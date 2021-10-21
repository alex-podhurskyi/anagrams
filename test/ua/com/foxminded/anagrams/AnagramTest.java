package ua.com.foxminded.anagrams;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class AnagramTest {

    Anagram anagramSentence = new Anagram();
    
    @Test
    public void makeAnagram_ExceptionThrown_emptyString() {
        assertThrows(IllegalArgumentException.class, () -> anagramSentence.makeAnagram(""));
    }
    
    @Test
    public void makeAnagram_ExceptionThrown_onlyWhiteSpaces() {
        assertThrows(IllegalArgumentException.class, () -> anagramSentence.makeAnagram("    "));
    }
    
    @Test
    public void makeAnagram_reversString_OnlyLetters() {
        String input = "Hello world";
        String expectedResult = "olleH dlrow";
        String actualResult = anagramSentence.makeAnagram(input);
        
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void makeAnagram_reversString_OnlyDigits() {
        String input = "356784 69423";
        String expectedResult = "356784 69423";
        String actualResult = anagramSentence.makeAnagram(input);
        
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void makeAnagram_reversString_OnlySymbols() {
        String input = "$$|%#`     ||@";
        String expectedResult = "$$|%#`     ||@";
        String actualResult = anagramSentence.makeAnagram(input);
        
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void makeAnagram_reversString_LettersAndDigits() {
        String input = "he1l0   th3r3";
        String expectedResult = "le1h0   rh3t3";
        String actualResult = anagramSentence.makeAnagram(input);
        
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void makeAnagram_reversString_LettersAndSymbols() {
        String input = "ex@mp|e       t3}{t";
        String expectedResult = "ep@mx|e       t3}{t";
        String actualResult = anagramSentence.makeAnagram(input);
        
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void makeAnagram_reversString_DigitsAndSymbols() {
        String input = "!253# 6546@#$((45)2";
        String expectedResult = "!253# 6546@#$((45)2";
        String actualResult = anagramSentence.makeAnagram(input);
        
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void makeAnagram_reversString_LettersDigitsSymbols() {
        String input = "    3x@mp|e   t3}{T      $#0^m&e  $y[m6]o|\\\\";
        String expectedResult = "    3e@pm|x   T3}{t      $#0^e&m  $o[m6]y|\\\\";
        String actualResult = anagramSentence.makeAnagram(input);
        
        assertEquals(expectedResult, actualResult);
    }
}
