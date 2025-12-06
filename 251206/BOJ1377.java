import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1377 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            arr[i][0] = Integer.parseInt(br.readLine());
            arr[i][1] = i;
        }
        Arrays.sort(arr,(o1,o2)->o1[0]-o2[0]);
        int ans = 0;
        for (int i = 0; i < N; i++) {
            int now = arr[i][1]-i;
            ans= Math.max(ans,now);
        }
        System.out.println(ans+1);
    }
}
