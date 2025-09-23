import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ18223 {
    static class Edge {
        int end;
        int cost;
        public Edge(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }
    static List<List<Edge>> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= V; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list.get(start).add(new Edge(end, cost));
            list.get(end).add(new Edge(start, cost));
        }
        int dist1V = solution(1, V);
        int dist1P = solution(1, P);
        int distPV = solution(P, V);

        if (dist1P + distPV <= dist1V) {
            System.out.println("SAVE HIM");
        } else {
            System.out.println("GOOD BYE");
        }
    }
    static int solution(int start, int end) {
        int[] arr = new int[list.size()];
        Arrays.fill(arr, 100_000_000);
        arr[start] = 0;
        boolean[] visited = new boolean[list.size()];
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.add(new Edge(start, 0));
        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            if(now.end == end ) {
                return now.cost;
            }
            if(!visited[now.end]) {
                visited[now.end] = true;
                for (Edge next : list.get(now.end)) {
                    if(arr[next.end]>arr[now.end]+next.cost) {
                        arr[next.end] = arr[now.end]+next.cost;
                        pq.add(new Edge(next.end, arr[next.end]));
                    }
                }
            }
        }
        return arr[end];
    }
}
