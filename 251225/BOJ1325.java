package main.java._2025_12_25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1325 {
    static ArrayList<Integer>[] list;
    static int[] visited;
    static int[] ans;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        ans = new int[N + 1];
        visited = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            list[B].add(A);
        }

        int max = 0;

        for (int i = 1; i <= N; i++) {
            bfs(i);
        }

        for (int i = 1; i <= N; i++) {
            max = Math.max(max, ans[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (ans[i] == max) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }

    static void bfs(int startNode) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(startNode);
        visited[startNode] = startNode;

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int next : list[now]) {
                if (visited[next] != startNode) {
                    visited[next] = startNode;
                    ans[startNode]++;
                    q.add(next);
                }
            }
        }
    }
}