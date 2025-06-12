import java.util.Scanner;

public class KthLexicographicalNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input values for n and k
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        // Call the method and print the result
        int result = findKthNumber(n, k);
        System.out.println("The " + k + "-th smallest number in lexicographical order is: " + result);

        sc.close();
    }

    // Function to find the k-th smallest number in lexicographical order
    public static int findKthNumber(int n, int k) {
        int current = 1;
        k = k - 1; // we start from 1, so subtract 1

        while (k > 0) {
            long steps = countSteps(n, current, current + 1);

            // If total steps under this prefix are less than or equal to k, skip this prefix
            if (steps <= k) {
                k = k - (int) steps;
                current = current + 1; // move to next prefix
            } else {
                current = current * 10; // go deeper into this prefix
                k = k - 1;
            }
        }

        return current;
    }

    // Helper function to count steps between n1 and n2 in lexicographical order
    public static long countSteps(int n, long n1, long n2) {
        long steps = 0;

        while (n1 <= n) {
            steps = steps + Math.min(n + 1, n2) - n1;
            n1 = n1 * 10;
            n2 = n2 * 10;
        }

        return steps;
    }
}
