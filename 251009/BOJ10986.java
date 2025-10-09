import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] arr = new long[M];
        long sum = 0;
        long ans = 0;
        arr[0] = 1;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sum += Integer.parseInt(st.nextToken());
            arr[(int)sum%M]++;
        }
        for (int i = 0; i < M; i++) {
            long cnt = arr[i];
            if (cnt >=2) {
                ans += cnt * (cnt - 1) / 2;
            }
        }
        System.out.println(ans);
    }
}
