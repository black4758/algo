
import java.util.Scanner;


public class sum_5_B11660_last {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] arr = new int[N+1][N+1];
        for(int i=1; i<N+1; i++) {
            for(int j=1; j<N+1; j++) {
            	arr[i][j] = arr[i][j-1] + arr[i-1][j] - arr[i-1][j-1] +sc.nextInt();
            	// 누적 합은 나의 값에 왼쪽 위쪽 값을 더하고 중복으로 더한 값을 제거한다
            }
        }

        int answer = 0;
        for(int i=0; i<M; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            answer = arr[x2][y2] - arr[x1-1][y2] - arr[x2][y1-1] + arr[x1-1][y1-1];
          //전체 크기에 빈 공간 위, 왼쪽 왼쪽 빈 공간을 제거하고 중복으로 제거한 값을 더해준다
            System.out.println(answer);
        }
    }
}
