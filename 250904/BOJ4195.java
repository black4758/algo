import java.io.*;
import java.util.*;


public class BOJ4195 {
    static int[] arr,cnt;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            HashMap<String,Integer> map = new HashMap();
            int F = Integer.parseInt(br.readLine());
            arr = new int[F*2+1];
            cnt=new int[F*2+1];
            Arrays.fill(cnt,1);
            int num=1;
            for (int i = 0; i < F; i++) {
                String a,b;
                StringTokenizer st = new StringTokenizer(br.readLine());
                a=st.nextToken();
                b=st.nextToken();
                if(!map.containsKey(a)) {
                    map.put(a,num++);
                }
                if(!map.containsKey(b)) {
                    map.put(b,num++);
                }
                sb.append(union(map.get(a),map.get(b))).append("\n");
            }
        }
        System.out.println(sb);
    }
    static int find(int x){
        if(arr[x]==0){
            return x;
        }
        return arr[x]=find(arr[x]);
    }
    static int union(int a,int b){
        int rootA=find(a);
        int rootB=find(b);
        if(rootA!=rootB){
            arr[rootB]=rootA;
            cnt[rootA]+=cnt[rootB];
        }
        return cnt[rootA];
    }
}
