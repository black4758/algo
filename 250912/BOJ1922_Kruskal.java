import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1922_Kruskal {
    static int [] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        List<Node> list = new ArrayList<>();
        arr = new int[N+1];
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list.add(new Node(start,end,cost));
        }
        list.sort(((o1, o2) -> o1.cost - o2.cost));
        int cnt = 0;
        int ans=0;
        for(Node now : list) {
            if(union(now.start,now.end)) {
                ans+=now.cost;
                if(++cnt == N-1) {
                    break;
                }
            }
        }
        System.out.println(ans);
    }
    static int find(int x){
        if(arr[x] == 0){
            return x;
        }
        return arr[x]=find(arr[x]);
    }

    static boolean union(int a,int b){
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot == bRoot){
            return false;
        }
        arr[bRoot]=aRoot;
        return true;
    }
    static class Node {
        int  start,end,cost;
        Node( int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
}
