package ua.com.foxminded.anagrams;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.io.PrintStream;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

public class MainTest {

    @Test
    void testMainWithMakeAnagramStubbing() {
        Anagram sentence = mock(Anagram.class);
        Main.setSentence(sentence);
        doReturn("asdf asdf").when(sentence).makeAnagram(anyString());
        PrintStream stream = mock(PrintStream.class);
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        System.setOut(stream);
        Main.main(new String[]{"asdf2 asdf"});
        verify(stream).println(captor.capture());
        assertEquals("asdf asdf", captor.getValue());
    }

    @Test
    void testWhatMakeAnagramAccept() {
        Anagram anagram = mock(Anagram.class);
        Main.setSentence(anagram);
        Main.main(new String[]{"asdf2 asdf"});
        verify(anagram).makeAnagram("asdf2 asdf");
    }

    @Test
    void testMainWithAnagramTwoWords() {
        Anagram anagram = new Anagram();
        Main.setSentence(anagram);
        PrintStream stream = mock(PrintStream.class);
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        System.setOut(stream);
        Main.main(new String[]{"hello world"});
        verify(stream).println(captor.capture());
        assertEquals("olleh dlrow", captor.getValue());
    }

    @Test
    void testMainWithAnagramTwoWordsWithSymbol() {
        Anagram anagram = new Anagram();
        Main.setSentence(anagram);
        PrintStream stream = mock(PrintStream.class);
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        System.setOut(stream);
        Main.main(new String[]{"d1cba hgf!e"});
        verify(stream).println(captor.capture());
        assertEquals("a1bcd efg!h", captor.getValue());
    }
}
