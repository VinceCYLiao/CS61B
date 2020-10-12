import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    static OffByOne offByOne = new OffByOne();
    static OffByN offBy5 = new OffByN(5);

    @Test
    public void testWordToDeque() {
        Deque<Character> d = (Deque<Character>) palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        String str = "racecar";
        boolean result = palindrome.isPalindrome(str);
        assertTrue(result);
        String str2 = "repaper";
        boolean result2 = palindrome.isPalindrome(str2);
        assertTrue(result2);
        System.out.println("test is palindrome is passed");
    }

    @Test
    public void testIsPalindromeOverload() {
        String str = "flake";
        boolean result = palindrome.isPalindrome(str, offByOne);
        assertTrue(result);
        String str2 = "repaper";
        boolean result2 = palindrome.isPalindrome(str2, offByOne);
        assertFalse(result2);
        System.out.println("testIsPalindromeOverload is passed");
    }

    @Test
    public void testOffByN () {
        assertTrue(offBy5.equalChars('a', 'f'));
        assertTrue(offBy5.equalChars('f', 'a'));
        assertFalse(offBy5.equalChars('f', 'h'));
        System.out.println("testOffByN is passed");

    }
}