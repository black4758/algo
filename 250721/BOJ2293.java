import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2293 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[k +1];
        arr[0] = 1;
        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(br.readLine());
            for (int j = now; j <= k; j++) {
                arr[j] = arr[j]+arr[j-now];
            }
        }
        System.out.println(arr[k]);
    }
}
