import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1167 {
    static boolean[] visted;
    static int ans = 0;
    static ArrayList<ArrayList<Node>> list;
    static int findNode;
    static class Node {
        int end;
        int cost;
        Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V=Integer.parseInt(br.readLine());
        visted = new boolean[V+1];
        findNode=0;
        list = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            list.add(new ArrayList<>());
        }
        for(int i=0;i<V;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int root=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            while (end != -1){
                int cost=Integer.parseInt(st.nextToken());
                list.get(root).add(new Node(end,cost));
                end=Integer.parseInt(st.nextToken());
            }
        }
        dfs(1,0);
        visted= new boolean[V+1];
        ans=0;
        dfs(findNode,0);
        System.out.println(ans);
    }
    static void dfs(int node ,int sum) {
        if (sum>ans){
            ans=sum;
            findNode=node;
        }
        visted[node]=true;

        for(Node next : list.get(node) ) {
            if(!visted[next.end]) {
                dfs(next.end,sum+next.cost);
            }
        }
    }

}
