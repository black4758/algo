import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2629 {
    static int[] arr;
    static boolean[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp = new boolean[N+1][15001];
        dfs(0,0);

        int K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int now = Integer.parseInt(st.nextToken());
            if (now > 15000) {
                sb.append("N ");
                continue;
            }
            if (dp[N][now]) {
                sb.append("Y ");
            } else {
                sb.append("N ");
            }
        }
        System.out.println(sb);
    }
    static void dfs(int i, int weight) {
        if(dp[i][weight]) return;

        dp[i][weight] = true;

        if (i == arr.length) {
            return;
        }

        dfs(i+1, weight);

        if(weight+arr[i]<=15000){
            dfs(i+1, weight+arr[i]);
        }

        dfs(i+1,Math.abs(weight-arr[i]));
    }
}
