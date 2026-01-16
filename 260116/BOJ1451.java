import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1451 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = input.charAt(j) - '0';
            }
        }

        long[][] sum = new long[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                sum[i][j] = sum[i - 1][j]
                        + sum[i][j - 1]
                        - sum[i - 1][j - 1]
                        + arr[i - 1][j - 1];
            }
        }

        long ans = 0;

        for (int i = 1; i < M - 1; i++) {
            for (int j = i + 1; j < M; j++) {
                long a = sum[N][i];
                long b = sum[N][j] - sum[N][i];
                long c = sum[N][M] - sum[N][j];
                ans = Math.max(ans, a * b * c);
            }
        }

        for (int i = 1; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                long a = sum[i][M];
                long b = sum[j][M] - sum[i][M];
                long c = sum[N][M] - sum[j][M];
                ans = Math.max(ans, a * b * c);
            }
        }

        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                long a = sum[N][i];
                long b = sum[j][M] - sum[j][i];
                long c = sum[N][M] - a - b;
                ans = Math.max(ans, a * b * c);
            }
        }

        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                long a = sum[j][i];
                long b = sum[N][i] - sum[j][i];
                long c = sum[N][M] - sum[N][i];
                ans = Math.max(ans, a * b * c);
            }
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                long a = sum[i][M];
                long b = sum[N][j] - sum[i][j];
                long c = sum[N][M] - a - b;
                ans = Math.max(ans, a * b * c);
            }
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                long a = sum[i][j];
                long b = sum[i][M] - sum[i][j];
                long c = sum[N][M] - sum[i][M];
                ans = Math.max(ans, a * b * c);
            }
        }

        System.out.println(ans);
    }
}
