import java.io.*;
import java.util.*;

public class BOJ2056 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] cost = new int[N+1];
        int[] arr = new int[N+1];
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cost[i] = Integer.parseInt(st.nextToken());
            int cnt= Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt; j++) {
                int end= Integer.parseInt(st.nextToken());
                list.get(end).add(i);
                arr[i]++;
            }
        }
        int[] dp = new int[N+1];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (arr[i] == 0) {
                q.add(i);
                dp[i] = cost[i];
            }
        }
        while (!q.isEmpty()) {
            int now = q.poll();
            for( int next: list.get(now)) {
                arr[next]--;
                dp[next] = Math.max(dp[next], dp[now] + cost[next]);
                if (arr[next] == 0) {
                    q.add(next);
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= N; i++) {
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }
}
