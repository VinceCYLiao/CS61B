import java.util.Deque;

public class Palindrome {

    private char[] stringToArray(String string) {
        char[] charArray = new char[string.length()];
        for(int i = 0; i < string.length(); i++) {
            charArray[i] = string.charAt(i);
        }
        return charArray;
    }

    public Deque<Character> wordToDeque(String word) {
        char[] charArray = stringToArray(word);
        Deque<Character> D = new LinkedListDeque<>();
        for (int i = 0; i < charArray.length; i++) {
            D.addLast(charArray[i]);
        }
        return D;
    }

    public boolean isPalindrome(String word) {
//        boolean result = true;
//        int middle = (int) Math.floor(word.length()/2);
//        char[] charArray = stringToArray(word);
//        for (int i = 0; i <= middle; i++) {
//            if (charArray[i] != charArray[charArray.length - 1 - i]) {
//                result = false;
//                break;
//            }
//        }
//
//        return result;

        Deque<Character> D = wordToDeque(word);
        boolean result = true;
        int middle = (int) Math.floor(word.length()/2);
        for (int i = 0; i < middle; i++) {
           Character first = D.removeFirst();
           Character last = D.removeLast();
           System.out.println(first + "+" + last);
           if (first != last) {
               result = false;
               break;
           }
        }
        return result;
    }

    private boolean isPalindromeHelper(Deque<Character> D, CharacterComparator cc) {
        int middle = D.size()/2;
        boolean result = true;
        for (int i = 0; i < middle; i++) {
            Character first = D.removeFirst();
            Character last = D.removeLast();
            if (!cc.equalChars(first, last)) {
                result = false;
                break;
            }
        }
        return result;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (word.length() == 1) return true;
        Deque<Character> D = wordToDeque(word);
        return isPalindromeHelper(D, cc);

    }
}