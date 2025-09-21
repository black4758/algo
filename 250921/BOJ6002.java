import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ6002 {
    static class Node {
        int start, end , cost;
        public Node(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int D = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new Node(a, b, D));
        }
        for (int i = 0; i < F; i++) {
            st = new StringTokenizer(br.readLine());
            int j = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            list.add(new Node(j, k, D-t));
            }
        long[] arr = new long[C+1];
        Arrays.fill(arr, Long.MIN_VALUE);
        arr[S] = D;
        boolean infinite = false;
        for (int i = 1; i <= C; i++) {
            boolean updated = false;
            for(Node next : list) {
                if(arr[next.start] != Long.MIN_VALUE && arr[next.end] < arr[next.start]+next.cost) {
                    arr[next.end] = arr[next.start ]+next.cost;
                    updated = true;
                    if(i==C){
                        infinite = true;
                    }
                }
            }
            if(!updated) {
                break;
            }
        }
        long ans = Long.MIN_VALUE;
        if(infinite) {
            System.out.println(-1);
        } else {
            for(long next : arr){
                ans=Math.max(ans, next);
            }
            System.out.println(ans);
        }
    }
}
