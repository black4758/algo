import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ4153 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == 0 && b==0 && c == 0) {
                break;
            }
            int[] arr ={a,b,c};
            Arrays.sort(arr);
            if(arr[2]*arr[2]==arr[0]*arr[0] + arr[1]*arr[1]) {
                sb.append("right").append("\n");
            }
            else sb.append("wrong").append("\n");
        }
        System.out.print(sb);
    }
}
