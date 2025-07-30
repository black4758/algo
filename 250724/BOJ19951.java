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
        int [] store = new int[N+2]; // 변화량 배열
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            store[start]+=cost;
            store[end+1]-=cost;
            //end+1애 -cost인 이유는 end+1일때 이전값이 더해지니깐 이전값을 뻄
            // 이전까지 더해졌던 cost 값이 더해지지 않도록 상쇄시키기 위함입니다.
        }
        for (int i = 1; i <= N; i++) {
            store[i] += store[i-1]; // 누적합으로 최종 변화량 구하기
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            input[i] += store[i]; //  현재값과 변화량을 더해 최종값 구하기
            sb.append(input[i]).append(" ");
        }

        System.out.println(sb);
    }
}
