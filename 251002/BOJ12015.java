import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ12015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int len=0;
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            int pos = Arrays.binarySearch(dp,0,len, arr[i]);
            if (pos < 0) { pos = -pos - 1; }
            dp[pos] = arr[i];
            if (pos == len) {
                len++;
            }
        }
        System.out.println(len);
    }
}
