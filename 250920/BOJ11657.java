import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ11657 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list.add(new int[] {start,end,cost});
        }
        long[] arr = new long[N+1];
        Arrays.fill(arr, Long.MAX_VALUE);
        arr[1] = 0;
        for (int i = 1; i < N; i++) {
            for (int[] next : list) {
                if (arr[next[0]] != Long.MAX_VALUE && arr[next[1]] > arr[next[0]]+next[2] ) {
                    arr[next[1]] = arr[next[0]]+next[2];
                }
            }
        }
        boolean check = false ;
        for (int[] next : list) {
            if (arr[next[0]] != Long.MAX_VALUE  && arr[next[1]] > arr[next[0]]+next[2] ) {
                check = true;
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        if (check) {
            sb.append("-1\n");
        } else {
            for (int i = 2; i <= N; i++) {
                if (arr[i] == Long.MAX_VALUE) {
                    sb.append("-1\n");
                } else {
                    sb.append(arr[i]).append("\n");
                }
            }
        }
        System.out.println(sb);

    }
}
