import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ18405 {
    public static void main(String[] args) throws IOException {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) ->
        {
                    if (o1[3] != o2[3]){
                        return o1[3] - o2[3];
                    }
                    return o1[2] - o2[2];
        });
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0) {
                    pq.add(new int[]{i, j,map[i][j],0});
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        while(!pq.isEmpty()) {
            int[] now = pq.poll();
            if(now[3]==S) {
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                    if(nx>=0 && ny<N && ny>=0 && nx<N) {
                        if(map[nx][ny] == 0) {
                            pq.add(new int[]{nx, ny, now[2],now[3]+1});
                            map[nx][ny] = now[2];
                        }
                    }
                }
            }
        System.out.println(map[X-1][Y-1]);
        }
    }

