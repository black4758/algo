import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[N];
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            long ans = 0;
            int max = 0;
            for (int j=N-1; j>=0; j--) {
                if(arr[j] > max) {
                    max = arr[j];
                }
                else {
                    ans+=max-arr[j];
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
