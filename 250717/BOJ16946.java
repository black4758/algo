package main.java._2025_06_26;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ16946 {
    static char[][] map;
    static int[][] visited;
    static int [][] ans;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N,M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        ans = new int[N][M];
        visited = new int [N][M];
        HashMap<Integer,Integer> group = new HashMap<>();
        int id=1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == '0' && visited[i][j] == 0) {
                    group.put(id,bfs(i,j,id));
                    id++;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int cnt=1;
                if (map[i][j] == '1') {
                    Set<Integer> set = new HashSet<>();
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if(nx>=0 && nx<N && ny>=0 && ny<M && visited[nx][ny]!=0 ){
                            set.add(visited[nx][ny]);
                        }
                    }
                    for (int now : set) {
                        cnt+=group.get(now);
                    }
                    ans[i][j]=(cnt)%10;
                }

            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(ans[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    static int bfs(int x, int y,int id) {
       int cnt = 1;
        visited[x][y] = id;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        while (!q.isEmpty()) {
            int[] dir = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = dir[0] + dx[i];
                int ny = dir[1] + dy[i];
                if(nx>=0 && nx<N && ny>=0 && ny<M && visited[nx][ny]==0 && map[nx][ny] == '0') {
                    q.add(new int[]{nx, ny});
                    visited[nx][ny] = id;
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
