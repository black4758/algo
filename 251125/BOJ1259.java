import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder sb = new StringBuilder();
        while(!input.equals("0")){
            boolean flag = true;
            int left =0;
            int right = input.length()-1;
            while(left<right){
                if(input.charAt(left)==input.charAt(right)){
                    left++;
                    right--;
                }
                else{
                    flag = false;
                    break;
                }
            }
            if(flag){
                sb.append("yes").append("\n");
            }
            else{
                sb.append("no").append("\n");
            }
            input = br.readLine();
        }
        System.out.print(sb.toString().trim());

    }
}
