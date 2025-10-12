import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1509 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int N = input.length();

        boolean[][] visited = new boolean[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            visited[i][i] = true;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 1; j+i-1 <= N; j++) {
                int num =i+j-1;
                if (input.charAt(j-1) == input.charAt(num-1)) {
                    if (i==2 || visited[j+1][num-1]) {
                        visited[j][num] = true;
                    }
                }
            }
        }
        int[] dp = new int[N+1];
        for (int i = 1; i <= N; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j <= i; j++) {
                if(visited[j][i]) {
                    dp[i] = Math.min(dp[i], dp[j-1] + 1);
                }
            }
        }
        System.out.println(dp[N]);

    }
}
