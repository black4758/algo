import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2630 {
    static int N,white,blue;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N= Integer.parseInt(br.readLine());
        map = new int[N][N];
        white = 0;
        blue = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solution(0,0,N);
        System.out.println(white);
        System.out.println(blue);
    }

    private static void solution(int x, int y, int size) {
        int sum = 0;
        for (int i = x; i < x+size; i++) {
            for (int j = y; j < y+size; j++) {
                sum += map[i][j];
            }
        }
        if (sum == size*size) {
            blue++;
            return;
        }
        else if (sum == 0) {
            white++;
            return;
        }
        else {
            int half=size/2;
            solution(x, y, half);
            solution(x, y+half, half);
            solution(x+half, y, half);
            solution(x+half, y+half, half);
        }
    }
}
