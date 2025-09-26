import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[N];
        int length=0;
        for (int i = 0; i < N; i++) {
            int pos =Arrays.binarySearch(dp,0,length,arr[i]);
            if (pos < 0) pos = -(pos+1);
            dp[pos]=arr[i];
            if (pos == length) length++;
        }

        System.out.println(length);
    }
}
