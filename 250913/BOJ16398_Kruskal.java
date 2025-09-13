import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ16398_Kruskal {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<int[]> list = new ArrayList<>();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i]=i;
        }
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int cost = Integer.parseInt(st.nextToken());
                if (cost != 0)
                    list.add(new int[]{i,j,cost});
            }
        }
        int cnt = 0;
        long ans = 0;
        list.sort((o1,o2)->o1[2]-o2[2]);
        for (int[] arr : list) {
            if(union(arr[0], arr[1])){
                ans+=arr[2];
                if(++cnt==N-1){
                    break;
                }
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
    static boolean union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA==rootB){
            return false;
        }
        arr[rootB]=rootA;
        return true;
    }
}
