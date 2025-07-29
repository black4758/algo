import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2473 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int  N = Integer.parseInt(br.readLine());
        long [] arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);
        long minSum =Long.MAX_VALUE;
        long[] ans = new long[3];
        for (int i = 0; i < N-2; i++) {
            int start = i+1;
            int end = N-1;
            while (start < end) {
                long nowSum = arr[start] + arr[i] + arr[end];
                if (Math.abs(nowSum) < Math.abs(minSum)) {
                    minSum = nowSum;
                    ans[0] = arr[i];
                    ans[1] = arr[start];
                    ans[2] = arr[end];
                }
                else if ( nowSum <0 ) {
                    start++;
                }
                else if (nowSum >0) {
                    end--;
                }
                else {
                    System.out.println(ans[0]+" "+ans[1]+" "+ans[2]);
                    return;
                }
            }
        }
        System.out.println(ans[0]+" "+ans[1]+" "+ans[2]);
    }

}
