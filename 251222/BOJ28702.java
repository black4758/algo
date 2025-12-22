import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ28702 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = new String[3];
        int [] num = new int[3];
        for (int i = 0; i < 3; i++) {
            input[i] = br.readLine();
            if (!input[i].equals("FizzBuzz") && !input[i].equals("Fizz") && !input[i].equals("Buzz")) {
                num[i] = Integer.parseInt(input[i]);
            }
        }
        for (int i = 0; i < 3; i++) {
            if (num[i] !=0) {
                for (int j = 1; j < 3; j++) {
                    if (i-j>=0 && num[i-j]==0) {
                        num[i-j] = num[i]-j;
                    }
                    if (i+j<3 && num[i+j]==0) {
                        num[i+j] = num[i]+j;
                    }
                }
            }
        }
        int ans = num[2]+1;
        if(ans%15==0){
            System.out.println("FizzBuzz");
        }
        else if(ans%3==0){
            System.out.println("Fizz");
        }
        else if(ans%5==0){
            System.out.println("Buzz");
        }
        else {
            System.out.println(ans);
        }
    }
}
