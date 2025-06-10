import java.util.*;

public class ClearStarsMain {

    // Inner class with the core logic
    static class Solution2 {
        public String clearStars(String s) {
            // Create 26 stacks, one for each letter 'a' to 'z'
            List<Deque<Integer>> stacks = new ArrayList<>();
            for (int i = 0; i < 26; i++) {
                stacks.add(new ArrayDeque<>());
            }

            // Convert the input string into a character array
            char[] chars = s.toCharArray();

            // Traverse each character
            for (int i = 0; i < s.length(); i++) {
                char curr = s.charAt(i);

                // If not '*', push its index into its letter stack
                if (curr != '*') {
                    stacks.get(curr - 'a').add(i);
                } else {
                    // If '*', remove the most recent smallest letter
                    for (int j = 0; j < 26; j++) {
                        if (!stacks.get(j).isEmpty()) {
                            int charIndex = stacks.get(j).pollLast();
                            chars[charIndex] = '*';  // Mark it deleted
                            break;
                        }
                    }
                }
            }

            // Build the final result by ignoring '*' characters
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (chars[i] != '*') {
                    result.append(chars[i]);
                }
            }

            return result.toString();
        }
    }

    // Main method to take user input and run the program
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String input = sc.nextLine();

        Solution2 sol = new Solution2();
        String output = sol.clearStars(input);

        System.out.println("Final string after clearing stars: " + output);

        sc.close();
    }
}

// OUTPUT:
// Enter the string: aaba*
// Final string after clearing stars: aab
