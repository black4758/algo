import java.util.Scanner;

public class hanbin_Spot_Mart_SW_9229
{
	static int M,N,arr[],an;
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();


		for(int test_case = 1; test_case <= T; test_case++)
		{
			// 입력
			an=-1;
			N=sc.nextInt();
			M=sc.nextInt();
			arr=new int[N];
			for(int i=0;i<N;i++) {
				arr[i]=sc.nextInt();
			}
			combination(0,0,0);
			System.out.println("#"+test_case+" "+an);
		}
	}
	private static void combination(int cnt, int st, int sum) {
		if(cnt==2) {
			if(sum<=M) {
				an=Math.max(an, sum);
			}
			return;
		}
		for(int i=st;i<N;i++) {
			combination(cnt+1,i+1,sum+arr[i]);
		}
	}
}