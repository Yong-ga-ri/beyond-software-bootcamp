package com.chap04.section01.greedy;

public class Application1 {

    public static int solution(int n) {

        // 설명. 3킬로와 5킬로 봉지로 가져갈 수 있는 최소 봉지 수
        int count = 0;

        while (true) {
            if(n % 5 == 0) return n / 5 + count;        // 처음부터 5킬로 봉지 또는 3킬로씩 덜어내며 5킬로 봉지로 나눌 수 있는 경우
            else if(n < 0) return -1;                   // 3킬로 또는 5킬로 봉지로 해결이 안되는 경우
//            else if (n == 0) return count;              // 3킬로 봉지로만 해결 되는 경우(1에 포함됨)

            // 설명. 어쩔 수 없이 3킬로 한 봉지만큼 무게를 덜어낸다.
            n -= 3;
            count++;
        }
    }
}
