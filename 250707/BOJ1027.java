import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1027 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int max =0;
        for (int i = 1; i <= N; i++) {
            int cnt = 0;
            double now =Double.MAX_VALUE;
            for (int j = i-1; j > 0; j--) {
                double slope = (double) (arr[i] - arr[j]) / (i - j);
                if (slope < now) {
                    cnt++;
                    now = slope;
                }
            }
            now=-Double.MAX_VALUE;
            for (int j = i+1; j <= N; j++) {
                double slope = (double) (arr[i] - arr[j]) / (i - j);
                if (slope > now) {
                    cnt++;
                    now = slope;
                }
            }
            max = Math.max(max, cnt);
        }
        System.out.println(max);
    }
}
