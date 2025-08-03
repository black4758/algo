import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1107 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int M = Integer.parseInt(br.readLine());
        int ans =Math.abs(100-Integer.parseInt(input));
        if (M==0){
            ans=Math.min(ans,input.length());
            System.out.println(ans);
            return;
        }
        boolean[] fArr = new boolean[10];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) {
            fArr[Integer.parseInt(st.nextToken())] = true;
        }
        String num ="";
        for (int i = 0; i < 999999; i++) {
            boolean check = true;
            String s = String.valueOf(i);
            for (int j =0;j<s.length();j++) {
                if (fArr[s.charAt(j)-'0']) {
                    check =false;
                    break;
                }
            }
            if(check){
                ans= Math.min(ans,Math.abs(Integer.parseInt(input)-i)+ String.valueOf(i).length());
            }
        }
        System.out.println(ans);
    }
}
