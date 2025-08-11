import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ13913 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] visited = new int[100001];
        int[] arr = new int[100001];
        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        Arrays.fill(visited, Integer.MAX_VALUE);
        Arrays.fill(arr, -1);
        visited[N] = 0;
        while (!q.isEmpty()) {
            int now = q.poll();
            if (now == K) {
                StringBuilder sb = new StringBuilder();
                sb.append(visited[now]).append("\n");
                List<Integer> list = new ArrayList<>();
                for (int i = K; i !=-1 ; i=arr[i]) {
                    list.add(i);
                }
                Collections.reverse(list);
                for(int i : list) {
                    sb.append(i).append(" ");
                }
                System.out.println(sb);
                return;
            }
            if (now*2<=100000 && visited[now*2]>visited[now]+1) {
                visited[now*2] = visited[now]+1;
                arr[now*2]=now;
                q.add(now*2);
            }
            if (now+1<=100000 && visited[now+1]>visited[now]+1) {
                visited[now+1] = visited[now]+1 ;
                arr[now+1]=now;
                q.add(now+1);
            }
            if (now-1>=0 && visited[now-1]>visited[now]+1) {
                visited[now-1] = visited[now]+1 ;
                arr[now-1]=now;
                q.add(now-1);
            }
        }
    }
}
