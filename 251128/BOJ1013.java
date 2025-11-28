import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BOJ1013 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        Pattern p = Pattern.compile("^(100+1+|01)+$");
        for (int i = 0; i < T; i++) {
            String input = br.readLine();
            Matcher m = p.matcher(input);
            if(m.matches()){
                sb.append("YES").append("\n");
            }
            else{
                sb.append("NO").append("\n");
            }
        }
        System.out.println(sb);
    }
}
