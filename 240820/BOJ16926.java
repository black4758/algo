import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16926 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] newArr = new int[N][M];
        int numLayers = Math.min(N, M) / 2;

        // dx, dy 정의 (시계 방향: 우, 하, 좌, 상)
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        for (int i = 0; i < numLayers; i++) {
            int rStart = i, cStart = i;
            int rEnd = N - 1 - i, cEnd = M - 1 - i;
            int perimeter = 2 * (rEnd - rStart) + 2 * (cEnd - cStart);
            if (perimeter == 0) continue;

            int[][] coords = new int[perimeter][2];
            int[] values = new int[perimeter];

            int x = rStart, y = cStart;
            int dir = 0; // 0: 오른쪽, 1: 아래, 2: 왼쪽, 3: 위

            for (int j = 0; j < perimeter; j++) {
                coords[j] = new int[]{x, y};
                values[j] = arr[x][y];

                // 다음 위치 계산
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < rStart || nx > rEnd || ny < cStart || ny > cEnd) {
                    dir = (dir + 1) % 4;
                }

                x += dx[dir];
                y += dy[dir];
            }

            // 회전 계산 및 새 배열에 값 배치
            int effectiveR = R % perimeter;
            for (int j = 0; j < perimeter; j++) {
                int[] destCoord = coords[j];
                int sourceVal = values[(j + effectiveR) % perimeter];
                newArr[destCoord[0]][destCoord[1]] = sourceVal;
            }
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(newArr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}
