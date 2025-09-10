import java.io.*;

public class BOJ1992 {
    static int [][] map;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }
        sb=new StringBuilder();
        solution(0,0,N);
        System.out.println(sb);
    }

    static void solution(int x, int y, int n) {
        int st= map[x][y];
        boolean flag = true;
        for (int i = x; i < x+n; i++) {
            for (int j = y; j < y+n; j++) {
                if (map[i][j] != st) {
                    flag = false;
                    break;
                }
            }
        }
        if (flag) {
            sb.append(st);
        }
        else {
            sb.append('(');
            n/=2;
            solution(x, y, n);
            solution(x, y + n, n);
            solution(x + n, y, n);
            solution(x + n, y + n, n);
            sb.append(')');
        }
    }
}
