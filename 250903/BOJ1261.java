import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1261 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] map=new int [N][M];
        int[][] visited=new int [N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], Integer.MAX_VALUE);
        }
        Queue<int[]> q = new ArrayDeque<>();
        visited[0][0]=0;
        q.add(new int[]{0,0,0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(nx>=0 && nx<N && ny>=0 && ny<M){
                    if(map[nx][ny]==0){
                        if (visited[nx][ny] > cur[2]) {
                            visited[nx][ny] = cur[2];
                            q.add(new int[]{nx, ny, cur[2]});
                        }
                    }
                    else{
                        if(visited[nx][ny]>cur[2]+1){
                            visited[nx][ny]=cur[2]+1;
                            q.add(new int[]{nx,ny,cur[2]+1});
                        }
                    }
                }
            }
        }
        System.out.println(visited[N-1][M-1]);
    }
}
