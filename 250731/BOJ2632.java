import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ2632 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 목표 길이
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 첫번째 피자 조각 수
        int m = Integer.parseInt(st.nextToken()); // 두번째 피자 조각 수

        long[] p1 = new long[n];
        long[] p2 = new long[m];

        for (int i = 0; i < n; i++) {
            p1[i] = Long.parseLong(br.readLine());
        }

        for (int i = 0; i < m; i++) {
            p2[i] = Long.parseLong(br.readLine());
        }
        long cnt = 0;

        HashMap<Long, Long> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int j = 0; j < n-1; j++) {
                int index = (i + j ) % n;
                sum += p1[index];
                if (sum==t) {
                    cnt++;
                }
                else map.put(sum, map.getOrDefault(sum, 0L) + 1);
            }
        }
        long sumP1 = 0;
        for (int i = 0; i < n; i++) {
            sumP1 += p1[i];
        }
        if (sumP1 == t) cnt++;
        else map.put(sumP1, 1L);

        for (int i = 0; i < m; i++) {
            long sum = 0;
            for (int j = 0; j < m-1; j++) {
                int index = (i + j) % m;
                sum += p2[index];
                if (sum == t) cnt++;
                else if (map.containsKey(t - sum)) {
                    cnt += map.get(t - sum);
                }
            }
        }

        long sumP2 = 0;
        for (int i = 0; i < m; i++) {
            sumP2 += p2[i];
        }
        if (sumP2 == t) cnt++;
        else if (map.containsKey(t - sumP2)) {
            cnt += map.get(t - sumP2);
        }


        System.out.println(cnt);
    }
}
