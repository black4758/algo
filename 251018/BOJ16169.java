import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ16169 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        int[] cost = new int[n+1];
        int[] cnt = new int[n+1];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
            cost[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }
        List<List<int[]>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (arr[j] ==arr[i]+ 1) {
                    list.get(i).add(new int[]{j,(j-i)*(j-i)});
                    cnt[j]++;
                }
            }
        }
        Queue<Integer> q = new LinkedList<>();
        int[] dp = new int[n+1];

        for (int i = 1; i <= n; i++) {
            if (cnt[i] == 0) {
                q.add(i);
                dp[i] = cost[i];
            }
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            for(int[] next : list.get(cur)) {
                dp[next[0]]=Math.max(dp[next[0]],dp[cur]+next[1]);
                cnt[next[0]]--;
                if(cnt[next[0]]==0)
                {
                    dp[next[0]]+=cost[next[0]];
                    q.add(next[0]);
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if(arr[i]==max) {
                ans = Math.max(ans, dp[i]);
            }
        }
        if(ans==0) {
            ans=-1;
        }
        System.out.println(ans);
    }
}