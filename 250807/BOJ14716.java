import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14716 {
    static int[] dx={1, -1, 0, 0, -1, -1, 1,1};
    static int[] dy={0, 0,- 1, 1, 1, -1, -1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] map = new int[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Queue<int[]> q = new LinkedList<>();
        int cnt = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    map[i][j]=-1;
                    q.add(new int[] {i, j});
                    while (!q.isEmpty()) {
                        int[] now = q.poll();
                        for (int k = 0; k < 8; k++) {
                            int nx = now[0] + dx[k];
                            int ny = now[1] + dy[k];
                            if (nx >= 0 && ny >= 0 && nx < M && ny < N && map[nx][ny] == 1) {
                                map[nx][ny]=-1;
                                q.add(new int[] {nx, ny});
                            }
                        }
                    }
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
