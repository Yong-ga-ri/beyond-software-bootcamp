package com.chap03.section01.graph_search;


import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 수업목표. BFS와 방문 배열을 활용한 최단거리 문제를 해결할 수 있다.
public class Application3 {

    // 설명. 문자열에서 한줄씩 읽어들이기 위한 BufferedReader를 반환하는 메소드(readLine())
    public static BufferedReader toBufferedReader(String str) {
        return new BufferedReader(
                new InputStreamReader(
                        new ByteArrayInputStream(
                                str.getBytes()
                        )
                )
        );
    }

    static boolean[][] visit;
    static int[][] map;
    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {1, -1, 0, 0};
    static int N, M;

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static Integer solution(String input) throws IOException {
        BufferedReader br = toBufferedReader(input);
        StringTokenizer st = new StringTokenizer(
                br.readLine()
        );

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visit = new boolean[N][M];

        // 설명. 입력값이 공백 없이 이어서 들어옴에 따라 한 문자씩 뜯어서 int 배열(map)에 옮겨담는 반복문
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            char[] ch = str.toCharArray();      // 문자열 -> char[]

            for (int j = 0; j < ch.length; j++) {
                map[i][j] = Character.getNumericValue(ch[j]);       // '1' -> 숫자 1
            }
        }

        visit[0][0] = true;             // start 위치 방문 체크부터 시작
        bfs(0, 0);

        return map[N -1][M -1];         // 도착지 (우하단) 위치의 값을 반환(도착할 때까지 최적의 경로 수)
    }

    private static void bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();

        q.add(new Node(x, y));

        while (!q.isEmpty()) {
            Node node = q.poll();

            //
            for (int i = 0; i < 4; i++) {
                int curX = node.x + dirX[i];
                int curY = node.y + dirY[i];

                // 설명. 지금 보는 좌표가 전체 범위를 벗어난 경우는 다음 위치(상하좌우)를 확인
                if (curX < 0 || curY < 0 || curX >= N || curY >= M) {
                    continue;
                }

                // 설명. 방문을 했던 좌표이거나 벽이라면
                if (visit[curX][curY] || map[curX][curY] == 0) {
                    continue;
                }

                q.add(new Node(curX, curY));
                map[curX][curY] = map[node.x][node.y] + 1;

                visit[curX][curY] = true;
            }
        }
    }
}
