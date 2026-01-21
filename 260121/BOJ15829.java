import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ15829 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());
        String s = br.readLine();

        long hash = 0;
        long r = 1;
        final long M = 1234567891L;
        final long R = 31L;

        for (int i = 0; i < L; i++) {
            int val = (s.charAt(i) - 'a' + 1);
            hash = (hash + val * r) % M;
            r = (r * R) % M;
        }

        System.out.println(hash);
    }
}
