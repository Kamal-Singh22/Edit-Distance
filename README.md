# Edit-Distance
Given two strings word1 and word2, compute the minimum number of operations required to convert word1 into word2. You are allowed the following operations on a word:
Explanation:
Dynamic Programming Table (dp):

dp[i][j] represents the minimum edit distance between the first i characters of word1 and the first j characters of word2.
Initialization:

The first row is initialized to [0, 1, 2, ..., n] because converting an empty string to the first j characters of word2 requires j insertions.
Similarly, the first column is initialized to [0, 1, 2, ..., m] since converting the first i characters of word1 to an empty string requires i deletions.
Transition:

If the current characters of word1 and word2 are the same, the cost is the same as dp[i-1][j-1].
Otherwise, consider three operations (delete, insert, replace) and choose the one with the minimum cost.
Final Answer:

The answer is found in dp[m][n], which represents the edit distance between word1 and word2.
