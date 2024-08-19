
import java.util.Scanner;
import java.io.FileInputStream;


public class yo_SW_4012
{
	static int N,an;
	static int[][] arr;
	static boolean []check;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			N= sc.nextInt();
			arr= new int[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0; j<N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			an=Integer.MAX_VALUE;
			check= new boolean[N];
			combination(0,0);
			System.out.println(an);
		}
	}
	//부분 집합을 이용하여 2가지인 경우를 다 구한 뒤 계산하여 최소 차 구하기
	public static void combination(int cnt, int point) { //부분집합
		if(point==N/2) {
			int A=0;
			int B=0;
			for(int i=0;i<N;i++) {
				if(check[i]) {
					for(int j=0;j<N;j++) {
						if(check[j]) A=A+arr[i][j];
					}		
				}
				else {
					for(int j=0;j<N;j++) {
						if(!check[j]) B=B+arr[i][j];
					}		
				}
			}
			int sum=Math.abs(A-B);
			an=Math.min(an,sum);
			return;
		}
		if(cnt == N) {
			for(int i=0;i<N;i++) {
				if(check[i]) System.out.print(i +" ");
			}
			System.out.println();
			return;
		}
			check[cnt]=true;
			combination(cnt+1,point+1);
			check[cnt]=false;
			combination(cnt+1,point);
		}
	}
