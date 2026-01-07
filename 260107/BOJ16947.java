import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ16947 {
    static List<List<Integer>> list;
    static int N;
    static boolean[] visited;
    static boolean[] isCycle;
    static int[] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

        visited = new boolean[N + 1];
        isCycle = new boolean[N + 1];
        dist = new int[N + 1];

        cycle(1, 0);

        bfs();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(dist[i]).append(" ");
        }
        System.out.println(sb);
    }

    public static int cycle(int now, int prev) {
        visited[now] = true;

        for (int next : list.get(now)) {
            if (next == prev) continue;

            if (visited[next]) {
                isCycle[next] = true;
                isCycle[now] = true;
                return next;
            }

            if (!visited[next]) {
                int res = cycle(next, now);

                if (res > 0) {
                    isCycle[now] = true;
                    if (now == res) {
                        return 0;
                    } else {
                        return res;
                    }
                }
            }
        }
        return 0;
    }

    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        Arrays.fill(dist, -1);

        for (int i = 1; i <= N; i++) {
            if (isCycle[i]) {
                dist[i] = 0;
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : list.get(now)) {
                if (dist[next] == -1) { // 방문하지 않은 곳(지선)만 거리 갱신
                    dist[next] = dist[now] + 1;
                    q.add(next);
                }
            }
        }
    }
}