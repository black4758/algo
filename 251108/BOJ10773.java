import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ10773 {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(br.readLine());
            if(now == 0) {
                stack.pop();
            }
            else stack.add(now);
        }
        int sum = 0;
        for (int now : stack) {
            sum+=now;
        }
        System.out.println(sum);
    }
}
