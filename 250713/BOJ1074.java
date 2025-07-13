import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1074 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r= Integer.parseInt(st.nextToken());
        int c= Integer.parseInt(st.nextToken());
        int ans = 0;
        while (N > 0) {
            int line= (int) Math.pow(2,N-1);
            int size= line*line;
            if(r<line && c<line) {

            }
            if(r<line && c>=line) {
                ans+=size;
                c-=line;
            }
            if(r>=line && c<line) {
                ans+=size*2;
                r-=line;
            }
            if(r>=line && c>=line) {
                ans+=size*3;
                r-=line;
                c-=line;
            }
            N--;
        }
        System.out.println(ans);
    }
}
