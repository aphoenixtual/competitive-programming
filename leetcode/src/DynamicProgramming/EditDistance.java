package DynamicProgramming;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        return helper (word1.toCharArray(),word2.toCharArray(),word1.length(),word2.length());

    }
    private int helper (char[]c1, char[] c2,int m,int n){
        int [][]dp =new int[m+1][n+1];
        // checking for empty string  test case
        // performing insert operation in order to convert empty word1 to word2
        for(int i=0;i<dp.length;i++)
            dp[i][0]=i;
        // performing delete operation in order to convert non-empty word2 to empty word1
        for(int j=0;j<dp[0].length;j++)
            dp[0][j]=j;

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                // if character matches pasting previous diagonal value at current index
                if(c1[i-1]==c2[j-1]){
                    dp[i][j]=dp[i-1][j-1];
                }
                else {
                    // if above condition is false performing 3 operations (insert ,remove and replace) on strings
                    // taking mimimum of theses three and adding 1 to answer as cost of performing any operation on string  is 1
                    dp [i][j]=1+Math.min(Math.min(dp[i][j-1],dp[i-1][j]),dp[i-1][j-1]);




                }
            }
        }


        return dp[m][n];
    }
}
