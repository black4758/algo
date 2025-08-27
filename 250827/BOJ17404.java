import java.io.*;
import java.util.*;

public class BOJ17404 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N+1][3];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }
        int ans =Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            int [][] dp = new int[N+1][3];
            Arrays.fill(dp[1], 1001*N);
            dp[1][i]=arr[1][i];

            for (int j = 2; j <= N; j++) {
                dp[j][0] = Math.min(dp[j-1][1], dp[j-1][2])+arr[j][0];
                dp[j][1] = Math.min(dp[j-1][0], dp[j-1][2])+arr[j][1];
                dp[j][2] = Math.min(dp[j-1][0], dp[j-1][1])+arr[j][2];
            }

            for (int j = 0; j < 3; j++) {
                if(i != j){
                    ans = Math.min(ans, dp[N][j]);
                }
            }
        }
        System.out.println(ans);
    }
}
