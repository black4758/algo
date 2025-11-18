import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2211 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] dist = new int[N+1];
        boolean[] visited = new boolean[N+1];
        List<List<int[]>> list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.get(a).add(new int[]{b, c});
            list.get(b).add(new int[]{a, c});
        }
        int[] parent = new int[N + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        Arrays.fill(dist,Integer.MAX_VALUE);
        pq.offer(new int[]{1,0});
        dist[1] = 0;
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            if(visited[now[0]]) {
               continue;
            }
            visited[now[0]] = true;
//            if (now[1] > dist[now[0]]) continue;

            for(int[] next : list.get(now[0])) {
                if(now[1]+next[1]< dist[next[0]]) {
                    dist[next[0]] = now[1]+next[1];
                    pq.offer(new int[]{next[0],dist[next[0]]});
                    parent[next[0]]=now[0];
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for(int i = 2; i <= N; i++) {
            sb.append(i).append(" "). append(parent[i]).append("\n");
            cnt++;
        }
        System.out.println(cnt);
        System.out.println(sb.toString());
    }
}
