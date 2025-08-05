import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1065 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        if(X<100){
            System.out.println(X);
            return;
        }
        int cnt=99;
        for (int i = 100; i <= X; i++) {
            int a0 = i/100;
            int a1 = (i%100)/10;
            int a2 = (i%100)%10;
            if(a0-a1==a1-a2){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
