import java.util.Scanner;

public class SWEA_3307 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t= sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			int N= sc.nextInt();
			int[] arr = new int[N];
			int[] dp = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i]=sc.nextInt();
			}
			int max=-1;
			for (int i = 0; i < N; i++) {
				dp[i]=1;
				for (int j = 0; j < i; j++) {
					if(arr[j]<arr[i] && dp[i]<dp[j]+1) {
						dp[i]=dp[j]+1;
					}
				}
				max=Math.max(max, dp[i]);
			}
			System.out.println("#"+tc+" "+max);
		}
	}
}
