import java.io.*;
import java.util.*;

public class BOJ15486 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] t=new int[N+1];
        int[] p=new int[N+1];
        int[] dp = new int[N+2];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }
        int max =0;
        for (int i = 1; i <= N; i++) {
            max =Math.max(max, dp[i]);
            int next=i+t[i];
            if(next<=N+1){
                dp[next]=Math.max(dp[next],max+p[i]);
            }
        }
        max =Math.max(max,dp[N+1]);
        System.out.println(max);
    }
}
