
    import java.util.*;

    public class UseCase12PalindromeCheckerApp {
        public static void main(String[] args) {
            String input = args.length > 0 ? args[0] : "";
            PalindromeStrategy strategy = new StackStrategy();
            PalindromeChecker checker = new PalindromeChecker(strategy);
            System.out.println("Is Palindrome: " + checker.check(input));
        }
    }

    interface PalindromeStrategy {
        boolean check(String input);
    }

    class PalindromeChecker {
        private PalindromeStrategy strategy;

        public PalindromeChecker(PalindromeStrategy strategy) {
            this.strategy = strategy;
        }

        public boolean check(String input) {
            return strategy.check(input);
        }
    }

    class StackStrategy implements PalindromeStrategy {
        public boolean check(String input) {
            Stack<Character> stack = new Stack<>();
            for (char c : input.toCharArray()) {
                stack.push(c);
            }
            for (char c : input.toCharArray()) {
                if (c != stack.pop()) {
                    return false;
                }
            }
            return true;
        }
    }

    class DequeStrategy implements PalindromeStrategy {
        public boolean check(String input) {
            Deque<Character> deque = new ArrayDeque<>();
            for (char c : input.toCharArray()) {
                deque.add(c);
            }
            while (deque.size() > 1) {
                if (!deque.pollFirst().equals(deque.pollLast())) {
                    return false;
                }
            }
            return true;
        }
    }

