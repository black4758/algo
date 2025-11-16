import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11403  {
    static int[][] map;
    static boolean[] visited;
    static int[][] ans;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        ans = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            dfs(i,i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(ans[i][j]).append(" ");
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
    static void dfs(int start, int node) {
        for (int next = 0; next < N; next++) {
            if (map[node][next] == 1 && !visited[next]) {
                visited[next] = true;
                ans[start][next] = 1;
                dfs(start, next);
            }
        }
    }
}
