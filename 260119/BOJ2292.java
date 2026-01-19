import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long ans =1;
        long room = 1;
        while (room < N) {
            room+=6*ans;
            ans++;
        }
        System.out.println(ans);
    }
}
