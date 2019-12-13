package problems.onRecursionAndDp.dp;

public class EditDistance {
        public int minDistance(String word1, String word2) {
            int dp[][] = new int[word1.length()+1][word2.length()+1];

            //insertion needed for all chars in first row
            //to convert "" to word2
            for(int col=1;col<=word2.length();col++)
                dp[0][col] = dp[0][col-1] + 1;

            //deletion needed in 1st column to convert word2 to "" blank string
            for(int row=1;row<=word1.length();row++)
                dp[row][0] = dp[row-1][0] + 1;

            //to fill remaining matrix
            for(int row=1;row<=word1.length();row++){
                for(int col=1;col<=word2.length();col++){
                    if(word1.charAt(row-1) == word2.charAt(col-1)) {
                        dp[row][col] = dp[row-1][col-1];
                        continue;
                    }
                    //when we replace char in word1 to given char at word2
                    //then we min value for match of string 0 to row-1 to 0 to col-1
                    //which is found in block row-1, col-1.
                    int replaceval = dp[row-1][col-1];

                    //when we delete character in word1 then what we are saying is we
                    //want min for match of pattern  0 to row-1 of word1
                    //to 0 to col of word2
                    int deleteval  = dp[row-1][col];

                    //when we insert value in word1 what this means is
                    //we need to find min value for conversion of substring 0 to row from word1
                    //to 0 to col-1 in word2 as colth char is inserted in word1
                    int insval = dp[row][col-1];

                    dp[row][col] = Math.min(replaceval, Math.min(deleteval, insval)) + 1;
                    //add cost of operation -> 1 only when characters in that position are not                     //same

                }
            }
            return dp[word1.length()][word2.length()];
        }

}

/**
 * 72. Edit Distance
 * Hard
 *
 * 2799
 *
 * 44
 *
 * Add to List
 *
 * Share
 * Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
 *
 * You have the following 3 operations permitted on a word:
 *
 * Insert a character
 * Delete a character
 * Replace a character
 * Example 1:
 *
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 * Example 2:
 *
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation:
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 **/