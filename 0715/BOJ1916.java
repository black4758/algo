package main.java._2025_06_26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1916 {
    static class Node {
        int end;
        int cost;
        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[N+1];
        int [] store = new int[N+1];
        ArrayList<ArrayList<Node>> list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
            store[i] = Integer.MAX_VALUE;
        }
        StringTokenizer st =null;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            list.get(Integer.parseInt(st.nextToken())).add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        st= new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.add(new Node(start, 0));
        store[start] = 0;
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if(visited[now.end]) {
                continue;
            }
            visited[now.end] = true;
            for (Node next : list.get(now.end)) {
                int cost = store[now.end]+ next.cost;
                if(store[next.end]>cost) {
                    store[next.end]=cost;
                    pq.add(new Node(next.end, cost));
                }
            }
        }
        System.out.println(store[end]);
    }
}
