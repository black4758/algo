import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ13334 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new int[]{Math.min(a,b), Math.max(a,b)});
        }
        int d = Integer.parseInt(br.readLine());
        list.sort((o1,o2)->{
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });
        PriorityQueue<Integer>pq = new PriorityQueue<>();
        int ans = 0;
        for(int[] now : list) {
            if (now[1] -now[0]>d) {
                continue;
            }
            pq.offer(now[0]);
            while (!pq.isEmpty() && pq.peek()<now[1]-d) {
                pq.poll();
            }
            ans =Math.max(ans,pq.size());
        }
        System.out.println(ans);
    }
}
