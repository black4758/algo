import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2636 {
    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int [][] map = new int[n][m];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    cnt++;
                }
            }
        }
        int pCnt=0;
        int tCnt=0;
        Queue<Node> q = new LinkedList<>();
        while (cnt !=0) {
            boolean[][] visited = new boolean[n][m];
            q.add(new Node(0, 0));
            pCnt=cnt;
            while (!q.isEmpty()) {
                Node now = q.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];
                    if(nx>=0 && nx<n && ny>=0 && ny<m && !visited[nx][ny]) {
                        visited[nx][ny]=true;
                        if(map[nx][ny]==0) {
                            q.add(new Node(nx, ny));
                        }
                        else if(map[nx][ny]==1) {
                            map[nx][ny]=-1;
                        }

                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == -1) {
                        map[i][j]=0;
                        cnt--;
                    }
                }
            }
            tCnt++;

        }
        System.out.println(tCnt);
        System.out.println(pCnt);
    }
}
