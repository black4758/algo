import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ30221 {
    static class Edge {
        int from;
        int to;
        int cost;
        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int [] arr = new int[n + 1];
        List<Edge> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            char color = st.nextToken().charAt(0);
            int cost = Integer.parseInt(st.nextToken());
            if (color == 'r') {
                list.add(new Edge(from, to, -cost));
            }
            else {
                list.add(new Edge(from, to, cost));
            }
        }
        Arrays.fill(arr, 100_000_000);
        arr[1] = 0;
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for(Edge now : list) {
                if (arr[now.to]>arr[now.from]+now.cost) {
                    arr[now.to] = arr[now.from]+now.cost;
                    flag = true;
                }
            }
            if(!flag){
                break;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (arr[i] < 0) {
                ans.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for( int i :ans){
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }
}
