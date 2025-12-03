import java.io.*;
import java.util.*;

public class BOJ1874 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(br.readLine().trim());
        }

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int now = 1;

        for (int i = 0; i < n; i++) {

            while (now <= input[i]) {
                stack.push(now);
                sb.append("+\n");
                now++;
            }


            if (stack.peek() == input[i]) {
                stack.pop();
                sb.append("-\n");
            } else {
                System.out.println("NO");
                return;
            }
        }

        System.out.print(sb.toString());
    }
}
