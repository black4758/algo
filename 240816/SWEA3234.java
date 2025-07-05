import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA3234 {
    static int N;
    static int[] input;
    static int[] num;
    static int result;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            result=0;
            input = new int[N];
            num = new int[N];
            visited = new boolean[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                input[i] = Integer.parseInt(st.nextToken());
            }
            permutation(0);
            System.out.println("#"+t+" "+result);
        }
    }
    private static void permutation(int cnt) {
        if (cnt == N) {
            subset(0,0,0);
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                num[cnt]=input[i];
                permutation(cnt+1);
                visited[i] = false;
            }
        }
    }
    private static void subset(int cnt, int right ,int left) {
        if(right > left) {
            return;
        }
        if (cnt == N) {
            result++;
            return;
        }
        subset(cnt+1, right+num[cnt], left);
        subset(cnt+1, right, left+num[cnt]);
    }
}
