import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String input = br.readLine();
            if (input.equals(".")) {
                break;
            }
            boolean flag = true;
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == '(' || input.charAt(i) == '[') {
                    stack.push(input.charAt(i));
                }
                else if (input.charAt(i) == ')') {
                    if (stack.isEmpty()) {
                        flag = false;
                        break;
                    }
                    char now = stack.pop();
                    if (now != '(') {
                        flag = false;
                        break;
                    }
                }
                else if (input.charAt(i) == ']') {
                    if (stack.isEmpty()) {
                        flag = false;
                        break;
                    }
                    char now = stack.pop();
                    if (now != '[') {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag && stack.isEmpty()) {
                sb.append("yes").append('\n');
            }
            else {
                sb.append("no").append('\n');
            }
        }
        System.out.print(sb);
    }
}
