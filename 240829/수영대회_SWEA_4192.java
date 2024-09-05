import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class 수영대회_SWEA_4192 {
    static int[][] map;
    static int[][] checked;
    static int N,an;
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    private static void bfs(int si, int sj, int ei, int ej) {
        checked=new int[N][N];
        
        Queue<Node> dq = new LinkedList();
        dq.add(new Node(si, sj));
        checked[si][sj]=1;
        while(!dq.isEmpty()) {
            Node now =dq.poll();
            if(now.x == ei && now.y  == ej) {
                an=checked[ei][ej]-1;
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                
                if(nx <0 || nx>= N || ny < 0 || ny>= N ) continue;
                
                
                if (map[nx][ny] == 0 && checked[nx][ny]==0) {
                    checked[nx][ny] =checked[now.x ][now.y]+1;
                    dq.add(new Node(nx, ny));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T =Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            an=-1;
            
            map = new int[N][N];
            
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    int a = Integer.parseInt(st.nextToken());
                    map[i][j] = a;
                }
            }
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            
            st = new StringTokenizer(br.readLine());
            int C = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
//             입력완료

            bfs(A, B, C, D );
            
            System.out.println("#"+tc+" "+an);
		}
        
    }
    static class Node{
        int x,y;

        public Node(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        } 
    }
}