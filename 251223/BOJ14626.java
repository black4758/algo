import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ14626 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int sum = 0;
        int state =1;
        for (int i = 0; i < 13; i++) {
            if(i%2==0){
                if(input.charAt(i)!='*'){
                    sum += (input.charAt(i)-'0');
                }

            }
            else{
                if(input.charAt(i)=='*'){
                    state=3;
                }
                else{
                    sum += (3*(input.charAt(i)-'0'));
                }
            }
        }
        for (int i = 0; i <= 9; i++) {
            if((sum+i*state)%10==0){
                System.out.println(i);
                break;
            }
        }
    }
}
