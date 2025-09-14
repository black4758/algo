import java.io.*;
import java.util.*;

public class BOJ6497 {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            if(m==0 && n==0) {
                break;
            }
            int total = 0;
            List<List<int[]>>list =new ArrayList<>();
            for (int i = 0; i < m; i++) {
                list.add(new ArrayList<>());
            }
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int cost= Integer.parseInt(st.nextToken());
                list.get(start).add(new int[]{end, cost});
                list.get(end).add(new int[]{start, cost});
                total += cost;
            }
            boolean[] visited= new boolean[m];
            PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
            pq.add(new int[]{0,0});
            int count = 0;
            int sum = 0;
            while (!pq.isEmpty()&&count<m) {
                int[] now = pq.poll();
                if(!visited[now[0]]) {
                    visited[now[0]] = true;
                    count++;
                    sum += now[1];

                    for (int[] next : list.get(now[0])) {
                        if (!visited[next[0]]) {
                            pq.add(next);
                        }
                    }
                }
            }
            sb.append(total-sum).append("\n");
        }
        System.out.print(sb);
    }
}
