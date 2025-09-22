import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BOJ2665 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Position{
        int x;
        int y;
        int cost;
        public Position(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }
        PriorityQueue<Position> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        int[][] num = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(num[i], Integer.MAX_VALUE);
        }
        num[0][0] = 0;
//        boolean[][] visited = new boolean[n][n];
        pq.add(new Position(0, 0, 0));
        while (!pq.isEmpty()) {
            Position now = pq.poll();
//            if(visited[now.x][now.y]) {
//                continue;
//            }
//            visited[now.x][now.y] = true;
            if (num[now.x][now.y] > now.cost) {
                continue;
            }
            if (now.x == n - 1 && now.y == n - 1) {
                System.out.println(now.cost);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx>=0 && nx<n && ny>=0 && ny<n) {
                    int cost = now.cost;
                    if (map[nx][ny] ==0) {
                        cost+=1;
                    }
                    if(num[nx][ny] > cost) {
                        num[nx][ny] = cost;
                        pq.add(new Position(nx, ny, cost));
                    }
                }
            }
        }
        System.out.println(-1);
    }
}
