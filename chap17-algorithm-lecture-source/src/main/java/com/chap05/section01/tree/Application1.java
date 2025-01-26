package com.chap05.section01.tree;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


// 학습목표. 트리(Tree) 알고리즘을 활용하는 예제를 이해할 수 있다.
// 필기.
//  그래프에서 계층적인 구조를 나타내기 위해 최상위 노인 루트(root) 노드에서 시작하여 하위 노드들로 분기하는 방식으로 구성된 알고리즘이다.
public class Application1 {

    static int N;
    static int[] parent;
    static boolean[] visited;
    static StringTokenizer st;
    static List<Integer>[] adjList;
    static StringBuilder sb = new StringBuilder();
//    public static void main(String[] args) throws IOException {
//        for (List<Integer> list : adjList) {      // nullPointerException
//            System.out.println(list);
//        }
//    }

    public static BufferedReader toBufferedReader(String str) {
        return new BufferedReader(
                new InputStreamReader(
                        new ByteArrayInputStream(
                                str.getBytes()
                        )
                )
        );
    }

    public static String solution(String input) throws IOException {
        BufferedReader br = toBufferedReader(input);
        sb.delete(0, sb.length());  // 테스트 코드 환경을 위함

        N = Integer.parseInt(br.readLine());

        visited = new boolean[N + 1];
        adjList = new ArrayList[N + 1];
        parent = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }


        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adjList[a].add(b);
            adjList[b].add(a);
        }

        dfs(1);

        // 설명. dfs 이후 parent노드에는 각 노드의 부모 노드가 담겨있다.
        // 설명. 2번 노드부터 부모노드들을 하나의 문자열로 반환
        for (int i = 2; i < parent.length; i++) {
            sb.append(parent[i]);
            sb.append(" ");
        }

        return sb.toString();
    }

    private static void dfs(int parentNode) {

        // 설명. 이미 방문한 노드들은 부모 노드들이고 부모노드들은 재방문 하지 않도록 함
        visited[parentNode] = true;

        // 설명. 입력받은 값을 통해 생성된 list(관련있는 노드들) 로부터 정보 확인
        for(int nodeIdx : adjList[parentNode]) {
            if(!visited[nodeIdx]) {
                parent[nodeIdx] = parentNode;       // 이 줄 부터는 childnode를 의미
                dfs(nodeIdx);
            }
        }
    }

}
