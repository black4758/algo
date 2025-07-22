import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1967 {
    static class Edge{
        int end;
        int cost;
        public Edge(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }
    static int n,node,max;
    static ArrayList<Edge>[] edges;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        node = 0;
        max = 0;
        edges = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges[start].add(new Edge(end, cost));
            edges[end].add(new Edge(start, cost));
        }
        bfs(1);
        max = 0;
        bfs(node);
        System.out.println(max);
    }
    static void bfs(int start) {
        boolean[] visited = new boolean[n+1];
        Queue<Edge> queue = new LinkedList<>();
        queue.add(new Edge(start, 0));
        while (!queue.isEmpty()) {
            Edge now = queue.poll();
            visited[now.end] = true;
            if(now.cost > max) {
                max = now.cost;
                node =now.end;
            }
            for (Edge next : edges[now.end]) {
                if (!visited[next.end]) {
                    int cost = next.cost+now.cost;
                    queue.add(new Edge(next.end, cost));
                }
            }
        }
    }
}
