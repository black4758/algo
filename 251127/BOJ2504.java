import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int temp = 1;
        int ans = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char now = input.charAt(i);
            if(now == '('){
                temp = temp *2;
                stack.push(now);
            }
            else if(now == '['){
                temp = temp *3;
                stack.push(now);
            }
            else if(now == ')'){
                if(stack.isEmpty() || stack.pop() != '('){
                    ans=0;
                    break;
                }
                if (input.charAt(i - 1) == '(') {
                    ans += temp;
                }
                temp /=2;
            }
            else if(now == ']'){
                if(stack.isEmpty() || stack.pop() != '['){
                    ans=0;
                    break;
                }
                if (input.charAt(i - 1) == '[') {
                    ans += temp;
                }
                temp /=3;
            }
        }
        if(!stack.isEmpty()){
            ans=0;
        }
        System.out.println(ans);
    }
}
