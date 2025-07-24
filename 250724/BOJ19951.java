import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ19951 {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] input = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        int [] store = new int[N+2];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            store[start]+=cost;
            store[end+1]-=cost;
        }
        for (int i = 1; i <= N; i++) {
            store[i] += store[i-1];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            input[i] += store[i]; // store[i]는 이제 i칸의 총 변화량
            sb.append(input[i]).append(" ");
        }

        System.out.println(sb);
    }
}
