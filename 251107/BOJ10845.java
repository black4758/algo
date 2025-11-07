import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        Deque<Integer> q = new ArrayDeque<>();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String now=st.nextToken();
            if (now.equals("push")) {
                q.add(Integer.parseInt(st.nextToken()));
            }
            else if (now.equals("front")) {
                if (q.isEmpty()) {
                    sb.append(-1).append("\n");
                }else sb.append(q.peekFirst()).append("\n");
            }
            else if (now.equals("back")) {
                if (q.isEmpty()) {
                    sb.append(-1).append("\n");
                }else sb.append(q.peekLast()).append("\n");
            }
            else if (now.equals("empty")) {
                if (q.isEmpty()) {
                    sb.append(1).append("\n");
                }
                else sb.append(0).append("\n");
            }
            else if (now.equals("pop")){
                if (q.isEmpty()) {
                    sb.append(-1).append("\n");
                } else sb.append(q.poll()).append("\n");
            }
            else if (now.equals("size")){
                sb.append(q.size()).append("\n");
            }
        }
        System.out.println(sb);
    }
}
