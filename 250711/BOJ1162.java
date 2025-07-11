import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1162 {
    static class Node {
        int end;
        long cost;
        int count;
        Node(int end, long cost,int count) {
            this.end = end;
            this.cost = cost;
            this.count = count;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K =Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        long[][] arr= new long[N+1][K+1];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(arr[i], Long.MAX_VALUE);
        }
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(start).add(new Node(end, cost,0));
            graph.get(end).add(new Node(start, cost,0));
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Long.compare(o1.cost , o2.cost));
        pq.add(new Node(1, 0,0));
        arr[1][0] = 0;
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (arr[now.end][now.count] < now.cost) {
                continue;
            }
            for(Node next: graph.get(now.end)) {
                if (arr[next.end][now.count]  > arr[now.end][now.count]  + next.cost) {
                    arr[next.end][now.count]  = arr[now.end][now.count]  + next.cost;
                    pq.add(new Node(next.end, arr[next.end][now.count] , now.count));
                }
                if(now.count<K){
                    if (arr[next.end][now.count+1]  > arr[now.end][now.count] ) {
                        arr[next.end][now.count+1] = arr[now.end][now.count];
                        pq.add(new Node(next.end, arr[next.end][now.count+1] , now.count+1));
                    }
                }
            }
        }
        long minTime=Long.MAX_VALUE;
        for (int i = 0; i <= K; i++) {
            minTime = Math.min(minTime, arr[N][i]);
        }
        System.out.println(minTime);
    }
}
