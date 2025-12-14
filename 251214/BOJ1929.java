import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        if (a ==1 && b==1) {
            return;
        }
        for (int i = a; i <= b; i++) {
            boolean flag = true;
            if (i == 1) {
                continue;
            }
            for (int j = 2; j*j <= i; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }
}
