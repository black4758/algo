import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ15683 {
    static int N, M;
    static int[][] map;
    static ArrayList<int[]> list = new ArrayList<>();
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int ans = Integer.MAX_VALUE;

    static int[][][] dir = {
            {},
            {{0}, {1}, {2}, {3}},
            {{0, 2}, {1, 3}},
            {{0, 1}, {1, 2}, {2, 3}, {3, 0}},
            {{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}},
            {{0, 1, 2, 3}}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0 && map[i][j] != 6) {
                    list.add(new int[]{i, j,map[i][j]});
                }
            }
        }
        check(0,map);
        System.out.println(ans);
    }
    private static void check(int cnt, int[][] newMap) {
        if (cnt == list.size()) {
            ans=Math.min(ans,count(newMap));
            return;
        }
        int[] now =list.get(cnt);
        for(int[] next : dir[now[2]]) {
            int [][] copy = new int[N][M];
            for (int i = 0; i < N; i++) {
                copy[i] = newMap[i].clone();
            }
            for(int d : next){
                watch(copy,now[0],now[1],d);
            }
            check(cnt+1,copy);
        }
    }
    static void watch(int[][] map, int x, int y, int d) {
        int nx = x + dx[d];
        int ny = y + dy[d];

        while (nx >= 0 && ny >= 0 && nx < N && ny < M) {
            if (map[nx][ny] == 6) break;
            if (map[nx][ny] == 0) map[nx][ny] = -1;
            nx += dx[d];
            ny += dy[d];
        }
    }
    static int count(int[][] map) {
        int cnt = 0;
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) cnt++;
            }
        }

        return cnt;
    }
}
