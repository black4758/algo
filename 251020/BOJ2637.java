import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2637 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        List<List<int[]>> list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }
        int[] cnt = new int[N+1];
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.get(a).add(new int[]{b, c});
            cnt[b]++;
        }
        Queue<Integer> q = new LinkedList<>();
        int [] ans = new int[N+1];
        q.add(N);
        ans[N] = 1;
        while (!q.isEmpty()) {
            int now = q.poll();
            for(int [] next : list.get(now)) {
                ans[next[0]]+=ans[now]*next[1];
                cnt[next[0]]--;
                if(cnt[next[0]]==0) {
                    q.add(next[0]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N+1; i++) {
            if(list.get(i).isEmpty()) {
                sb.append(i).append(" ").append(ans[i]).append("\n");
            }
        }
        System.out.println(sb);

    }
}
