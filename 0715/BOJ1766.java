import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1766 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];
        List<List<Integer>> input = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            input.add(new ArrayList<>());
        }
        Queue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            input.get(start).add(end);
            arr[end]++;
        }
        for (int i = 1; i <= N; i++) {
            if (arr[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            ans.add(cur);
            for (int n : input.get(cur)) {
                arr[n]--;
                if (arr[n] == 0) {
                    q.add(n);
                }
            }
        }
        StringBuilder sb =new StringBuilder();
        for(int n : ans){
            sb.append(n).append(" ");
        }
        System.out.println(sb);
    }

}
