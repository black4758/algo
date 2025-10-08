import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1240 {
    static List<List<int[]>> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list.get(start).add(new int[]{end, cost});
            list.get(end).add(new int[]{start, cost});
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            boolean[] visitet = new boolean[N+1];
            sb.append(dfs(start,end,0,visitet)).append("\n");
        }
        System.out.println(sb);
    }
    private static int dfs(int start, int end,int cost,boolean[] visitet) {
        if (start == end) {
            return cost;
        }
        visitet[start] = true;
        for(int[] now :list.get(start)) {
            if (!visitet[now[0]]) {
                int ans =dfs(now[0],end,cost+now[1],visitet);
                if (ans != -1) {
                    return ans;
                }
            }
        }
        return -1;
    }
}
