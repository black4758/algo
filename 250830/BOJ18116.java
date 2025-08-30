import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ18116 {
    static HashMap<Integer, long[]> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            if(input.equals("I")) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                map.putIfAbsent(a, new long[]{a, 1});
                map.putIfAbsent(b, new long[]{b, 1});
                union(a, b);
            }
            else if(input.equals("Q")) {
                int a = Integer.parseInt(st.nextToken());
                map.putIfAbsent(a, new long[]{a, 1});
                sb.append(map.get(find(a))[1]).append("\n");
            }
        }
        System.out.println(sb);
    }
    static int find(int x){
        if(map.get(x)[0]==x){
            return x;
        }
        return (int) (map.get(x)[0]=find((int)(map.get(x)[0])));
    }
    static void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA !=rootB){
            if(map.get(rootA)[1] > map.get(rootB)[1]){
                map.get(rootB)[0]=rootA;
                map.get(rootA)[1]+=map.get(rootB)[1];
            } else {
                map.get(rootA)[0]=rootB;
                map.get(rootB)[1]+=map.get(rootA)[1];
            }

        }
    }
}
