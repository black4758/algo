import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            int[] apt = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                apt[i] = i;
            }
            for (int i = 1; i <= k; i++) {
                int[] arr = new int[n + 1];
                for (int j = 1; j <= n; j++) {
                    int sum = 0;
                    for (int z = 1; z <= j; z++) {
                        sum += apt[z];
                    }
                    arr[j] = sum;
                }
                apt = arr;
            }
            sb.append(apt[n]).append("\n");
        }
        System.out.println(sb);
    }
}
