import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ4803 {
    static List<Integer>[] list;
    static boolean[] visited;
    static boolean isTree;
    public static void main(String[] args) throws IOException {
        StringBuilder sb=new StringBuilder();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=1;
        while(true){
            StringTokenizer st=new StringTokenizer(br.readLine()," ");
            int n=Integer.parseInt(st.nextToken());
            int m=Integer.parseInt(st.nextToken());
            if(n==0 && m==0){
                break;
            }
            visited=new boolean[n+1];
            list=new ArrayList[n+1];
            for(int i=1;i<=n;i++){
                list[i]=new ArrayList<Integer>();
            }
            for(int i=0;i<m;i++){
                st=new StringTokenizer(br.readLine()," ");
                int a=Integer.parseInt(st.nextToken());
                int b=Integer.parseInt(st.nextToken());
                list[a].add(b);
                list[b].add(a);
            }
            int cnt=0;
            for(int i=1;i<=n;i++){
                if(!visited[i]){
                    isTree = true;
                    dfs(i,0);
                    if (isTree) cnt++;
                }
            }
            sb.append("Case ").append(T++).append(":");
            if(cnt==0){
                sb.append(" No trees.").append("\n");
            }
            else if(cnt==1){
                sb.append(" There is one tree.").append("\n");
            }
            else{
                sb.append(" A forest of "+ cnt +" trees.").append("\n");
            }
        }
        System.out.println(sb);
    }
    public static void dfs(int i,int parent){
        visited[i]=true;
        for(int next : list[i]){
            if(!visited[next]){
                dfs(next,i);
            }
            else if(next!=parent) {
                isTree = false;
            }
        }
    }
}
