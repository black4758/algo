package main.java._2025_12_17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ5427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            char[][] map = new char[h][w];
            Queue<int[]> q = new ArrayDeque<>();
            Queue<int[]> fireQ = new ArrayDeque<>();
            boolean[][] visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                String input = br.readLine();
                for (int j = 0; j < w; j++) {
                    map[i][j] = input.charAt(j);
                    if (map[i][j] == '@') {
                        q.add(new int[] {i, j,1});
                        visited[i][j] = true;
                    }
                    if (map[i][j] == '*') {
                        fireQ.add(new int[] {i, j});
                    }
                }
            }
            boolean flag = false;
            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};
            while (!q.isEmpty()) {
                int size = fireQ.size();
                for (int i = 0; i < size ; i++) {
                    int[] fire = fireQ.poll();
                    for (int j = 0; j < 4; j++) {
                        int nx = fire[0] + dx[j];
                        int ny = fire[1] + dy[j];
                        if (nx >= 0 && ny >= 0 && nx < h && ny < w) {
                            if (map[nx][ny] == '@' || map[nx][ny] == '.') {
                                map[nx][ny] = '*';
                                fireQ.add(new int[] {nx, ny});
                            }
                        }
                    }
                }
                size=q.size();
                for (int k = 0; k < size; k++) {
                    int[] now = q.poll();
                    if (now[0]==0 || now[1]==0 || now[0]==h-1 || now[1]==w-1) {
                        flag = true;
                        sb.append(now[2]).append("\n");
                        break;
                    }
                    for (int i = 0; i < 4; i++) {
                        int nx = now[0] + dx[i];
                        int ny = now[1] + dy[i];
                        if(nx>=0 && nx< h && ny>=0 && ny< w && !visited[nx][ny] && map[nx][ny] == '.') {
                            visited[nx][ny] = true;
                            q.add(new int[] {nx, ny, now[2]+1});
                        }
                    }
                }
                if (flag) {
                    break;
                }
            }
            if (!flag) {
                sb.append("IMPOSSIBLE").append("\n");
            }
        }
        System.out.print(sb);
    }
}
