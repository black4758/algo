package main.java._2025_06_26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map=new int[n][m];
        int[][] ans=new int[n][m];
        int[] dx={-1, 0, 1, 0};
        int[] dy={0, -1, 0, 1};
        Queue<Position> q=new LinkedList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    q.add(new Position(i, j));
                    ans[i][j]=0;
                }
                else if (map[i][j] == 0) {
                    ans[i][j]=0;
                }
                else ans[i][j]=-1;
            }
        }
        while (!q.isEmpty()) {
            Position now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<m && ans[nx][ny]==-1) {
                    ans[nx][ny]=ans[now.x][now.y]+1;
                    q.add(new Position(nx,ny));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(ans[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
    static class Position{
        int x;
        int y;
        public Position(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
