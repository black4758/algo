package main.java._2025_12_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            Queue<int[]> q = new LinkedList<>();
            PriorityQueue<Integer>pq = new PriorityQueue<>((o1,o2)->o2-o1);
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int now = Integer.parseInt(st.nextToken());
                q.add(new int[]{i,now});
                pq.add(now);
            }
            int cnt=0;
            while (!q.isEmpty()) {
                int[] now =q.poll();
                if(now[1]<pq.peek()){
                    q.add(now);
                }else {
                    cnt++;
                    pq.poll();
                    if(now[0]==M){
                        sb.append(cnt).append("\n");
                        break;
                    }
                }
            }
        }
        System.out.println(sb);
    }
}
