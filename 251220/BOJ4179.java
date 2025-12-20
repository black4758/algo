import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ4179 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        Queue<int[]> fireQ = new LinkedList<>();
        Queue<int[]> nowQ = new LinkedList<>();
        boolean[][] visited = new boolean[R][C];
        char[][] map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = input.charAt(j);
                if (map[i][j] == 'J') {
                    nowQ.add(new int[]{i, j,0});
                    visited[i][j] = true;
                }
                else if (map[i][j] == 'F') {
                    fireQ.add(new int[]{i, j});
                }
            }
        }
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!nowQ.isEmpty()) {
            int cnt =fireQ.size();
            for (int i = 0; i < cnt; i++) {
                int[] now = fireQ.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = now[0] + dx[j];
                    int ny = now[1] + dy[j];
                    if (nx >= 0 && ny >= 0 && nx < R && ny < C && map[nx][ny] =='.') {
                        map[nx][ny] ='F';
                        fireQ.add(new int[]{nx, ny});
                    }
                }
            }
             cnt =nowQ.size();
            for (int i = 0; i < cnt; i++) {
                int[] now = nowQ.poll();
                if(now[0]==0 || now[0]==R-1 || now[1]==0 || now[1]==C-1) {
                    System.out.println(now[2]+1);
                    return;
                }
                for(int j=0; j<4;j++){
                    int nx = now[0] + dx[j];
                    int ny = now[1] + dy[j];
                    if (nx >= 0 && ny >= 0 && nx < R && ny < C && !visited[nx][ny] && map[nx][ny]=='.') {
                        nowQ.add(new int[]{nx, ny,now[2]+1});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        System.out.println("IMPOSSIBLE");
    }
}
