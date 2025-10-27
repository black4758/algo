import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ11725 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        int[] ans = new int[n+1];
        queue.add(1);
        visited[1] = true;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for(int next: list.get(cur)) {
                if (!visited[next]) {
                    visited[next] = true;
                    ans[next] = cur;
                    queue.add(next);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i =2; i<=n; i++) {
            sb.append(ans[i]).append("\n");
        }
        System.out.print(sb.toString().trim());

    }
}
