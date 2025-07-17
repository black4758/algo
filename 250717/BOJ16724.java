package main.java._2025_06_26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16724 {
    static char[][] map;
    static int[][] visited;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new int[N][M];
        ans = 0;

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        int id=1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(visited[i][j]==0) {
                    solution(i,j,id);
                    id++;
                }
            }
        }
        System.out.println(ans);
    }
    static void solution(int x,int y,int id){
        int nx=x;
        int ny=y;
        while(true) {
            if(visited[nx][ny]!=0) {
                if(visited[nx][ny]==id) {
                    ans++;
                }
                return;
            }
            visited[nx][ny] = id;

            char dir=map[nx][ny];
            if(dir == 'D') {
                nx++;
            }
            else if(dir == 'U') {
                nx--;
            }
            else if(dir == 'L') {
                ny--;
            }
            else if(dir == 'R') {
                ny++;
            }
        }

    }
}
