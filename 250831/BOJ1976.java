import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1976 {
    static int [] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st=null;
        arr = new int[N+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int input=Integer.parseInt(st.nextToken());
                if(input==1){
                    union(i,j);
                }
            }
        }
        st= new StringTokenizer(br.readLine());
        int root=0;
        for(int i=0;i<M;i++){
            if(i==0){
                root=find(Integer.parseInt(st.nextToken()));
            }
            else if(root!=find(Integer.parseInt(st.nextToken()))){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
    static int find(int x){
        if(arr[x]==0){
            return x;
        }
        return arr[x]=find(arr[x]);
    }
    static void union(int a, int b){
        int rootA =find(a);
        int rootB =find(b);
        if(rootA!=rootB){
            arr[rootB]=rootA;
        }
    }
}
