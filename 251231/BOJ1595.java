import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1595 {
    static List<int[]> list[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        list = new List[10001];
        for (int i = 0; i < 10001; i++) {
            list[i] = new ArrayList<int[]>();
        }
        String line;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            StringTokenizer st = new StringTokenizer(line);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new int[]{b, c});
            list[b].add(new int[]{a, c});

        }
        int[] first = bfs(1);
        int [] ans = bfs(first[0]);
        System.out.println(ans[1]);

    }
    public static int[] bfs(int a) {
        boolean[] visited = new boolean[10001];
        Queue<int[]> q = new LinkedList<>();
        visited[a] = true;
        int[] ans = new int[2];
        q.add(new int[]{a, 0});
        while (!q.isEmpty()) {
            int[] now = q.poll();
            if(ans[1] <now[1]){
                ans[0] = now[0];
                ans[1] = now[1];
            };
            for (int[] next :list[now[0]]) {
                if (!visited[next[0]]) {
                    visited[next[0]] = true;
                    q.add(new int[]{next[0], now[1]+next[1]});
                }
            }
        }
        return ans;
    }
}
