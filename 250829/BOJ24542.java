import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ24542 {
    static int[] arr,cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        cnt = new int[N+1];
        for (int i = 1; i <= N; i++) {
            arr[i]=i;
            cnt[i]=1;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        long ans = 1;
        for (int i = 1; i <= N; i++) {
            if (find(i) == i) {
                ans = (ans * cnt[i]) % 1_000_000_007;
            }
        }
        System.out.println(ans);
    }
    static int find(int x){
        if(arr[x]==x){
            return x;
        }
        return arr[x]=find(arr[x]);
    }
    static void union(int a, int b){
        int rootA=find(a);
        int rootB=find(b);
        if(rootA!=rootB){
            arr[rootA]=rootB;
            cnt[rootB]+=cnt[rootA];
        }
    }
}
