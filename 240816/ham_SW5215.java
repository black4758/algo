import java.util.Scanner;

public class ham_SW5215 {
    static int[][] arr;
    static int N;
    static int L;
    static int re;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 1; t <= T; t++) {
            N=scanner.nextInt();
            L=scanner.nextInt();
            re=0;
            arr = new int[N][2];
            for (int i = 0; i < N; i++) {
                arr[i][0] = scanner.nextInt();
                arr[i][1] = scanner.nextInt();
            }
            subset(0,0,0);
            System.out.println("#" + t + " " + re);
        }
    }
    private static void subset(int sc, int cal, int cnt ) {

        if(cal>L) {
            return ;
        }
        if (cnt == N) {
            if (sc > re) {
                re = sc;
            }
            return;
        }

        subset(sc+arr[cnt][0],cal+arr[cnt][1],cnt+1);
        subset(sc, cal, cnt+1);


    }
}
