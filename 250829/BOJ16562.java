import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16562 {
    static int[] arr,cost;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());
        arr = new int[N+1];
        cost = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) {
            arr[i] = i;
            cost[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }
        boolean[] visited = new boolean[N+1];
        long ans = 0;
        for(int i=1;i<=N;i++) {
            int root =find(i);
            if(!visited[root]) {
                ans+=cost[root];
                visited[root] = true;
            }
        }
        if(ans<=K){
            System.out.println(ans);
        }
        else {
            System.out.println("Oh no");
        }

    }
    static int find(int x){
        if(arr[x] == x){
            return x;
        }
        return arr[x] = find(arr[x]);
    }
    static void union(int a, int b) {
        int arrA=find(a);
        int arrB=find(b);
        if(arrA != arrB){
            arr[arrB] = arrA;
            cost[arrA] =Math.min(cost[arrA],cost[arrB]);
        }
    }

}
