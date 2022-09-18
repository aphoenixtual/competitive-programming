package DynamicProgramming;

import java.util.Arrays;

public class CoinChange {
    /*
    Simple Bottom Up DP Solution - beats 99.95%
     */
    public int coinChange(int[] coins, int amount) {
        int maxAmount = amount + 1; // Integer.MAX_VALUE also works if arguments are equal to it
        int[] dp = new int[amount + 1]; // to account for 0 amount
        Arrays.fill(dp, maxAmount);
        dp[0] = 0;

        for (int denom : coins) {
            for (int value = denom; value <= amount; value++) { // we can start a the denomination
                dp[value] = Math.min(dp[value], dp[value - denom] + 1);
            }
        }

        return dp[amount] == maxAmount ? -1 : dp[amount];
    }
}

