package com.chap06.section01.dp;

public class Application2 {

    public static int solution(int n) {

        int[] dp = new int[1000 + 1];
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
