import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ10816 {
    public static void main(String[] args) throws IOException {
        HashMap<Integer,Integer> map=new HashMap<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine()," ");
        for(int i=0;i<n;i++){
            int input=Integer.parseInt(st.nextToken());
            map.put(input,map.getOrDefault(input,0)+1);
        }
        int M=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();
        st=new StringTokenizer(br.readLine()," ");
        for(int i=0;i<M;i++){
            int now=Integer.parseInt(st.nextToken());
            sb.append(map.getOrDefault(now,0)).append(" ");
        }
        System.out.println(sb);
    }
}
