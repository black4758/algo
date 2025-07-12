import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1987 {
    static char[][] map;
    static int[] dx={1,-1,0,0};
    static int[] dy={0,0,1,-1};
    static int R,C = 0;
    static boolean [] visited;
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j) ;
            }
        }
        visited =new boolean[26];
        dfs(0,0,1);
        System.out.println(ans);
    }
    static void dfs(int x, int y,int cnt) {
        visited[map[x][y]-'A'] = true;
        ans=Math.max(ans, cnt);
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if(nx>=0 && nx<R && ny>=0 && ny<C && !visited[map[nx][ny]-'A']) {
                dfs(nx,ny,cnt+1);
            }
        }
        visited[map[x][y]-'A'] = false;
    }
}
