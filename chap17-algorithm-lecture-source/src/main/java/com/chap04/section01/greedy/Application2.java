package com.chap04.section01.greedy;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Application2 {

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
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coin = new int[N];
        for (int i = 0; i < coin.length ; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        for (int i = N - 1; i >= 0; i--) {
            if(coin[i] <= K) {

                //
                count += (K / coin[i]);

                //
                K %= coin[i];
            }
        }

        return count;
    }

}
