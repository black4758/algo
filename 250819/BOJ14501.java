import java.io.*;
import java.util.*;

public class BOJ14501 {
    static int N,ans;
    static int[] T,P;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        T = new int[N];
        P = new int[N];
        ans = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0,0);
        System.out.println(ans);
    }
    private static void dfs(int cnt, int sum) {
        if(cnt>=N){
            ans=Math.max(ans,sum);
            return;
        }
        if(cnt+T[cnt]<=N){
            dfs(cnt+T[cnt],sum+P[cnt]);
        }
        dfs(cnt+1,sum);
    }
}
