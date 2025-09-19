import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ2660 {
    public static void main(String[] args) throws IOException {
        int INF = 1_000_000;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if(i==j) arr[i][j] = 0;
                else arr[i][j] = INF;
            }
        }
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a== -1 && b== -1) break;
            arr[a][b] = 1;
            arr[b][a] = 1;
        }
        for(int k=1; k<=N; k++){
            for(int i = 1; i <=N; i++){
                if(arr[i][k]==INF) continue;
                for(int j = 1; j <=N; j++){
                    if(arr[k][j]==INF) continue;
                    arr[i][j] = Math.min(arr[i][j], arr[i][k]+arr[k][j]);
                }
            }
        }
        int[] score = new int[N+1];
        int bestScore = INF;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if(arr[i][j] == INF) continue;
                score[i] = Math.max(score[i], arr[i][j]);
            }
            bestScore = Math.min(bestScore, score[i]);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if(score[i] == bestScore) list.add(i);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(bestScore).append(" ").append(list.size()).append('\n');
        for (int i : list) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);

    }
}
