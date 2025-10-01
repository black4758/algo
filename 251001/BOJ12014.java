import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ12014 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= Tc; t++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int len =0;
            int[] dp = new int[N];
            for (int i = 0; i < N; i++) {
                int pos = Arrays.binarySearch(dp,0,len, arr[i]);
                if (pos < 0) { pos = -pos - 1; }
                dp[pos] = arr[i];
                if (pos == len) {
                    len++;
                }
            }
            sb.append("Case #").append(t).append("\n");
            sb.append(len >= K ? 1 : 0).append("\n");
        }
        System.out.println(sb);
    }
}
