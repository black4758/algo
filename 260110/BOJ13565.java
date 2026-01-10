package main.java._2026_01_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ13565 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int [][] map = new int[M][N];
        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = input.charAt(j) - '0';
                if(i==0 && map[i][j]==0) {
                    q.add(new int[] {i, j});
                    map[i][j] = -1;
                }
            }
        }
        while (!q.isEmpty()) {
            int [] now = q.poll();
            if(now[0]==M-1){
                System.out.println("YES");
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(nx>=0 && nx<M && ny>=0 &&ny<N &&map[nx][ny]==0) {
                    q.add(new int[] {nx, ny});
                    map[nx][ny] = -1;
                }
            }
        }
        System.out.println("NO");
        return;
    }
}
