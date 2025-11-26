import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10942 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] input = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        boolean[][] dp = new boolean[N+1][N+1];
        for(int i = 1; i <= N; i++){
            dp[i][i] = true;
        }
        for(int i = 1; i < N; i++){
            if(input[i] == input[i+1]){
                dp[i][i+1] = true;
            }
        }
        for (int len = 3; len <= N; len++) {
            for (int i = 1; i + len - 1 <= N; i++) {
                int j = i + len - 1;
                if (input[i] == input[j] && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(dp[a][b]){
                sb.append("1\n");
            }
            else {
                sb.append("0\n");
            }
        }
        System.out.print(sb.toString().trim());
    }
}
