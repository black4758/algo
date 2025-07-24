import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int sum=0;
        // 처음: 0부터 K 전까지 더함
        for (int i = 0; i < K; i++) {
            sum+=arr[i];
        }
        int ans=sum;

        // 계산 한것에서 맨처음 걸 빼고 새로운 것을 넣은뒤 기존 값이랑 비교
        //슬라이딩 윈도우 구현
        for (int i = 0; i < N-K; i++) {
            sum=sum-arr[i]+arr[K+i];
            ans=Math.max(ans,sum);
        }
        System.out.println(ans);
    }
}
