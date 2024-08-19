import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;

public class Number_SW4008
{
	static int [] store,giarr,arr;
	static int N,min,max;
	public static void main(String args[]) throws Exception
	{
		//풀이법 모든 기호의 경우릐 수를 순열로 구한뒤 계산을 하여 최소값과 최대값을 구한다
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		

		for(int test_case = 1; test_case <= T; test_case++)
		{
			 N= sc.nextInt();
			
			arr= new int[N]; //숫자 배열
			giarr= new int[4];//일력받은 기호 저장
			store= new int[N-1];//기호 순열 만들시 필요한 배열
			
			for(int i=0;i<4;i++) {
				giarr[i]=sc.nextInt();
			}
			for(int i=0;i<N;i++) {
				arr[i]=sc.nextInt();
			}
			 max= Integer.MIN_VALUE;
			 min= Integer.MAX_VALUE;
			sun(0);
			System.out.println("#"+test_case+" "+(max-min));
		}
	}

	private static void sun(int cnt) {
		if(cnt==N-1) {
			int sum=arr[0]; //구한 기호로 계산
			for(int i=0;i<N-1;i++) {
				if(store[i]==0) {
					sum+=arr[i+1];
					continue;
				}
				if(store[i]==1) {
					sum-=arr[i+1];
					continue;
				}
				if(store[i]==2) {
					sum*=arr[i+1];
					continue;
				}
				if(store[i]==3) {
					sum/=arr[i+1];
					continue;
				}
				
			}
			max= Math.max(max, sum);
			min= Math.min(min, sum);
			return;
		}
		for(int i=0;i<4;i++) {
			if(giarr[i] ==0) continue;
				
			store[cnt]=i;
			giarr[i]--;
				
			sun(cnt+1);
			giarr[i]++;
				

		}
	}
}