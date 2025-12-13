import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1922_Prim {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        List<List<Node>> list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list.get(start).add(new Node(end, cost));
            list.get(end).add(new Node(start, cost));
        }
        boolean[] visited = new boolean[N+1];
        pq.offer(new Node(1, 0));
        int ans = 0;
        int cnt = 0;
        while (!pq.isEmpty() && cnt < N) {
            Node now = pq.poll();
            if (!visited[now.end]) {
                visited[now.end] = true;
                ans+=now.cost;
                cnt++;
                for (Node next : list.get(now.end)) {
                    if (!visited[next.end]) {
                        pq.add(next);
                    }
                }
            }
        }
        System.out.println(ans);
    }
    static class Node {
        int  end,cost;
        Node( int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }
}
