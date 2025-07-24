import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ1918 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input= br.readLine();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        char now;
        for (int i = 0; i < input.length(); i++) {
            now =input.charAt(i);
            if (now >= 'A' && now <= 'Z') {
                sb.append(now);
            }
            else if (now == '(') {
                stack.push(now);
            }
            else if (now == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.pop();
            }

            else {
                while (!stack.isEmpty() && score(now) <= score(stack.peek())) {
                    sb.append(stack.pop());
                }
                stack.push(now);
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }
    private static int score(char op) {
        if (op == '*' || op == '/') {
            return 2;
        } else if (op == '+' || op == '-') {
            return 1;
        } else if (op == '(' || op == ')') {
            return 0;
        }
        return -1;
    }
}
