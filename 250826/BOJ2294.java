import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2294 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int [] dp = new int[k+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int now : arr){
            for(int i = now; i <= k; i++){
                if(dp[i-now] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i], dp[i-now] + 1);
                }
            }
        }
        if(dp[k] != Integer.MAX_VALUE){
            System.out.println(dp[k]);
        }
        else {
            System.out.println(-1);
        }
        return;
    }
}
