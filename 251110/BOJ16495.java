import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ16495 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        long result = 0L;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            int now = c-'A'+1;
            result = result*26+now;
        }
        System.out.println(result);
    }
}
