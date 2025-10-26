import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }
        List<String> ans = new ArrayList();
        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            if(set.contains(input)) {
                ans.add(input);
            }
        }
        Collections.sort(ans);
        StringBuilder sb = new StringBuilder();
        sb.append(ans.size()).append('\n');
        for (int i = 0; i < ans.size(); i++) {
            sb.append(ans.get(i)).append('\n');
        }
        System.out.print(sb);
    }
}
