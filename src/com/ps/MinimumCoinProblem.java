package com.ps;

import java.util.Arrays;

public class MinimumCoinProblem {

    public int coinChangeHelper(int[] coins, int amount) {
        if (coins.length == 0 || amount == 0) return 0;
        if (amount < coins[0]) return -1;

        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = -1;
        }

        for (int j = 0; j < coins.length; j++) {
            if (coins[j] <= amount)
                dp[coins[j]] = 1;

        }

        for (int i = coins[0]; i <= amount; i++) {

            int min = i;
            for (int j = 0; j < coins.length; j++) {
                int ai = i - coins[j];
                if (dp[i] != 1 && ai > 0 && dp[ai] != -1 && dp[ai] < min) {
                    min = dp[ai];
                }
            }
            if (min < i)
                dp[i] = min + 1;


        }
        return dp[amount];

    }

    public void coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        long startMillis = System.currentTimeMillis();
        int min = coinChangeHelper(coins, amount);
        long endMillis = System.currentTimeMillis();
        System.out.println("Normal   : " + min + " in time: " + (endMillis - startMillis));


    }


    public int coinChangeRecursionHelper(int[] coins, int amount) {

        if (amount == 0) return 0;
        if (amount < 0 || amount < coins[0]) return -1;

        int min = amount;

        for (int i = 0; i < coins.length; i++) {
            if(amount-coins[i]<0) continue;
//            if(amount%coins[i]==0) {
//                min = amount/coins[i];
//                continue;
//            }
            int currMin = coinChangeRecursionHelper(coins, amount - coins[i]);
            if (currMin == -1) continue;
            ;
            currMin++;
            if (currMin < min) {
                min = currMin;
            }
        }
        return min != amount ? min : -1;

    }

    public void coinChangeRecursion(int[] coins, int amount) {
        Arrays.sort(coins);
        long startMillis = System.currentTimeMillis();
        int min = coinChangeRecursionHelper(coins, amount);
        long endMillis = System.currentTimeMillis();
        System.out.println("Recursion: " + min + " in time: " + (endMillis - startMillis));


    }

    public static void main(String[] args) {
        int[] coins = {3, 5};
        int amount = 7;
        MinimumCoinProblem mcp = new MinimumCoinProblem();
        mcp.coinChange(coins, amount);
        mcp.coinChangeRecursion(coins, amount);

        int[] coins2 = {1, 2};
        amount = 2;
        mcp.coinChange(coins2, amount);
        mcp.coinChangeRecursion(coins2, amount);
        System.out.println();


        int[] coins3 = {474, 83, 404, 3};
        amount = 1096;
        mcp.coinChange(coins3, amount);
        mcp.coinChangeRecursion(coins3, amount);


    }
}
