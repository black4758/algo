import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        List<List<int[]>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.get(a).add(new int[]{b,c});
            list.get(b).add(new int[]{a,c});
        }
        for (int i = 1; i <= n; i++) {
            int [] arr = new int[n+1];
            Arrays.fill(arr, Integer.MAX_VALUE);
            boolean[] visited = new boolean[n+1];
            arr[i] = 0;
            int[] first = new int[n+1];
            for (int j = 1; j <= n; j++) {
                first[j]=j;
            }
            PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);
            pq.add(new int[]{i,0});
            while (!pq.isEmpty()) {
                int[] cur = pq.poll();
                if(visited[cur[0]]){
                    continue;
                }
                visited[cur[0]]=true;
                for(int [] next:list.get(cur[0])){
                    if(arr[next[0]]>cur[1]+next[1]){
                        arr[next[0]]=cur[1]+next[1];
                        pq.add(new int[]{next[0],arr[next[0]]});
                        if(cur[0]==i){
                            first[next[0]]=next[0];
                        }else {
                            first[next[0]]=first[cur[0]];
                        }
                    }
                }
            }
            for(int j=1;j<=n;j++){
                if(i==j){
                    sb.append("- ");
                }
                else {
                    sb.append(first[j]+" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
