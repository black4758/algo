import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ1043 {
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            dp[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int cnt = Integer.parseInt(st.nextToken());
        int[] truth = new int[cnt];
        for (int i = 0; i < cnt; i++) truth[i] = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            list.add(new ArrayList<>());
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            for (int j = 0; j < size; j++) {
                list.get(i).add(Integer.parseInt(st.nextToken()));
            }
            for (int j = 1; j < size; j++) {
                union(list.get(i).get(0), list.get(i).get(j));
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int t : truth) set.add(find(t));

        int ans = 0;
        for (int i = 0; i < M; i++) {
            boolean num = true;
            for (int j = 0; j < list.get(i).size(); j++) {
                if (set.contains(find(list.get(i).get(j)))) {
                    num = false;
                    break;
                }
            }
            if (num) ans++;
        }
        System.out.println(ans);
    }

    static int find(int x) {
        if (x == dp[x]) return x;
        return dp[x] = find(dp[x]);
    }

    static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot != bRoot) dp[bRoot] = aRoot;
    }
}
