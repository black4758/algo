import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ24230 {
    static int[] arr;
    static List <List <Integer>> list = new ArrayList<List <Integer>>();
    static int ans;
    static boolean [] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N =Integer.parseInt(br.readLine());
        arr = new int[N+1];
        visited = new boolean[N+1];
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        dfs(1, 0);
        System.out.println(ans);
    }
    public static void dfs(int start, int color){
        visited[start] = true;
        if (color != arr[start]){
            ans++;
        }
        for (int next : list.get(start)) {
            if (!visited[next]){
                dfs(next, arr[start]);
            }
        }
    }
}
