import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17485 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] input = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][][] arr = new int[n][m][3];
        for (int i = 0; i < m; i++) {
            arr[0][i][0] = arr[0][i][1] = arr[0][i][2] = input[0][i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j == 0) {
                    arr[i][j][0] = Integer.MAX_VALUE;
                }
                else {
                    arr[i][j][0] = input[i][j] + Math.min(arr[i - 1][j - 1][1], arr[i - 1][j - 1][2]);
                }

                arr[i][j][1] = input[i][j] + Math.min(arr[i - 1][j][0], arr[i - 1][j][2]);

                if (j == m - 1) {
                    arr[i][j][2] = Integer.MAX_VALUE;
                }
                else {
                    arr[i][j][2] = input[i][j] + Math.min(arr[i - 1][j + 1][0], arr[i - 1][j + 1][1]);
                }

            }

        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 3; j++) {
                ans = Math.min(ans, arr[n - 1][i][j]);
            }
        }
        System.out.println(ans);
    }
}
