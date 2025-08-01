import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10819 {
    static int [] arr ,nowArr;
    static int N;
    static boolean[] visited;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        arr = new int[N];
        nowArr = new int[N];
        visited = new boolean[N];
        ans = Integer.MIN_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        solution(0);
        System.out.println(ans);
    }
    static void solution(int cnt) {
        if (cnt == N) {
            int sum = 0;
            for (int i = 0; i < N-1; i++) {
                sum += Math.abs(nowArr[i]-nowArr[i+1]);
            }
            ans = Math.max(ans, sum);
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                nowArr[cnt] = arr[i];
                solution(cnt + 1);
                visited[i] = false;
            }
        }
    }
}

