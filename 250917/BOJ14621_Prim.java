import java.io.*;
import java.util.*;
public class BOJ14621_Prim {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[] type = new char[N+1];
        boolean[] visited = new boolean[N+1];
        List<List<int[]>> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            type[i] = st.nextToken().charAt(0);
        }
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            if(type[start] != type[end]) {
                list.get(start).add(new int[]{end, cost});
                list.get(end).add(new int[]{start, cost});
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);
        pq.add(new int[]{1, 0});
        int cnt = 0;
        int ans = 0;
        while (!pq.isEmpty() && cnt < N) {
            int[] now = pq.poll();
            if(!visited[now[0]]) {
                visited[now[0]] = true;
                cnt++;
                ans+=now[1];
                for (int[] next : list.get(now[0])) {
                    if(!visited[next[0]]) {
                        pq.add(next);
                    }
                }
            }
        }
        if(cnt != N) {
            System.out.println(-1);
        }else
            System.out.println(ans);
    }
}
