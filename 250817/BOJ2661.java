import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2661 {
    static int N;
    static String ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ans = "";
        dfs(0);

    }

    static void dfs(int cnt) {
        if (cnt == N) {
            System.out.println(ans);
            System.exit(0);
            return;
        }
        for (int i = 1; i <= 3; i++) {

            if (check(ans + i)) {
                ans = ans + i;
                dfs(cnt + 1);
                ans = ans.substring(0, ans.length() - 1);
            }
        }
    }

    static boolean check(String s) {
        int len = s.length();
        for (int i = 1; i <= len / 2; i++) {
            String start = s.substring(len - 2 * i, len - i);
            String end = s.substring(len - i);
            if (start.equals(end)) {
                return false;
            }
        }
        return true;
    }
}
