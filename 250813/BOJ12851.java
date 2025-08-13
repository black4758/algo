import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ12851 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int cnt=0;
        int[] visited = new int[100001];
        Queue<Integer> q = new LinkedList<>();
        int ans=Integer.MAX_VALUE;
        q.add(N);
        Arrays.fill(visited, Integer.MAX_VALUE);
        visited[N] = 0;
        while (!q.isEmpty()) {
            int now = q.poll();
            if (now == K) {
                if (ans>visited[now]) {
                    ans = visited[now];
                    cnt = 1;
                }
                else if (visited[now] == ans) {
                    cnt++;
                }

            }
            if (now*2<=100000 && visited[now*2]>=visited[now]+1) {
                visited[now*2] = visited[now]+1;
                q.add(now*2);
            }
            if (now+1<=100000 && visited[now+1]>=visited[now]+1) {
                visited[now+1] = visited[now]+1 ;
                q.add(now+1);
            }
            if (now-1>=0 && visited[now-1]>=visited[now]+1) {
                visited[now-1] = visited[now]+1 ;
                q.add(now-1);
            }
        }
        System.out.println(ans);
        System.out.println(cnt);
    }
}
