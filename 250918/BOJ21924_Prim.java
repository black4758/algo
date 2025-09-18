import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ21924_Prim {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<List<int[]>> list = new ArrayList<>();
        long ans = 0;
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
            ans += cost;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(((o1, o2) -> o1[1] - o2[1]));
        long sum = 0;
        int cnt = 0;
        boolean[] visited = new boolean[N+1];
        pq.offer(new int[]{1, 0});
        while (!pq.isEmpty() && cnt < N) {
            int[] now = pq.poll();
            if (!visited[now[0]]) {
                visited[now[0]] = true;
                cnt++;
                sum += now[1];
                for (int[] next : list.get(now[0])) {
                    if (!visited[next[0]]) {
                        pq.offer(new int[]{next[0], next[1]});
                    }
                }
            }
        }
        ans -= sum;
        if(cnt==N)System.out.println(ans);
        else System.out.println(-1);
    }
}