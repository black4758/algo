import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ11559 {
    static int[] dx ={1,-1,0,0};
    static int[] dy ={0,0,1,-1};
    static char[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[12][6];
        for (int i = 0; i < 12; i++) {
            String input = br.readLine();
            for (int j = 0; j < 6; j++) {
                map[i][j] = input.charAt(j);
            }
        }
        int ans=0;
        while (true) {
            boolean flag = false;
            visited = new boolean[12][6];
             for (int i=0; i<12; i++) {
                 for (int j=0; j<6; j++) {
                     if (map[i][j] != '.' && !visited[i][j]) {
                         if (bfs(i,j)){
                             flag = true;
                         }
                     }
                 }
             }
            if (!flag) {
                break;
            }
            ans++;
            gravity();
        }
        System.out.println(ans);
    }
    public static boolean bfs(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        Queue<int[]> ans = new ArrayDeque<>();
        char color = map[x][y];
        visited[x][y] = true;
        q.add(new int[]{x,y});
        ans.add(new int[]{x,y});
        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int i=0;i<4;i++){
                int nx = now[0]+dx[i];
                int ny = now[1]+dy[i];
                if(nx>=0 && nx<12 && ny>=0 && ny<6 && !visited[nx][ny] && map[nx][ny]==color){
                    visited[nx][ny] = true;
                    q.add(new int[]{nx,ny});
                    ans.add(new int[]{nx,ny});
                }
            }
        }
        if (ans.size() >=4){
            for(int[] next : ans){
                map[next[0]][next[1]]='.';
            }
            return true;
        }
        return false;
    }
    public static void gravity(){
        for (int i = 0; i < 6; i++) {
            int now=11;
            for (int j = 11; j >=0 ; j--) {
                if (map[j][i] != '.') {
                    if (now != j) {
                        map[now][i] = map[j][i];
                        map[j][i] = '.';
                    }
                    now--;
                }
            }
        }
    }
}
