import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ21736 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int [] dx ={1,-1,0,0};
        int [] dy ={0,0,1,-1};
        boolean[][] visited = new boolean[n][m];
        int[] start = new int[2];
        char[][] map = new char[n][m];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = input.charAt(j);
                if (map[i][j] == 'I') {
                    start[0] = i;
                    start[1] = j;
                    visited[i][j] = true;
                }
            }
        }
        int ans = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start[0],start[1]});
        while (!q.isEmpty()) {
            int[] now = q.poll();
            if (map[now[0]][now[1]] == 'P') {
                ans++;
            }
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<m && !visited[nx][ny] && map[nx][ny] != 'X') {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx,ny});
                }
            }
        }
        if(ans == 0) {
            System.out.println("TT");
        }
        else System.out.println(ans);
    }
}
