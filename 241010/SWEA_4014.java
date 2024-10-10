import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4014 {
    static int N, X, an;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            an = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            int[][] map = new int[N][N]; 
            int[][] map2 = new int[N][N]; 

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    map2[j][i] = map[i][j];
                }
            }

            AirLine(map);
            AirLine(map2);
            System.out.println("#" + tc + " " + an);
        }
    }

    private static void AirLine(int[][] map) {
        for (int i = 0; i < N; i++) {
            boolean[] used = new boolean[N];
            boolean check = true;

            for (int j = 0; j < N - 1; j++) {
                // 다음칸이랑 차이가 2이상이면 X
                if (Math.abs(map[i][j] - map[i][j + 1]) > 1) {
                	check = false;
                    break;
                }

                // 내리막 
                if (map[i][j] > map[i][j + 1]) {
                    for (int k = 1; k <= X; k++) {
                        if (j + k >= N || map[i][j + 1] != map[i][j + k] || used[j + k]) {
                        	check = false;
                            break;
                        }
                        used[j + k] = true;
                    }
                }

                // 오르막
                else if (map[i][j] < map[i][j + 1]) {
                    for (int k = 1; k <= X; k++) {
                        if (j - k < 0 || map[i][j] != map[i][j - k] || used[j - k]) {
                        	check = false;
                            break;
                        }
                        used[j - k] = true;
                    }
                }

                if (!check) {
                    break;
                }
            }

            if (check) {
                an++;
            }
        }
    }
}
