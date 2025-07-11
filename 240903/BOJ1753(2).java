package main.java._2025_06_26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1753(2) {
    static class Node {
        int end;
        int cost;
        Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K =Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        int[] arr= new int[V+1];
        Arrays.fill(arr, Integer.MAX_VALUE);
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            graph.get(Integer.parseInt(st.nextToken())).add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.add(new Node(K, 0));
        arr[K] = 0;
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (arr[now.end] < now.cost) {
                continue;
            }
            for(Node next: graph.get(now.end)) {
                if (arr[next.end] > arr[now.end] + next.cost) {
                    arr[next.end] = arr[now.end] + next.cost;
                    pq.add(new Node(next.end, arr[next.end]));
                }
            }
        }
        for (int i = 1; i <= V; i++) {
            if (arr[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            }
            else {
                System.out.println(arr[i]);
            }
        }
    }
}
