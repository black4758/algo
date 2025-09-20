import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            List<int[]> list = new ArrayList<>();
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                list.add(new int[]{start, end, cost});
                list.add(new int[]{end, start, cost});
            }
            int[] arr  =new int[N+1];
            int INF= 100_000_000;
            Arrays.fill(arr, INF);
            arr[1] = 0;
            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                list.add(new int[]{start, end, -cost});
            }
            for (int i = 1; i < N; i++) {
                for(int[] now : list) {
                    if(arr[now[1]]>arr[now[0]]+now[2]){
                        arr[now[1]]=arr[now[0]]+now[2];
                    }
                }
            }
            boolean flag=false;
            for(int[] now : list) {
                if(arr[now[1]]>arr[now[0]]+now[2]){
                    flag = true;
                    sb.append("YES\n");
                    break;
                }
            }
            if (!flag){
                sb.append("NO\n");
            }
        }
        System.out.println(sb);
    }
}
