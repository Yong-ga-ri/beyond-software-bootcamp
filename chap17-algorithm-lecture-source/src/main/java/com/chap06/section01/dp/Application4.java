package com.chap06.section01.dp;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Application4 {

    public static BufferedReader toBufferedReader(String str) {
        return new BufferedReader(
                new InputStreamReader(
                        new ByteArrayInputStream(
                                str.getBytes()
                        )
                )
        );
    }

    public static int solution(String input) throws IOException {

        BufferedReader br = toBufferedReader(input);

        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N + 1][N + 1];
        int[][] p = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j++) {
                p[i][j] = Integer.parseInt(st.nextToken());
            }

            System.out.println(Arrays.toString(p[i]));
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                // 설명. dp[i - 1]은 층 dp배열, [j - 1]은 왼쪽 위, [j]는 오른쪽 위
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + p[i][j];
            }
            System.out.println("dp's row: " + i);
            System.out.println(Arrays.toString(dp[i]));
            System.out.println("p's row: ");
            System.out.println(Arrays.toString(p[i]));

            System.out.println("==================");
        }

        // 설명. dp의 맨 아래층 dp 배열에 담긴 값 중 가장 큰값 추출해서 반환
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            answer = Math.max(answer, dp[N][i]);
        }




        return answer;
    }
}
