import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2589 {
    static int[] dx={1,-1,0,0};
    static int[] dy={0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        char[][] map = new char[L][W];
        for (int i = 0; i < L; i++) {
            String input = br.readLine();
            for (int j = 0; j < W; j++) {
                map[i][j] = input.charAt(j);
            }
        }
        int[][] visited = new int[L][W];
        int ans = 0;
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < W; j++) {
                if (map[i][j] == 'L') {
                    for (int z = 0; z < L; z++) {
                        Arrays.fill(visited[z], Integer.MAX_VALUE);
                    }
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i,j});
                    visited[i][j] = 0;
                    while (!q.isEmpty()) {
                        int[] now = q.poll();
                        for (int k = 0; k < 4; k++) {
                            int nx = now[0] + dx[k];
                            int ny = now[1] + dy[k];
                            if(nx >= 0 && ny >= 0 && nx < L && ny < W) {
                                if(map[nx][ny] == 'L'){
                                    if(visited[nx][ny] > visited[now[0]][now[1]]+1){
                                        q.add(new int[]{nx,ny});
                                        visited[nx][ny] = visited[now[0]][now[1]] + 1;
                                        ans=Math.max(ans,visited[nx][ny]);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
