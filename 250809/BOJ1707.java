import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1707 {
    static ArrayList<Integer>[] list;
    static int[] visited;
    static boolean ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            list = new ArrayList[V+1];
            visited = new int[V+1];
            ans = false;
            for (int i = 1; i <= V; i++) {
                list[i] = new ArrayList<>();
            }
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                list[start].add(end);
                list[end].add(start);
            }
            for (int i = 1; i <= V; i++) {
                if (visited[i] == 0) {
                    dfs(i,1);
                    if (ans) {
                        sb.append("NO\n");
                        break;
                    }
                }
            }
            if (!ans){
                sb.append("YES\n");
            }
        }
        System.out.println(sb);
    }
    private static void dfs(int n, int state) {
        visited[n] = state;
        for(int i : list[n]) {
            if (visited[i] == 0) {
                dfs(i,state*-1);
            }
            if (visited[i] == state) {
                ans = true;
            }
        }
    }
}
