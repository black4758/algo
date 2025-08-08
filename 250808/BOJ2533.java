import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ2533 {
    static List<Integer>[] list;
    static boolean[] visited;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        list=new List[N+1];
        for (int i = 1; i <= N; i++) {
            list[i]=new ArrayList<>();
        }
        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start =Integer.parseInt(st.nextToken());
            int end =Integer.parseInt(st.nextToken());
            list[start].add(end);
            list[end].add(start);
        }
        visited=new boolean[N+1];
        dp=new int[N+1][2];
        visited[1]=true;
        dfs(1);
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }
    static void dfs(int now){
        visited[now]=true;
        dp[now][0]=0;
        dp[now][1]=1;

        for(int next : list[now]){
            if(!visited[next]){
                dfs(next);
                dp[now][0]+=dp[next][1];
                dp[now][1]+=Math.min(dp[next][0], dp[next][1]);
            }
        }
    }
}
