import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BOJ2151_Dijkstra {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] map = new char[n][n];
        int[][][] arr = new int[n][n][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(arr[i][j], Integer.MAX_VALUE);
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->o1[3]-o2[3]);
        int[] dx={-1, 0, 1, 0};
        int[] dy={0, 1, 0, -1};
        boolean start = false;
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == '#' && !start) {
                    start = true;
                    for(int d=0; d<4; d++) {
                        arr[i][j][d] = 0;
                        pq.offer(new int[]{i, j, d, 0});
                    }
                    map[i][j] = '.';
                }
            }
        }
        while (!pq.isEmpty()) {

            int[] poll = pq.poll();
            if(map[poll[0]][poll[1]] == '#'){
                System.out.println(poll[3]);
                return;
            }
            if (arr[poll[0]][poll[1]][poll[2]] < poll[3]) {
                continue;
            }
            int nx = poll[0]+dx[poll[2]];
            int ny = poll[1]+dy[poll[2]];

            if(nx>=0 && ny>=0 && nx<n && ny<n && map[nx][ny] != '*') {

                if(map[nx][ny] == '!') {
                    int[] next = {(poll[2] + 1) % 4, (poll[2] + 3) % 4};
                    for(int now : next) {
                        if(arr[nx][ny][now]>poll[3]+1){
                            arr[nx][ny][now] = poll[3]+1;
                            pq.offer(new int[]{nx,ny,now,poll[3]+1});
                        }

                    }
                }
                if(arr[nx][ny][poll[2]]>poll[3]){
                    arr[nx][ny][poll[2]] = poll[3];
                    pq.offer(new int[]{nx,ny,poll[2],poll[3]});
                }

            }
        }
    }
}
