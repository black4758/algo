import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ16932 {
    static int[] dx ={1,-1,0,0};
    static int[] dy ={0,0,1,-1};
    static int N, M;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Map<Integer,Integer> map=new HashMap<>();
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = 0;
        int num=2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1) {
                    map.put(num,bfs(i,j,num++));
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    sum = 0;
                    set.clear();
                    for (int k = 0; k < 4; k++) {
                        int x = i + dx[k];
                        int y = j + dy[k];
                        if (x >= 0 && x < N && y >= 0 && y < M) {
                            if (arr[x][y] != 0) {
                                if(!set.contains(arr[x][y])) {
                                    sum += map.get(arr[x][y]);
                                    set.add(arr[x][y]);
                                }
                            }
                        }
                    }
                    ans = Math.max(ans,sum+1);
                }
            }
        }
        System.out.println(ans);
    }
    public static int bfs(int x, int y,int num) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x, y});
        arr[x][y] = num;
        int cnt = 0;
        while (!q.isEmpty()) {
            int[] now =q.poll();
            cnt++;
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(nx>=0 && nx<N && ny>=0 && ny<M && arr[nx][ny] == 1) {
                    arr[nx][ny] = num;
                    q.add(new int[]{nx, ny});
                }
            }
        }
        return cnt;
    }
}
