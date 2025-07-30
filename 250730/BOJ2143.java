import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ2143 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long T = Long.parseLong(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[] aArr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            aArr[i] = Integer.parseInt(st.nextToken());
        }
        HashMap<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int j = i; j < n; j++) {
                sum += aArr[j];
                if (map.containsKey(sum)) {
                    map.put(sum, map.get(sum) + 1);
                }
                else {
                    map.put(sum, 1);
                }
            }
        }

        int m=Integer.parseInt(br.readLine());
        int[] bArr = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            bArr[i] = Integer.parseInt(st.nextToken());
        }

        long ans = 0;
        for (int i = 0; i < m; i++) {
            long sum = 0;
            for (int j = i; j < m; j++) {
                sum += bArr[j];
                long find = T-sum;
                if (map.containsKey(find)) {
                    ans+=map.get(find);
                }
            }
        }
        System.out.println(ans);
    }
}
