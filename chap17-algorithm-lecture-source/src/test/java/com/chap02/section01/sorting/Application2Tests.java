package com.chap02.section01.sorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

class Application2Tests {

    private static int input1, input2;
    private static int[] act1, act2;
    private static int[] exp1, exp2;

    @BeforeAll
    public static void set() {

        /* 설명. 예시 1 */
        input1 = 10;
        act1 = new int[]{32, 7, 34, 39, 40, 41, 22, 31, 23, 42};
        exp1 = new int[]{42, 41, 40, 39, 34, 32, 31, 23, 22, 7};


        /* 설명. 예시 2 */
        input2 = 6;
        act2 = new int[]{42, 29, 34, 64, 28, 12};
        exp2 = new int[]{64, 42, 34, 29, 28, 12};
    }

    public static Stream<Arguments> provideAscendingSource() {
        return Stream.of(
                Arguments.of(input1, act1, exp1),
                Arguments.of(input2, act2, exp2)
        );
    }

    @DisplayName("선택 정렬 테스트")
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    @ParameterizedTest
    @MethodSource("provideAscendingSource")
    public void selectedSortingTest(int length, int[] actual, int[] expected) {
        Application2.solution(length, actual);
        Assertions.assertArrayEquals(expected, actual);
    }

}