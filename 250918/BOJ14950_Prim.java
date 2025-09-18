import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ14950_Prim {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        List<List<int[]>> list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list.get(start).add(new int[]{end, cost});
            list.get(end).add(new int[]{start, cost});
        }
        boolean[] visited = new boolean[N + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.add(new int[]{1, 0});
        int ans = 0;
        int cnt = 0;
        while (!pq.isEmpty()&&cnt<N) {
            int[] now = pq.poll();
            if (!visited[now[0]]) {
                visited[now[0]] = true;
                ans += now[1] + (cnt > 0 ? (cnt - 1) * t : 0);
                cnt++;
                for (int[] next : list.get(now[0])) {
                    if (!visited[next[0]]) {
                        pq.add(new int[]{next[0], next[1]});
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
