package com.chap02.section01.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 학습목표. 퀵 정렬을 이해할 수 있다.
// 필기.
//  퀵 정렬(Quick Sort)
//   기준값(pivot)을 선정해 해당 값보다 작은 데이터와 큰 데이터로 분류하는 것을 반복해서 정렬
//   병합 알고리즘과 함께 실제 정렬 알고리즘으로 많이 활용되고 있다.
//   시간 복잡도는 O(nlogn)이지만 최악의 경우는 0(n^2)이다.
public class Application4 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int length = Integer.parseInt(br.readLine());
            int[] arr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            solution(0, arr.length - 1, arr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void solution(int low, int high, int[] arr) {
        if (low >= high) return;

        // 설명. low와 high 포인터를 이동해서 low가 high를 지나칠 때까지 한 사이클
        int pivot = process(low, high, arr);

        solution(low, pivot, arr);
        solution(pivot + 1, high, arr);

    }

    // 설명. low에 해당하는 포인터와 high에 해당하는 포인터를 최대한 움직여 pivot을 반환하는 메소드
    public static int process(int left, int right, int[] arr) {
        int lo = left - 1;
        int hi = right + 1;

        int pivot = arr[(left + right) / 2];

        while(true) {
            System.out.println("pivot: " + pivot);

            // 설명. pivot 위치에 있는 값보다 작은 값을 가르키면 lo 포인터를 증가한다.
            do {
                lo++;
                System.out.println("lo moved right");
            } while(arr[lo] < pivot);

            // 설명. pivot 위치에 있는 값보다 크면서 lo 포인터의 위치보다 크거나 같은 위치이면 hi 포인터를 감소한다.
            do {
                hi--;
                System.out.println("hi moved left");
            } while (arr[hi] > pivot && lo <= hi);

            // 설명. lo 포인터의 위치가 hi 포인터를 지를려고 하면 hi 포인터 위치를 반한다. (분할 기준 반환)
            if (lo >= hi) {
                return hi;
            }
            System.out.println("lo: " + lo + ", hi: " + hi);
            System.out.println("before: arr = " + Arrays.toString(arr));
            swap(arr, lo, hi);
            System.out.println("after : arr = " + Arrays.toString(arr));
        }
//        return pivot;
    }

    private static void swap(int[] arr, int lo, int hi) {
        int temp = arr[lo];
        arr[lo] = arr[hi];
        arr[hi] = temp;
    }
}
