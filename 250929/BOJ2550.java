import java.io.*;
import java.util.*;

public class BOJ2550 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] switchArr = new int[N];
        int[] bulbArr = new int[N];
        int[] posArr = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            switchArr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            bulbArr[i] = Integer.parseInt(st.nextToken());
            posArr[bulbArr[i]] = i;
        }

        int[] seq = new int[N];
        for (int i = 0; i < N; i++) {
            seq[i] = posArr[switchArr[i]];
        }

        // LIS
        int[] dp = new int[N];
        int[] parent = new int[N];
        int[] idx = new int[N];
        Arrays.fill(parent, -1);

        int length = 0;
        for (int i = 0; i < N; i++) {
            int x = seq[i];
            int pos = Arrays.binarySearch(dp, 0, length, x);
            if (pos < 0) pos = -pos - 1;

            dp[pos] = x;
            idx[pos] = i;

            if (pos > 0) parent[i] = idx[pos - 1];
            if (pos == length) length++;
        }

        int cur = idx[length - 1];
        StringBuilder sb = new StringBuilder();
        sb.append(length).append("\n");
        while (cur != -1) {
            sb.append(switchArr[cur]).append(" ");
            cur = parent[cur];
        }
        System.out.println(sb.toString());
    }
}
