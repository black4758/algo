import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
public class boho_SW2112
{
	static int arr[][];
	static int an,D,W,K;
	public static void main(String args[]) throws Exception
	{

		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			D = sc.nextInt();
			W = sc.nextInt();
			K = sc.nextInt();
			arr= new int[D][W];
			for(int i=0;i<D;i++) {
				for(int j=0;j<W;j++) {
					arr[i][j]=sc.nextInt();
				}
			}
			an=Integer.MAX_VALUE;
			DFS(0,0);
			System.out.println("#"+test_case+" "+an);
		}
	}
	private static void DFS(int tc, int count) {
		// TODO Auto-generated method stub

		if(count>an)return;
		
		if(tc==D) {
			if(check()) {
				an= Math.min(an, count);
			}
			return;
		}
		int[] copy= arr[tc].clone();
		
		
		
		DFS(tc+1,count);
		
		for(int i=0;i<W;i++) 
			arr[tc][i]=0;
		
		DFS(tc+1,count+1);
		
		for(int i=0;i<W;i++) 
			arr[tc][i]=1;
		
		DFS(tc+1,count+1);
		
		arr[tc]=copy;
		
	}
	private static boolean check() {
		for(int i=0;i<W;i++) {
			int count=1;
			boolean sign =false;
			for(int j=1;j<D;j++) {
				if(arr[j][i]==arr[j-1][i])count++;
				else count=1;
				if(count==K) {
					sign=true;
					break;
				}
			}
			if(!sign) return false;
		}
		
		return true;
	}

}
