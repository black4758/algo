import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10451 {
    static int[] arr;
    static boolean[] visited;
    static int ans;
    static StringBuffer sb = new StringBuffer();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            ans = 0;
            arr = new int[N+1];
            visited = new boolean[N+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 1; i <= N; i++) {
                if (!visited[i]) {
                    dfs(i);
                    ans++;
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
    static void dfs(int i) {
        visited[i] = true;
        int next = arr[i];
        if (!visited[next]) {
            dfs(next);
        }
    }
}
