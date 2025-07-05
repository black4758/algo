

import java.util.Arrays;
import java.util.Scanner;

public class SWEA3421 {
    static int arr[][],n,m,an;
    static boolean visited[];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int t = 1; t <= T; t++) {
            an=0;
            n = scanner.nextInt();
            m = scanner.nextInt();
            arr = new int[m][2];
            for (int i = 0; i < m; i++) {
                arr[i][0] = scanner.nextInt();
                arr[i][1] = scanner.nextInt();
            }
            visited = new boolean[n+1];
            subset(1);
            System.out.println("#" + t + " " + an);
        }
    }
    public static void subset(int cnt) {
        if(cnt == n+1) {
            for (int i = 0; i < m; i++) {
                if(visited[arr[i][0]] && visited[arr[i][1]]) {
                    return;
                };
            }
            an++;
            return;
        }
        visited[cnt] = true;
        subset(cnt + 1);
        visited[cnt] = false;
        subset(cnt + 1);
    }
}
