import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9466 {
    static int[] arr;
    static boolean[] visited;
    static boolean[] cycle;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T= Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            ans = 0;
            arr = new int[n+1];
            visited = new boolean[n+1];
            cycle = new boolean[n+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 1; i <= n; i++) {
                if(!visited[i]) {
                    dfs(i);
                }
            }
            System.out.println(n-ans);
        }
    }
    private static void dfs(int i) {
        visited[i] = true;
        int next = arr[i];
        if(!visited[next]) {
            dfs(next);
        }
        else {
            if(!cycle[next]) {
                ans++;
                while(next !=i){
                    next =arr[next];
                    ans++;
                }
            }
        }
        cycle[i] = true;
    }
}
