import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2529 {
    static boolean[] visited;
    static int K;
    static String input ,now,min,max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        input = br.readLine().replace(" ", "");
        visited = new boolean[10];
        now = "";
        solution(0);
        System.out.println(max);
        System.out.println(min);
    }
    private static void solution(int cnt) {
        if (cnt==K+1) {
            if (min==null){
                min=now;
            }
            max = now;

            return;
        }
        for (int i = 0; i <= 9; i++) {
            if (!visited[i]) {
                if((cnt==0) ||
                        (input.charAt(cnt-1)=='<' && now.charAt(cnt-1) -'0' < i) ||
                        (input.charAt(cnt-1)=='>' && now.charAt(cnt-1) -'0'> i)){
                    visited[i] = true;
                    now+=i;
                    solution(cnt + 1);
                    visited[i] = false;
                    now=now.substring(0,now.length()-1);
                }
            }
        }
    }
}

