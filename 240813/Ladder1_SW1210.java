import java.util.Scanner;
import java.io.FileInputStream;


public class Ladder1_SW1210
{
	static int  [][] arr;
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;

		//풀이법 2를 찾은 후 거꾸로 탐색을 하여 값을 찾는다
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			
			int a= sc.nextInt();
			int stx = 0,sty=0;
			arr = new int[100][100];
			for(int i=0;i<100;i++) {
				for(int j=0;j<100;j++) {
					arr[i][j]=sc.nextInt();
					if(arr[i][j]==2) {
						stx=i;
						sty=j;
					}
				}
			}
			solution(a,stx,sty);
		}
		
	}
	private static void solution(int a, int stx, int sty) {
		int[] dx= {0,0,-1};
		int[] dy= {-1,1,0}; //왼쪽 오른쪽 위쪽 순으로 
		while(stx!=0) {
			for(int i=0;i<3;i++) {
				int new_x=stx+dx[i];
				int new_y=sty+dy[i];
				if(new_x>=0&&new_x<100&&new_y>=0&&new_y<100&&arr[new_x][new_y]==1) {
					arr[stx][sty]=10;
					stx=new_x;
					sty=new_y;
				}
			}
		}
		System.out.println("#"+a+" "+sty);
	}
}