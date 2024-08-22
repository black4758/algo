
import java.util.Scanner;
import java.io.FileInputStream;


public class NQueen_SW_2806
{
	public static int[] col;
	public static int N,ans=0;
	public static int count = 0;
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();


		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			N = sc.nextInt();
			col = new int[N+1];
			ans=0;
			setQueen(1);
			System.out.println(ans);
		}
	}
	public static void setQueen(int rowNo) {
		if(!isAvailable(rowNo-1)) {
			return;
		}
		if(rowNo>N) {
			ans++;
			return;
		}
		for (int c = 1; c <= N; c++) {
			col[rowNo]=c;

			setQueen(rowNo+1);
		}
 
	}
 
	public static boolean isAvailable(int rowNo) {
		for (int k = 1; k < rowNo; k++) {
			if(col[rowNo]==col[k]||rowNo-k==Math.abs(col[rowNo]-col[k]))return false;
			
		}
		return true;
 
		
	}
}