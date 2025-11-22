import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ11286 {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            if (Math.abs(o1) == Math.abs(o2))  {
                return o1-o2;
            }
            return Math.abs(o1)-Math.abs(o2);
        });
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                if (pq.isEmpty()) {
                    sb.append(0).append("\n");
                }
                else {
                    sb.append(pq.poll()).append("\n");
                }
            }
            else{
                pq.add(input);
            }
        }
        System.out.println(sb);
    }
}
