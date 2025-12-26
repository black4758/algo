import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1743 {
    static int[] dx ={1,-1,0,0};
    static int[] dy ={0,0,1,-1};
    static int n,m;
    static int [][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        arr = new int[n+1][m+1];
        for (int i = 0; i <k; i++) {
             st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = 1;
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(arr[i][j] == 1 ) {
                    int cnt = bfs(i,j);
                    ans = Math.max(ans,cnt);
                }
            }
        }
        System.out.println(ans);
    }
    public static int bfs(int x, int y) {
        int cnt=0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        arr[x][y] = -1;
        while (!q.isEmpty()) {
            cnt++;
            int[] cur = q.poll();
            for(int i=0;i<4;i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(nx>=1 && nx<=n && ny>=1 && ny<=m &&  arr[nx][ny]==1) {
                    q.add(new int[]{nx, ny});
                    arr[nx][ny] = -1;
                }
            }
        }
        return cnt;
    }
}
