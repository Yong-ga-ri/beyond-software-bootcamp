package com.chap03.section01.graph_search;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 학습목표. BFS와 x, y좌표를 활용한 문제를 해결할 수 있다. (feat.배열의 인덱스와 좌표는 반대 개념)
// 필기.
//  너비 우선 탐색(Breadth-First Search)
//   선입선출 구조의 queue를 활용한다.
//   시작 노드에서 출발해 시작 노드를 기준으로 가까운 노드를 먼저 방문하면서 탐색하는 알고리즘이다.
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

    // 설명. BFS로 문제 해결을 하기 위한 queue
    static Queue<Node> q = new LinkedList<>();

    // 설명. 상하좌우 개념의 좌표 배열들
    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {1, -1, 0, 0};

    // 설명. 배추밭
    static int map[][];

    // 설명. 방문한 배추 좌표 배열
    static boolean visit[][];

    // 설명. 현재 위치에 대한 좌표
    static int cur_x, cur_y;

    // 설명. 배추밭의 크기(너비/높이), 심어진 배추의 수
    static int M, N, K;

    // 설명. 필요한 배추흰지렁이의 수
    static int count;

    // 설명. x와 y좌표를 가지는 static 내부 클래스
    private static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int solution(String input) throws IOException {
        BufferedReader br = toBufferedReader(input);
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());       // 가로(를 통해 열을 지칭)
        N = Integer.parseInt(st.nextToken());       // 세로(를 통해 행을 지칭)
        K = Integer.parseInt(st.nextToken());       // 배추가 심허진 수

        map = new int[N][M];
        visit = new boolean[N][M];

        // 설명. 배추밭에 배추 심기(매핑)
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[y][x] = 1;      // 좌표 <-> 인덱스
        }

        count = 0;

        // 설명. 반복문의 i와 j는 캐릭터를 이동시키는 것과 같은 효과를 낸다. (또는 캐릭터의 좌표를 의미)
        for (int i = 0; i < N; i++ ) {
            for (int j = 0; j < M; j++) {

                // 설명. 방문 안한 위치에 배추가 심어져 있다면. (지렁이를 심자)
                if (!visit[i][j] && map[i][j] == 1) {
                    count++;

                    // 설명. 해당 위치 및 붙어있는 배추밭을 방문체크하고 que로 제거.
                    bfs(j, i);      // bfs의 인자는 x좌표, y좌표 순으로 받을 것
                }
            }

        }

        return count;
    }

    // 설명. 상하좌우에 배추가 심어져 있으면 한 번씩 동작
    private static void bfs(int x, int y) {
        q.offer(new Node(x, y));
        visit[y][x] = true;

        // 설명. 연속적으로 상하좌우에 배추가 심어져 있다면 해당 위치를 방문한 것으로 체크하고 que를 통해 비워내는 작업을 반복한다
        while(!q.isEmpty()) {
            Node node = q.poll();

            // 설명. 상하좌우 살펴보기
            for (int i = 0; i < 4; i++) {
                cur_x = node.x + dirX[i];
                cur_y = node.y + dirY[i];

                // 설명. 지금 보는 방향이 좌표로 존재하는 동시에, 방문이 안됐고, 배추가 심어져 있으면
                if (range_check() && visit[cur_y][cur_x] == false && map[cur_y][cur_x] == 1) {
                    q.offer(new Node(cur_x, cur_y));
                    visit[cur_y][cur_x] = true;
                }
            }
        }
    }

    private static boolean range_check() {
        return cur_x >= 0 && cur_y >= 0 && cur_x < M && cur_y < N;
    }
}
