import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ1620 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] arr = new String[n+1];
        for (int i = 1; i <= n; i++) {
            String input = br.readLine();
            arr[i] = input;
            map.put(input,i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String num = br.readLine();
            if (map.containsKey(num)) {
                sb.append(map.get(num)).append("\n");
            }
            else sb.append(arr[Integer.parseInt(num)]).append("\n");
        }
        System.out.println(sb);
    }
}
