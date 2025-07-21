import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1106 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] arr= new int[C+102];
        Arrays.fill(arr,30000);
        arr[0] = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int customers = Integer.parseInt(st.nextToken());
            for (int j = customers; j < arr.length; j++) {
                arr[j]=Math.min(arr[j], arr[j-customers]+cost);
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = C; i < arr.length; i++) {
            ans = Math.min(ans, arr[i]);
        }
        System.out.println(ans);
    }
}
