import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1445 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] map = new char[N][M];
        int[][][] nums = new int[N][M][2];
        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                nums[i][j][0] =Integer.MAX_VALUE;
                nums[i][j][1] =Integer.MAX_VALUE;
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1[2] == o2[2]) {
                return o1[3]-o2[3];
            }
            return o1[2] - o2[2];
        });
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] =input.charAt(j);
                if(map[i][j] == 'S') {
                    pq.add(new int[]{i, j,0,0});
                    nums[i][j][0] = 0;
                    nums[i][j][1] = 0;
                }
            }
        }
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,1,-1};
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            if(map[now[0]][now[1]] == 'F') {
                System.out.println(now[2] + " " + now[3]);
                return;
            }
//            if(nums[now[0]][now[1]][0]<now[2] || nums[now[0]][now[1]][0] == now[2] && nums[now[0]][now[1]][1] < now[3]) {
//                continue;
//            }
            if(visited[now[0]][now[1]]) {
                continue;
            }
            visited[now[0]][now[1]] = true;

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                int gnt=now[2],nextCnt=now[3];
                if(nx>=0 && ny>=0 && nx<N && ny<M) {
                    if (map[nx][ny] == 'g') {
                        gnt++;
                    } else if (map[nx][ny] != 'F') {
                        for (int k = 0; k < 4; k++) {
                            int kx = nx + dx[k];
                            int ky = ny + dy[k];
                            if (kx >= 0 && ky >= 0 && kx < N && ky < M && map[kx][ky] == 'g') {
                                nextCnt++;
                                break;
                            }
                        }
                    }
                    if(nums[nx][ny][0] >gnt ||nums[nx][ny][0] == gnt && nums[nx][ny][1]>nextCnt ){
                        nums[nx][ny][0] = gnt;
                        nums[nx][ny][1] = nextCnt;
                        pq.add(new int[]{nx,ny,gnt,nextCnt});
                    }
                }
            }
        }

    }
}
