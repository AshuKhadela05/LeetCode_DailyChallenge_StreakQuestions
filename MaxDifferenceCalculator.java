import java.util.Scanner;

public class MaxDifferenceCalculator {

    // Method to calculate the max difference between odd and even frequencies
    public static int maxDifference(String s) {
        int[] freq = new int[26];  // Frequency array for 'a' to 'z'

        // Count frequency of each character
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        int maxOdd = 0;
        int minEven = s.length();  // Initialize to max possible

        // Check frequencies
        for (int i = 0; i < 26; i++) {
            int f = freq[i];
            if (f == 0) {
                continue;
            }

            if (f % 2 == 1) {  // Odd frequency
                if (f > maxOdd) {
                    maxOdd = f;
                }
            } else {  // Even frequency
                if (f < minEven) {
                    minEven = f;
                }
            }
        }

        return maxOdd - minEven;
    }

    // Main method for input/output
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String input = sc.nextLine();

        int result = maxDifference(input);
        System.out.println("Maximum Difference = " + result);

        sc.close();
    }
}

// OUTPUT:
// Enter the String: aaaaabbc
// Maximum Difference = 3
