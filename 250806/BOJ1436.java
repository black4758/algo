import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int now =666;
        while (true) {
            if ((now+"").contains("666")) {
                N--;
                if (N == 0) {
                    break;
                }
            }
            now = now+1;
        }
        System.out.println(now);
    }

}
