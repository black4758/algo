import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2887 {
    static int[] parent;
    static class Position{
        int id;
        int x;
        int y;
        int z;
        public Position(int id, int x, int y, int z) {
            this.id = id;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    static int find(int x){
      if(parent[x] == x) return x;
      return parent[x] = find(parent[x]);
    };

    static boolean union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA == rootB) return false;
        parent[rootB] = rootA;
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Position[] arr = new Position[N];
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i]=i;
        }
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            arr[i]= new Position(i,x,y,z);
        }
        List<int[]> list = new ArrayList<>();
        Arrays.sort(arr,((o1, o2) -> o1.x - o2.x));
        for (int i = 0; i < N-1; i++) {
            int cost = Math.abs(arr[i].x - arr[i+1].x);
            list.add(new int[]{arr[i].id,arr[i+1].id,cost});
        }
        Arrays.sort(arr,((o1, o2) -> o1.y - o2.y));
        for (int i = 0; i < N-1; i++) {
            int cost = Math.abs(arr[i].y - arr[i+1].y);
            list.add(new int[]{arr[i].id,arr[i+1].id,cost});
        }
        Arrays.sort(arr,((o1, o2) -> o1.z - o2.z));
        for (int i = 0; i < N-1; i++) {
            int cost = Math.abs(arr[i].z - arr[i+1].z);
            list.add(new int[]{arr[i].id,arr[i+1].id,cost});
        }
        list.sort((o1, o2) -> o1[2] - o2[2]);
        int cnt = 0;
        long ans = 0;
        for(int[] now : list) {
            if(union(now[0], now[1])) {
                cnt++;
                ans+=now[2];
                if(cnt == N-1) break;
            }
        }
        System.out.println(ans);
    }
}
