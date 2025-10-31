import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (--T >= 0) {
            String input = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String inputArr = br.readLine();
            Deque<Integer> q = new ArrayDeque<>();
            StringTokenizer st = new StringTokenizer(inputArr.substring(1, inputArr.length()-1), ",");
            while (st.hasMoreTokens()) {
                q.addLast(Integer.parseInt(st.nextToken()));
            }
            boolean check = false;
            boolean empty =false;
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == 'R') {
                    check = !check;
                }
                else {
                    if(q.isEmpty()){
                        empty = true;
                        break;
                    }
                    if (check) {
                        q.pollLast();
                    }
                    else {
                        q.pollFirst();
                    }
                }
            }
            if(empty){
                sb.append("error").append("\n");
            }
            else {
                sb.append("[");
                while (!q.isEmpty()) {
                    if(check){
                        sb.append(q.pollLast());
                    }
                    else {
                        sb.append(q.pollFirst());
                    }
                    if (!q.isEmpty()) {
                        sb.append(",");
                    }
                }
                sb.append("]").append("\n");
            }
        }
        System.out.println(sb);
    }
}
