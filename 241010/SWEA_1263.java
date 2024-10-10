
import java.util.Scanner;

public class SWEA_1263 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc= sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			int N= sc.nextInt();
			int[][] arr= new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j]= sc.nextInt();
					if(i != j && arr[i][j]==0) {
						arr[i][j]=10000;
					}
				}
			}
			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					//if(i==k) continue;
					for (int j = 0; j < N; j++) {
						//if(j==k || i==j) continue;
						arr[i][j]=Math.min(arr[i][k]+arr[k][j], arr[i][j]);
					}
				}
			}
			int cnt;
			int an=Integer.MAX_VALUE;
			for (int i = 0; i <N; i++) {
				cnt=0;
				for (int j = 0; j < N; j++) {
					cnt+=arr[i][j];
				}
				an=Math.min(an,cnt);
			}
			System.out.println("#"+t+" "+an);
		}
	}

}
