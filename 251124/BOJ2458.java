import java.io.*;
import java.util.*;

public class BOJ2458 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int INF = 1_000_000_000;
        int [][]arr = new int[N+1][N+1];
        for(int i=0;i<=N;i++){
            Arrays.fill(arr[i],INF);
            arr[i][i]=0;
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            arr[A][B]=1;
        }
        for(int k = 1; k <=N; k++){
            for(int i = 1; i <=N; i++){
                for(int j = 1; j <=N; j++){
                    if(arr[i][j]>arr[i][k]+arr[k][j]){
                        arr[i][j]=arr[i][k]+arr[k][j];
                    }
                }
            }
        }
        int ans=0;
        for(int i=1;i<=N;i++){
            int cnt=0;
            for(int j=1;j<=N;j++){
                if(i==j) continue;
                if(arr[i][j]!=INF || arr[j][i] !=INF) cnt++;
            }
            if(cnt==N-1){
                ans++;
            }
        }
        System.out.println(ans);

    }
}
