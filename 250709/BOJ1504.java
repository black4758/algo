import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class BOJ1504 {
    static class Position{
        int end;
        int cost;
        public Position(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }
    static int N;
    static ArrayList<ArrayList<Position>> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list.get(start).add(new Position(end, cost));
            list.get(end).add(new Position(start, cost));
        }
        st = new StringTokenizer(br.readLine());
        int V1= Integer.parseInt(st.nextToken());
        int V2= Integer.parseInt(st.nextToken());
        int[] arr1=solution(1);
        int[] arrV1=solution(V1);
        int[] arrV2=solution(V2);
        long cost1=(long)arr1[V1]+arrV1[V2]+arrV2[N];
        long cost2=(long)arr1[V2]+arrV1[N]+arrV2[V1];
        long result = Math.min(cost1, cost2);
        if(result >= Integer.MAX_VALUE){
            System.out.println(-1);
        }
        else {
            System.out.println(result);
        }

    }
    static int[] solution(int start) {
        PriorityQueue<Position> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.add(new Position(start, 0));
        int[] arr = new int[N+1];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[start] = 0;
        while (!pq.isEmpty()) {
            Position now = pq.poll();
            if(arr[now.end]<now.cost){
                continue;
            }
            for(Position next : list.get(now.end)) {
                int nextCost = now.cost+next.cost;
                if(arr[next.end]>nextCost){
                    arr[next.end] = nextCost;
                    pq.add(new Position(next.end, nextCost));
                }
            }
        }
        return arr;
    }
}
