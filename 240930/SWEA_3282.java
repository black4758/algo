import java.util.Scanner;

public class SWEA_3282 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int Tc= sc.nextInt();
		for (int t = 1; t <=Tc; t++) {
			int N= sc.nextInt();
			int K= sc.nextInt();
			int object[][]= new int[N+1][2];
			int dp[][]= new int[N+1][K+1];
			for (int i = 1; i <=N; i++) {
				object[i][0]=sc.nextInt();
				object[i][1]=sc.nextInt();
			}
			for (int i = 1; i <= N; i++) {
				for (int j = 0; j <=K; j++) {
					if(object[i][0]>j) {
						dp[i][j]=dp[i-1][j];
					}
					else {
						dp[i][j]=Math.max( dp[i-1][j],dp[i-1][j-object[i][0]]+object[i][1]);
					}
						
				}
			}
			System.out.println("#"+t+" "+dp[N][K]);
		}

	}
}
