import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14500 {
    static int N, M, ans = 0;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(1,i, j, map[i][j]);
                visited[i][j] = false;
                check(i, j);
            }
        }
        System.out.println(ans);
    }

    static void dfs(int cnt, int x, int y, int sum) {
        if (cnt == 4) {
            ans = Math.max(ans, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(cnt + 1,nx, ny, sum + map[nx][ny]);
                visited[nx][ny] = false;
            }
        }
    }

    static void check(int x, int y) {

        if (x + 1 < N && y - 1 >= 0 && y + 1 < M) {
            ans = Math.max(ans, map[x][y] + map[x + 1][y] + map[x][y - 1] + map[x][y + 1]);
        }

        if (x - 1 >= 0 && y - 1 >= 0 && y + 1 < M) {
            ans = Math.max(ans, map[x][y] + map[x - 1][y] + map[x][y - 1] + map[x][y + 1]);
        }

        if (x - 1 >= 0 && x + 1 < N && y + 1 < M) {
            ans = Math.max(ans, map[x][y] + map[x - 1][y] + map[x + 1][y] + map[x][y + 1]);
        }

        if (x - 1 >= 0 && x + 1 < N && y - 1 >= 0) {
            ans = Math.max(ans, map[x][y] + map[x - 1][y] + map[x + 1][y] + map[x][y - 1]);
        }
    }
}