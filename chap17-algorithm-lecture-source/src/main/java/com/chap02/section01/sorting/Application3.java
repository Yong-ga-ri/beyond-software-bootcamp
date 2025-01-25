package com.chap02.section01.sorting;


import java.util.Arrays;

// 학습목표. 삽입 정렬을 이해할 수 있다.
// 필기.
//  삽입 정렬(Insertion Sort)
//   이미 정렬된 데이터 범위에 정렬되지 않은 데이터를 적절한 위치에 삽입시켜 정렬하는 방식이다.
//   시간복잡도는 0(n^2) 이라 효율적이지는 않다.
//   해당 위치에 있는 값을 앞의 어떤 위치에 들어갈지 훑어보며 밀어주다 원하는 위치에 넣게 된다.
public class Application3 {

    /* 설명.
     *  문제 내용
     *   : N개의 정수가 주어졌을 때, 삽입 정렬 알고리즘을 사용하여 오름차순으로 정렬하는 프로그램을 작성하시오.
     *  입력
     *   - 첫 번째 줄에 자연수 N(1 <= N <= 100)이 주어진다.
     *   - 두 번째 줄에 N개의 정수가 공백으로 구분되어 입력된다. 각 정수는 -10^9 이상, 10^9 이하이다.
     *  출력
     *    - 오름차순으로 정렬된 수열을 공백으로 구분하여 출력한다.
     *
     * 설명.
     *  예시 입력 1
     *    - 8
     *      33 39 20 4 16 24 19 28
     *  예시 출력 1
     *    - 4 16 19 20 24 28 33 39
     *
     * 설명.
     *  예시 입력 2
     *    - 6
     *      14 38 5 26 17 19
     *  예시 출력 2
     *    - 5 14 17 19 26 38
     * */

    public static void solution(int length, int[] arr) {
        for (int i = 1; i < length; i++)      {
            int temp = arr[i];
            int j = 0;
            System.out.println("temp: " + temp);
            System.out.println("before: " + Arrays.toString(arr));
            for (j = i - 1; j >= 0; j--) {
                System.out.println("i: " + i + ", j: " + j);
                System.out.println("arr[j]: " + arr[j] + ", temp: " + temp);
                if(arr[j] > temp) {             // 뒤로 밀기
                    System.out.println("arr[" + j + "]: " + arr[j] + ", 하나의 인덱스 뒤로 밀릴 것.");
                    arr[j + 1] = arr[j];
                } else break;
            }
            System.out.println("j: " + j);
            System.out.println();
            arr[j+1] = temp;
        }
    }
}
