import java.io.*;
import java.util.*;

public class BOJ1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> plus = new ArrayList<>();
        List<Integer> minus = new ArrayList<>();
        int zeroCount = 0;
        int oneCount = 0;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > 1) plus.add(num);
            else if (num == 1) oneCount++;
            else if (num == 0) zeroCount++;
            else minus.add(num);
        }

        Collections.sort(plus,((o1, o2) -> o2 - o1));
        Collections.sort(minus);

        int ans = 0;

        for (int i = 0; i < plus.size(); i += 2) {
            if (i + 1 < plus.size()) ans += plus.get(i) * plus.get(i + 1);
            else ans += plus.get(i);
        }

        for (int i = 0; i < minus.size(); i += 2) {
            if (i + 1 < minus.size()) ans += minus.get(i) * minus.get(i + 1);
            else {
                if (zeroCount == 0) ans += minus.get(i);
            }
        }

        ans += oneCount;

        System.out.println(ans);
    }
}
