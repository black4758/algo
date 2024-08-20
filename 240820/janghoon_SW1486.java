import java.util.Scanner;

public class Solution {
	static int [] arr;
	static int N,H,sum;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			 N= sc.nextInt();
			 H= sc.nextInt();
			arr= new int[H];
			for(int i=0;i<N;i++) {
				arr[i]=sc.nextInt();
			}
			sum=Integer.MAX_VALUE;
			
			combination(0,0);
			System.out.println("#"+test_case+" "+sum-H);
		}
	}
	private static void combination(int cnt,int max) {
		if(sum>max) return;
		if(max>=H) {
			sum= Math.min(sum, max);
			return;
		}
		if(cnt==N) {
			return;
		}
		combination(cnt+1,max+arr[cnt]);
		combination(cnt+1,max);
	}
}
