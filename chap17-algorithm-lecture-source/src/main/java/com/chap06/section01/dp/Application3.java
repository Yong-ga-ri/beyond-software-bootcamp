package com.chap06.section01.dp;

import java.io.IOException;

public class Application3 {

    public static Integer[] dp = new Integer[101];

    public static int solution(int n) throws IOException {
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;

        return padovan(n);
    }

    private static int padovan(int n) {
        if(dp[n] == null)

            /* 설명. 현재 n위치가 비어있다면 점화식을 사용하여 채우고 그렇지 않다면 건너뛴다. */
            dp[n] = padovan(n - 2) + padovan(n - 3);
        return dp[n];
    }
}
