import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        int[] cnt = new int[8001];
        int offset = 4000;
        int sum = 0;
        int cntMax = 0;

        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(br.readLine());
            list.add(now);
            cnt[now + offset]++;
            if (cnt[now + offset] > cnt[cntMax + offset]) {
                cntMax = now;
            }
            sum += now;
        }

        List<Integer> list2 = new ArrayList<>();
        int maxFreq = cnt[cntMax + offset];
        for (int i = -4000; i <= 4000; i++) {
            if (cnt[i + offset] == maxFreq) {
                list2.add(i);
            }
        }

        list.sort((o1, o2) -> o1 - o2);
        list2.sort((o1, o2) -> o1 - o2);

        StringBuilder sb = new StringBuilder();

        sb.append(sum / n).append("\n");

        sb.append(Math.round(sum / (double)n)).append("\n");

        if (list2.size() == 1) {
            sb.append(list2.get(0)).append("\n");
        } else {
            sb.append(list2.get(1)).append("\n");
        }
        sb.append(list.get(n - 1) - list.get(0));

        System.out.println(sb);
    }
}
