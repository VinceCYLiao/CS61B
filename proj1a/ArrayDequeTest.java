public class ArrayDequeTest {

    public static boolean checkEmpty(boolean expected, boolean actual ) {
        if (expected == actual) {
            System.out.println("Expected is empty is " + expected + " actual is " + actual );
            return true;
        }
        return false;
    }

    public static void printTestResult(boolean result) {
        if (result) {
            System.out.println("test passed");
        } else {
            System.out.println("test failed");
        }
    }

    public static void emptyTest() {
        ArrayDeque<Integer> A = new ArrayDeque<>();

        boolean result = checkEmpty(true, A.isEmpty());
        A.addFirst(1);
        result = checkEmpty(false, A.isEmpty());
        A.removeFirst();
        result = checkEmpty(true, A.isEmpty());

        printTestResult(result);

    }

    public static <T> boolean elmTest(T expected, T actual) {
        System.out.println("expected " + expected + " , actual " + actual);
        if (expected == actual) {

            return true;
        }
        return false;
    }


    public static void addFirstTest() {
        ArrayDeque<String> A = new ArrayDeque<>();
        A.addFirst("b");

        boolean result = elmTest("b", A.get(0));

        A.addFirst("a");

        result = elmTest("a", A.get(0));

        printTestResult(result);
    }

    public static void main(String[] args) {
        emptyTest();
        addFirstTest();
    }
}
