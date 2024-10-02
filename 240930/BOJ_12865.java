import java.util.Iterator;
import java.util.Scanner;

public class BOJ_12865 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N= sc.nextInt();
		int K= sc.nextInt();
		int[][] product = new int[N+1][2];
		int[][] DP = new int[N+1][K+1];
		for (int i = 1; i <=N ; i++) {
			product[i][0]=sc.nextInt();
			product[i][1]=sc.nextInt();
		}
		for (int i = 1; i <=N ; i++) {
			for (int j = 0; j <=K ; j++) {
				if(product[i][0]>j) {
					DP[i][j]=DP[i-1][j];
				}
				else {

					 DP[i][j]= Math.max(DP[i-1][j-product[i][0]]+product[i][1], DP[i-1][j]);
				}
			}
		}
		System.out.println(DP[N][K]);
	}

}
