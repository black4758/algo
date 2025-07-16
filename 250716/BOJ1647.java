import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1647 {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        int ans = 0;
        int last = 0;
        Edge [] edge = new Edge[M];
        for (int i =0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            edge[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(edge,((o1, o2) -> o1.cost - o2.cost));
        int cnt = 0;
        for(Edge now : edge){
            if(union(now.start, now.end )){
                ans+=now.cost;
                last = now.cost;
                cnt++;
            }
            if(cnt == N-1) break;
        }
        System.out.println(ans-last);
    }
    static int finde(int x){
        if(arr[x] == 0)
            return x;
        return arr[x]=finde(arr[x]);
    }

    static boolean union(int x,int y){
        int rootX = finde(x);
        int rootY = finde(y);
        if(rootX == rootY){
            return false;
        }
        arr[rootY]=rootX;
        return true;
    }
    static class Edge{
        int start, end, cost;
        Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
}
