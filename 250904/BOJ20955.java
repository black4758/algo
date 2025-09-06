import java.io.*;
import java.util.*;

public class BOJ20955 {
    static int [] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr=new int[N+1];
        int ans = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(!union(a,b)) {
                ans++;
            }
        }

        for (int i = 1; i < N; i++) {
            if(union(i,i+1)){
                ans++;
            }
        }

//        Set<Integer> set = new HashSet<>(); set으로 그룹 수 찾기
//        for (int i = 1; i <= N; i++) {
//            set.add(find(i));
//        }
//        ans += set.size()-1;

        System.out.println(ans);
    }
    static int find(int x) {
        if(arr[x]==0) return x;
        return arr[x]=find(arr[x]);
    }
    static boolean union(int a, int b) {
        int aRoot =find(a);
        int bRoot =find(b);
        if(aRoot==bRoot) return false;
        arr[bRoot]=aRoot;
        return true;
    }
}
