import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ6603 {
    static int [] arr;
    static int [] now;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            if (K == 0) {
                break;
            }
            arr = new int[K];
            now = new int[K];
            for (int i = 0; i < K; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            dfs(0,0);
            sb.append("\n");
        }
        System.out.println(sb);
    }
    static void dfs(int start, int cnt) {
        if (cnt ==6) {
            for (int i = 0; i < 6; i++) {
                sb.append(now[i]).append(" ");
            }
            sb.append("\n");
        }
        for (int i = start; i < arr.length; i++) {
            now[cnt]=arr[i];
            dfs(i+1,cnt+1);
        }
    }
}
