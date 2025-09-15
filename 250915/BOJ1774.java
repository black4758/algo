import java.io.*;
import java.util.*;

public class BOJ1774 {
    static class Node {
        int to;
        double cost;
        Node(int to, double cost) {
            this.to = to;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        List<List<Node>> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                long x = arr[i][0] - arr[j][0];
                long y = arr[i][1] - arr[j][1];
                double distance = Math.sqrt(x * x + y * y);
                list.get(i).add(new Node(j, distance));
                list.get(j).add(new Node(i, distance));
            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;
            list.get(first).add(new Node(end, 0));
            list.get(end).add(new Node (first, 0));
        }
        boolean[] visited = new boolean[N];
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Double.compare(o1.cost, o2.cost));
        double ans = 0;
        int cnt = 0;
        pq.add(new Node(0, 0));
        while (!pq.isEmpty() && cnt < N) {
            Node now = pq.poll();
            if (!visited[now.to]) {
                visited[now.to] = true;
                cnt++;
                ans+=now.cost;
                for(Node next: list.get(now.to)) {
                    if(!visited[next.to]) {
                        pq.add(next);
                    }
                }
            }
        }
        System.out.printf("%.2f\n",ans);
    }
}
