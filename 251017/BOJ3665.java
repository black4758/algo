import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ3665 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T= Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            List<List<Integer>> list = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                list.add(new ArrayList<>());
            }
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] input = new int[n+1];
            for (int i = 1; i <= n; i++) {
                input[i] = Integer.parseInt(st.nextToken());
            }
            int[] cnt = new int[n+1];
            for (int i = 1; i <= n; i++) {
                for (int j = i+1; j <= n; j++) {
                    list.get(input[i]).add(input[j]);
                    cnt[input[j]]++;
                }
            }
            int m= Integer.parseInt(br.readLine());
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if(list.get(a).contains(b)) {
                    list.get(a).remove(Integer.valueOf(b));
                    list.get(b).add(a);
                    cnt[b]--;
                    cnt[a]++;
                }
                else {
                    list.get(b).remove(Integer.valueOf(a));
                    list.get(a).add(b);
                    cnt[a]--;
                    cnt[b]++;
                }
            }
            Queue<Integer>q = new LinkedList<>();
            for (int i = 1; i <= n; i++) {
                if(cnt[i] == 0) {
                    q.add(i);
                }
            }
            List<Integer> ans = new ArrayList<>();
            boolean check = false;
            boolean cycle = false;
            for (int i = 0; i < n; i++) {
                if(q.isEmpty()){
                    cycle=true;
                    break;
                }
                if(q.size() > 1) {
                    check = true;
                }
                int now = q.poll();
                ans.add(now);
                for(int next: list.get(now)) {
                    cnt[next]--;
                    if(cnt[next] == 0) { q.add(next);}
                }
            }
            if(cycle){
                sb.append("IMPOSSIBLE").append('\n');
            }
            else if(check) {
                sb.append("?").append('\n');
            }
            else{
                for(int next: ans) {
                    sb.append(next).append(' ');
                }
                sb.append('\n');
            }

        }
        System.out.println(sb);
    }
}
