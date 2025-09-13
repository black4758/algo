import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ16398_Prim {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        PriorityQueue<int[]> pq = new PriorityQueue<>(((o1, o2) -> o1[1]-o2[1]));
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
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
                for(int next=0; next<N; next++) {
                    if(!visited[next]){
                        pq.add(new int[]{next, arr[poll[0]][next]});
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
