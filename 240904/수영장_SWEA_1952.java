import java.util.Scanner;
import java.io.FileInputStream;


public class 수영장_SWEA_1952
{
	static int montharr[],day,month,month3,year,an;
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			day=sc.nextInt();
			month=sc.nextInt();
			month3=sc.nextInt();
			year=sc.nextInt();
			montharr= new int[12];

			for(int i=0;i<12;i++) {
				montharr[i]=sc.nextInt();
			}
			an=year;
			solution(0,0);
			System.out.println("#"+test_case+" "+an);
		}
	}
	private static void solution(int cnt, int money) {
		if(an<money) return;
		if(cnt>=12) {
			an=money;
			return;
		}
		if(montharr[cnt]!=0) {
			solution(cnt+1,money+montharr[cnt]*day);
			solution(cnt+1,money+month);
			solution(cnt+3,money+month3);
		}
		else solution(cnt+1,money);
	}
}