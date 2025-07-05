import java.util.Scanner;

public class janghoon_SW1486 {
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
			
			jibhab(0,0);
			System.out.println("#"+test_case+" "+sum-H);
		}
	}
	private static void jibhab(int cnt,int max) {
		if(max>=H) {
			sum= Math.min(sum, max);
			return;
		}
		if(cnt==N) {
			return;
		}
		jibhab(cnt+1,max+arr[cnt]);
		jibhab(cnt+1,max);
	}
}
