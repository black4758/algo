import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            String input = br.readLine();
            Stack<Character> stack = new Stack<>();
            boolean flag = false;
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == '(') {
                    stack.push(input.charAt(i));
                }
                else {
                    if (stack.isEmpty()) {
                        flag = true;
                        break;
                    }
                    stack.pop();
                }
            }
            if (flag || !stack.isEmpty() ) {
                sb.append("NO\n");
            }else {
                sb.append("YES\n");
            }
        }
        System.out.println(sb.toString().trim());
    }
}
