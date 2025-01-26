package com.chap04.section01.greedy;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Application3_2 {
    public static BufferedReader toBufferedReader(String str) {
        InputStream is = new ByteArrayInputStream(str.getBytes());
        return new BufferedReader(new InputStreamReader(is));
    }

    public static int solution(String input) throws IOException {
        int max_count = 0;

        BufferedReader br = toBufferedReader(input);
        int N = Integer.parseInt(br.readLine());                // 회의 수
        ArrayList<Time> timeList = new ArrayList<>();               // 회의 갯수 * (시작/종료 시간)

        StringTokenizer str;
        for (int i = 0; i < N; i++) {
            str = new StringTokenizer(br.readLine());
            int start = Integer.valueOf(str.nextToken());      // 시작 시간
            int end = Integer.valueOf(str.nextToken());        // 종료 시간
            timeList.add(new Time(start, end));
        }

        Collections.sort(timeList);
        int endTime = 0;
        for(Time dis: timeList) {
            if(dis.start == dis.end) {
                max_count++;
                continue;
            }
            if(dis.start >= endTime) {
                max_count++;
                endTime = dis.end;
            }
        }

        return max_count;
    }
}

class Time implements Comparable<Time> {

    public int start, end;

    public Time(int start, int end) {
        this.start = start;
        this.end = end;
    }

    /* 설명. 짧은 회의 시간 순으로(greedy) */
    @Override
    public int compareTo(Time o) {
        if(this.end == o.end) return o.start - this.start;      // 시작시간 내림차순
        else return this.end - o.end;                           // 종료시간 오름차순
    }
}
