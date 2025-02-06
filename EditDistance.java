import java.util.Scanner;

public class EditDistance {

    // Function to compute the edit distance (Levenshtein distance) between word1 and word2
    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        // dp[i][j] will hold the minimum edit distance between word1[0...i-1] and word2[0...j-1]
        int[][] dp = new int[m + 1][n + 1];
        
        // Base case: converting an empty word1 to word2 by inserting all characters of word2
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        
        // Base case: converting word1 to an empty word2 by deleting all characters of word1
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        
        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // If characters are the same, no operation needed at this step
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // Consider deletion, insertion, and substitution
                    int deleteOp = dp[i - 1][j] + 1;     // Delete from word1
                    int insertOp = dp[i][j - 1] + 1;      // Insert into word1
                    int replaceOp = dp[i - 1][j - 1] + 1; // Replace character in word1
                    
                    dp[i][j] = Math.min(deleteOp, Math.min(insertOp, replaceOp));
                }
            }
        }
        
        return dp[m][n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter word1:");
        String word1 = scanner.nextLine();
        
        System.out.println("Enter word2:");
        String word2 = scanner.nextLine();
        
        int result = minDistance(word1, word2);
        System.out.println("The minimum edit distance is: " + result);
        
        scanner.close();
    }
}
