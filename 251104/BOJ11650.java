import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
       ArrayList<int[]> list = new ArrayList<>();
       for (int i = 0; i < n; i++) {
           StringTokenizer st = new StringTokenizer(br.readLine());
           int a = Integer.parseInt(st.nextToken());
           int b = Integer.parseInt(st.nextToken());
           list.add(new int[]{a, b});
       }
       list.sort((o1,o2)->{
           if (o1[0] == o2[0]) {
               return o1[1] - o2[1];
           }
           else return o1[0]-o2[0];
       });
       StringBuilder sb = new StringBuilder();
       for(int[] now : list) {
           sb.append(now[0]).append(" ").append(now[1]).append("\n");
       }
       System.out.print(sb.toString().trim());
    }
}
