import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17610 {
    static int K;
    static int[] weights;         // 추 무게 배열
    static boolean[] possible;    // 가능한 무게 표시
    static int sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K=Integer.parseInt(br.readLine());
        weights = new int[K];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
            sum += weights[i];
        }
        possible = new boolean[sum+1];
        dfs(0, 0);
        int ans = 0;
        for (int i = 1; i <=sum; i++) {
            if (!possible[i]) {
                ans++;
            }
        }
        System.out.println(ans);
    }
    static void dfs(int cnt, int now) {
        if (cnt == K) {
            if(now>=0 && now<=sum){
                possible[now] = true;
            }
            return;
        }
        dfs(cnt+1, now);
        dfs(cnt+1, now+weights[cnt]);
        dfs(cnt+1, Math.abs(now-weights[cnt]));
    }
}
