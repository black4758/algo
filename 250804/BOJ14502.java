import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14502 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N, M ,ans;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        ans = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0,0);
        System.out.println(ans);
    }
    static void dfs(int st,int cnt  ) {
        if (cnt == 3) {
            int total= bfs();
            ans=Math.max(ans,total);
            return;
        }
        for (int i = st; i < N*M; i++) {
            int x = i/ M;
            int y = i% M;

            if (map[x][y] == 0) {
                map[x][y] = 1;
                dfs(i+1,cnt + 1);
                map[x][y] = 0;
            }
        }
    }

    private static int bfs() {
        int cnt = 0;
        boolean[][] visited = new boolean[N][M];
        Queue<Position> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    visited[i][j] = true;
                    cnt++;
                }
                else if (map[i][j] == 2) {
                    q.add(new Position(i, j));
                    visited[i][j] = true;
                    cnt++;
                }
            }
        }
        while (!q.isEmpty()) {
            Position now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(nx>=0 && nx<N && ny>=0 && ny<M && !visited[nx][ny]) {
                    visited[nx][ny]=true;
                    cnt++;
                    q.add(new Position(nx, ny));
                }
            }
        }

        return N*M-cnt;
    }

    static class Position {
        int x, y;
        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
