import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ14221 {
    static  class Node {
        int end;
        int cost;
        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<List<Node>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list.get(start).add(new Node(end, cost));
            list.get(end).add(new Node(start, cost));
        }
        st = new StringTokenizer(br.readLine());
        int houseCnt = Integer.parseInt(st.nextToken());
        int storeCnt = Integer.parseInt(st.nextToken());
        int[] house = new int[houseCnt];
        int[] store = new int[storeCnt];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < houseCnt; i++) {
            house[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < storeCnt; i++) {
            store[i] = Integer.parseInt(st.nextToken());
        }
        int[] arr = new int[n+1];
        Arrays.fill(arr, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        for (int i = 0; i < storeCnt; i++) {
            pq.add(new Node(store[i], 0));
            arr[store[i]]=0;
        }
        boolean[] visited = new boolean[n+1];
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (visited[now.end]) {
                continue;
            }
            visited[now.end] = true;
//            if(arr[now.end]<now.cost) {
//                continue;
//            }
            for(Node next: list.get(now.end)) {
                if(arr[next.end]>arr[now.end]+next.cost){
                    arr[next.end]=arr[now.end]+next.cost;
                    pq.add(new Node(next.end,arr[next.end]));
                }
            }
        }
        int  distance =Integer.MAX_VALUE;
        int ans = -1;
        for (int h : house) {
            if (arr[h] < distance) {
                distance = arr[h];
                ans = h;
            } else if (arr[h] == distance && h < ans) {
                ans = h;
            }
        }
        System.out.println(ans);
    }
}
