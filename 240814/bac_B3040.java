import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bac_B3040 {
    static int arr[];
    static int num[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr=new int[9];
        num=new int[7];
        for (int i = 0; i < 9; i++) {
            arr[i]=Integer.parseInt(br.readLine());
        }
        combination(0,0,0);
    }
    static void combination(int cnt, int st, int sum) {
        if(sum>100){
            return;
        }
        else if (cnt == 7) {
            if(sum==100){
                for(int i=0;i<7;i++){
                    System.out.println(num[i]);
                }
                System.exit(0);
            }
            return;
        }
        for(int i=st;i<9;i++){
            num[cnt]=arr[i];
            combination(cnt+1,i+1,sum+num[cnt]);
        }

    }
}
