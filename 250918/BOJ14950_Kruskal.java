import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ14950_Kruskal {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        List<int[]> list = new ArrayList<>();
        arr = new int[N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list.add(new int[] { start, end, cost });
        }
        int ans = 0;
        int cnt = 0;
        list.sort((o1, o2) -> o1[2] - o2[2]);
        for(int[] now : list) {
            if(union(now[0], now[1])){
                ans+=now[2]+cnt*t;
                if (++cnt == N-1) {
                    break;
                }
            }
        }
        System.out.println(ans);
    }
    static boolean union(int a, int b) {
        int rootA=find(a);
        int rootB=find(b);
        if(rootA==rootB) {
            return false;
        }
        arr[rootB]=rootA;
        return true;
    }
    static int find(int x){
        if (arr[x] == 0) {
            return x;
        }
        return arr[x]=find(arr[x]);
    }
}
