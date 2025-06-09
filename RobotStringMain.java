import java.util.Scanner;

public class RobotStringMain {

    // Solution class containing the logic
    static class Solution1 {
        public String robotWithString(String s) {
            int n = s.length();

            // Array to count frequency of each character
            int[] count = new int[26];
            for (int i = 0; i < n; i++) {
                count[s.charAt(i) - 'a']++;
            }

            StringBuilder result = new StringBuilder(); // Final result
            StringBuilder stack = new StringBuilder();  // Robot's hand (temporary stack)
            char minChar = 'a'; // Start with smallest character

            for (int i = 0; i < n; i++) {
                char ch = s.charAt(i);
                stack.append(ch);                // Push to robot's hand
                count[ch - 'a']--;               // Decrease frequency

                // Find next available smallest character
                while (minChar <= 'z' && count[minChar - 'a'] == 0) {
                    minChar++;
                }

                // Pop from stack while top character <= smallest remaining
                while (stack.length() > 0 && stack.charAt(stack.length() - 1) <= minChar) {
                    result.append(stack.charAt(stack.length() - 1));
                    stack.setLength(stack.length() - 1); // pop
                }
            }

            // Add remaining characters from stack
            for (int i = stack.length() - 1; i >= 0; i--) {
                result.append(stack.charAt(i));
            }

            return result.toString();
        }
    }

    // Main method to run the program
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take string input from the user
        System.out.print("Enter the string: ");
        String input = sc.nextLine();

        // Create object and call the method
        Solution1 sol = new Solution1();
        String output = sol.robotWithString(input);

        // Print the result
        System.out.println("Lexicographically smallest result: " + output);

        sc.close();
    }
}

// OUTPUT:
// Enter the string: ashish
// Lexicographically smallest result: ahhsis
