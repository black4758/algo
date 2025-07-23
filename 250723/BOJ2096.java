import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2096 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] max=new int[3];
        int[] min=new int[3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int n3 = Integer.parseInt(st.nextToken());
            if (i == 0) {
                min[0] = max[0] = n1;
                min[1] = max[1] = n2;
                min[2] = max[2] = n3;
            } else {
                int max1 = max[0], max2 = max[1], max3 = max[2];
                int min1 = min[0], min2 = min[1], min3 = min[2];

                max[0] = n1 + Math.max(max1, max2);
                max[1] = n2 + Math.max(max1, Math.max(max2, max3));
                max[2] = n3 + Math.max(max2, max3);

                min[0] = n1 + Math.min(min1, min2);
                min[1] = n2 + Math.min(min1, Math.min(min2, min3));
                min[2] = n3 + Math.min(min2, min3);
            }
        }
        int maxRe=Math.max(max[0],Math.max(max[1],max[2]));
        int minRe=Math.min(min[0],Math.min(min[1],min[2]));
        System.out.println(maxRe+" "+minRe);
    }
}
