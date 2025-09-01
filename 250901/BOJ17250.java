import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17250 {
    static int[] dp,cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        dp= new int[N+1];
        cnt = new int[N+1];
        for (int i = 1; i <= N; i++) {
            cnt[i] = Integer.parseInt(br.readLine());
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(union(a,b)).append("\n");
        }
        System.out.println(sb);
    }
    static int find (int x){
        if(dp[x]==0){
            return x;
        }
        return dp[x]= find(dp[x]);
    }
    static int union (int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA!=rootB){
            dp[rootB]=rootA;
            cnt[rootA]+=cnt[rootB];
        }
        return cnt[rootA];
    }
}
