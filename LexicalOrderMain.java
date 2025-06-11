import java.util.*;

public class LexicalOrderMain {

    // Main method to take input and display result
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        List<Integer> result = lexicalOrder(n);

        System.out.println("Lexicographical order:");
        for (int i = 0; i < result.size(); i = i + 1) {
            System.out.print(result.get(i) + " ");
        }

        sc.close();
    }

    // Method to return numbers in lexicographical order
    public static List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();

        // Start DFS from numbers 1 to 9
        for (int i = 1; i <= 9; i = i + 1) {
            dfs(i, n, result);
        }

        return result;
    }

    // Helper DFS method
    public static void dfs(int curr, int n, List<Integer> result) {
        if (curr > n) {
            return;
        }

        result.add(curr);

        // Try to add digits 0 to 9
        for (int i = 0; i <= 9; i = i + 1) {
            int next = curr * 10 + i;
            if (next > n) {
                break;
            }
            dfs(next, n, result); // Recursive call
        }
    }
}
