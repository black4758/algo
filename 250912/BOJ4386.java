import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ4386 {
//    static int[] parent; //유니온파인드
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        double[][] input = new double[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            input[i][0] = Double.parseDouble(st.nextToken());
            input[i][1] = Double.parseDouble(st.nextToken());
        }
        boolean[] visited = new boolean[n];
        visited[0] = true;
        PriorityQueue<double[]> pq = new PriorityQueue<>((o1,o2)->Double.compare(o1[1], o2[1]));
        for (int i = 1; i < n; i++) {
            double x = input[0][0] - input[i][0];
            double y = input[0][1] - input[i][1];
            pq.add(new double[]{i,Math.sqrt(x*x + y*y)});
        }
        double ans = 0;
        int cnt = 1;
        while (!pq.isEmpty() && cnt<n) {
            double[] now = pq.poll();
            int index=(int)now[0];
            if(!visited[index]) {
                visited[index] = true;
                cnt++;
                ans += now[1];
                for (int i = 0; i < n; i++) {
                    if(!visited[i]){
                        double x = input[index][0] - input[i][0];
                        double y = input[index][1] - input[i][1];
                        pq.add(new double[]{i,Math.sqrt(x*x + y*y)});
                    }
                }
            }
        }
        System.out.printf("%.2f\n",ans);
// 크루스칼 유니온 파인드 코드
//        parent = new int[n];
//        for (int i = 0; i < n; i++) {
//            parent[i] = i;
//        }
//        List<double[]> list = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            for (int j = i + 1; j < n; j++) {
//                double x = input[i][0] - input[j][0];
//                double y = input[i][1] - input[j][1];
//                list.add(new double[]{i, j,Math.sqrt(x*x + y*y)});
//            }
//        }
//        list.sort((o1, o2) -> Double.compare(o1[2], o2[2]));
//        double ans = 0;
//        int count = 0;
//        for(double[] now : list) {
//            if(union((int)now[0],(int)now[1])){
//                count++;
//                ans+=now[2];
//                if(count == n-1) break;
//            }
//        }
//        System.out.printf("%.2f\n",ans);
    }
//    static int find(int x) {
//        if (parent[x] == x) {
//            return x;
//        }
//        return parent[x] = find(parent[x]);
//    }
//    static boolean union(int a, int b) {
//        int rootA = find(a);
//        int rootB = find(b);
//        if (rootA == rootB) {
//            return false;
//        }
//        parent[rootB] = rootA;
//        return true;
//    }
}
