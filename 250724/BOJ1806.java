import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int start=0;
        int end=0;
        int sum=0;
        int ans=Integer.MAX_VALUE;
        while (end < N) {
            if (sum < S) {
                sum += arr[end++];
            }
            while (sum>=S){
                ans=Math.min(ans, end - start);
                sum-=arr[start++];
            }
        }
        if (ans == Integer.MAX_VALUE) {
            System.out.println(0);
        }
        else
            System.out.println(ans);
    }
}
