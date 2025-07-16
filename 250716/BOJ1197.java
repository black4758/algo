import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1197 {
    static class Node {
        int start, end , cost;
        Node(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }

    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        Node[] input = new Node[E];
        parent = new int[V+1];
        for (int i =0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            input[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(input, (o1, o2) -> o1.cost - o2.cost);
        int cnt=0;
        int ans=0;
        for(Node now : input) {
            if (union(now.start, now.end)) {
                ans+=now.cost;
                cnt++;
            }
            if (cnt == V-1) {
                break;
            }
        }
        System.out.println(ans);
    }
    public static int find(int x) {
        if(parent[x] == 0) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    public static boolean union(int x,int y){
        int nx=find(x);
        int ny=find(y);
        if( nx== ny){
            return false;
        }
        parent[ny]=nx;
        return true;
    }
}
