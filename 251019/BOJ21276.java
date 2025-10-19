import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ21276 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] name = new String[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            name[i] = st.nextToken();
        }
        Arrays.sort(name);
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            map.put(name[i],i);
        }
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(new ArrayList<>());
        }
        int [] cnt = new int[N];
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = map.get(st.nextToken());
            int b = map.get(st.nextToken());
            list.get(b).add(a);
            cnt[a]++;
        }
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();
        List<String> parent = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (cnt[i] == 0) {
                q.add(i);
                parent.add(name[i]);
            }
        }
        sb.append(parent.size()).append("\n");
        for(String now : parent){
            sb.append(now).append(" ");
        }
        sb.append("\n");
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            ans.add(new ArrayList<>());
        }
        while (!q.isEmpty()) {
            int now = q.poll();
            for(int next :list.get(now)) {
                cnt[next]--;
                if (cnt[next] == 0) {
                    ans.get(now).add(name[next]);
                    q.add(next);
                }
            }
        }
        for (int i = 0; i < N; i++) {
            List<String>my =ans.get(i);
            Collections.sort(my);
            sb.append(name[i]).append(" ").append(my.size()).append(" ");
            for (String s : my) {
                sb.append(s).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
}
