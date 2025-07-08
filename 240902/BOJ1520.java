import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1520 {
    static int[][] map;
    static int[][] dp;
    static int M,N;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        dp = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
        System.out.println(dfs(0, 0));
    }
    private static int dfs(int r, int c) {
        if ((r == M - 1)&&(c == N - 1)) {
            return 1;
        }
        if (dp[r][c] != -1) {
            return dp[r][c];
        }
        dp[r][c] = 0;
        for (int i = 0; i < 4; i++) {
            int nx=r+dx[i];
            int ny=c+dy[i];
            if (nx>=0&&ny>=0&&nx<M&&ny<N) {
                if (map[nx][ny] <map[r][c]) {
                    dp[r][c] +=dfs(nx,ny);
                }
            }
        }
        return dp[r][c];
    }
}
