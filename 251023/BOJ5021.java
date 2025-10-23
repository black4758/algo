import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ5021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] name = new String[N*3];
        String king = br.readLine().trim();
        HashMap<String, Integer> map = new HashMap<>();
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= N*3; i++) {
            list.add(new ArrayList<>());
        }
        int index = 0;
        name[index] = king;
        map.put(name[index], 0);
        index++;
        int[] cnt = new int[N*3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken().trim();
            String b = st.nextToken().trim();
            String c = st.nextToken().trim();
            if (!map.containsKey(a)) {
                name[index] = a;
                map.put(a, index++);
            }
            if (!map.containsKey(b)) {
                name[index] = b;
                map.put(b, index++);
            }
            if (!map.containsKey(c)) {
                name[index] = c;
                map.put(c, index++);
            }
            list.get(map.get(c)).add(map.get(a));
            list.get(map.get(b)).add(map.get(a));
            cnt[map.get(a)]+=2;
        }
        double[] ans = new double[N*3];
        ans[0] = 1.0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < map.size(); i++) {
            if(cnt[i]==0){
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : list.get(now)) {
                ans[next] += ans[now]/2.0;
                cnt[next]--;
                if(cnt[next]==0){
                    queue.add(next);
                }
            }
        }
        double max = 0;
        String ansStr = "";
        for (int i = 0; i < M; i++) {
            String input = br.readLine().trim();
            if (!map.containsKey(input)) continue;

            if(max<ans[map.get(input)]){
                max = ans[map.get(input)];
                ansStr = name[map.get(input)];
            }
        }
        System.out.println(ansStr);
    }
}
