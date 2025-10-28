import java.io.*;
import java.util.StringTokenizer;

public class BOJ9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][N];

            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] dp = new int[2][N];
            dp[0][0] = arr[0][0];
            dp[1][0] = arr[1][0];

            for (int j = 1; j < N; j++) {
                if (j == 1) {
                    dp[0][j] = arr[0][j] + dp[1][j - 1];
                    dp[1][j] = arr[1][j] + dp[0][j - 1];
                } else {
                    dp[0][j] = arr[0][j] + Math.max(dp[1][j - 1], Math.max(dp[0][j - 2], dp[1][j - 2]));
                    dp[1][j] = arr[1][j] + Math.max(dp[0][j - 1], Math.max(dp[0][j - 2], dp[1][j - 2]));
                }
            }

            sb.append(Math.max(dp[0][N - 1], dp[1][N - 1])).append("\n");
        }

        System.out.print(sb);
    }
}