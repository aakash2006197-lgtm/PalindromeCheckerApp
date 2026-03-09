
import java.util.*;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string:");
        String input = scanner.nextLine();

        // Algorithm 1 – Two Pointer Method
        long start1 = System.nanoTime();

        boolean result1 = twoPointerPalindrome(input);

        long end1 = System.nanoTime();
        long time1 = end1 - start1;


        // Algorithm 2 – Stack Method
        long start2 = System.nanoTime();

        boolean result2 = stackPalindrome(input);

        long end2 = System.nanoTime();
        long time2 = end2 - start2;


        System.out.println("\nRESULTS");

        System.out.println("Two Pointer Result: " + result1);
        System.out.println("Two Pointer Time: " + time1 + " ns");

        System.out.println("\nStack Result: " + result2);
        System.out.println("Stack Time: " + time2 + " ns");

        scanner.close();
    }


    // Algorithm 1
    public static boolean twoPointerPalindrome(String str) {

        int left = 0;
        int right = str.length() - 1;

        while(left < right) {

            if(str.charAt(left) != str.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }


    // Algorithm 2
    public static boolean stackPalindrome(String str) {

        Stack<Character> stack = new Stack<>();

        for(char c : str.toCharArray()) {
            stack.push(c);
        }

        for(char c : str.toCharArray()) {

            if(c != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}