import java.io.*;
import java.util.*;

public class BOJ16398_Prim_Graph {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<int[]>> list = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(((o1, o2) -> o1[1]-o2[1]));
        for (int i = 0; i < N; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int cost = Integer.parseInt(st.nextToken());
                if(i!=j){
                    list.get(i).add(new int[]{j, cost});
                }
            }
        }
        boolean[] visited = new boolean[N];
        int cnt = 0;
        long ans = 0;
        pq.add(new int[]{0, 0});
        while (!pq.isEmpty()&&cnt<N) {
            int[] poll = pq.poll();
            if (!visited[poll[0]]) {
                visited[poll[0]] = true;
                ans+=poll[1];
                cnt++;
                for(int[] next: list.get(poll[0])) {
                    if(!visited[next[0]]){
                        pq.add(new int[]{next[0], next[1]});
                    }
                }
            }
        }
        System.out.println(ans);
    }
}

