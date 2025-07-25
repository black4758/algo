import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11660 {
    public static void main(String[] args)  throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map =new int [N+1][N+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                // (i, j)는 (1,1)부터 (i,j)까지의 누적합
                // 위쪽(i-1, j) + 왼쪽(i, j-1) - 겹치는 부분(i-1, j-1) + 현재 값
                map[i][j] = map[i-1][j]+map[i][j-1] - map[i-1][j-1] +Integer.parseInt(st.nextToken());
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1= Integer.parseInt(st.nextToken());
            int y1= Integer.parseInt(st.nextToken());
            int x2= Integer.parseInt(st.nextToken());
            int y2= Integer.parseInt(st.nextToken());
            // 전체(x2, y2)에서 위쪽(x1-1, y2)과 왼쪽(x2, y1-1)을 빼고
            // 두 번 빠진 겹치는 부분(x1-1, y1-1)을 더해줌
            int ans=map[x2][y2]-map[x1-1][y2]-map[x2][y1-1]+map[x1-1][y1-1];
            sb.append(ans).append("\n");

        }
        System.out.println(sb);


    }
}
