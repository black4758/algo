import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_M15650 {
    static int[] arr;
    static int M;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());
        arr = new int[M];
        combination(0,1);
    }

    private static void combination(int cnt, int st) {
        if (cnt == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }
        for (int i = st; i <=N; i++) {
            arr[cnt] = i;
            combination(cnt+1, i+1);
        }
    }
}
