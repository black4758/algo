import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16929 {
    static int N, M;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    dfs(i,j,-1,-1);
                }
                if(flag){
                    System.out.println("Yes");
                    return;
                }
            }
        }
        System.out.println("No");
    }
    public static void dfs(int x, int y, int tempX,int tempY) {
        visited[x][y] = true;
        if (flag) return;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx==tempX && ny==tempY) {
                continue;
            }
            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                if (map[nx][ny] == map[x][y]) {
                    if (visited[nx][ny]) {
                        flag=true;
                        return;
                    }
                    dfs(nx, ny,x,y);
                }

            }
        }
    }
}
