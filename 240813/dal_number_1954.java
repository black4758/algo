import java.util.Scanner;
import java.io.FileInputStream;


class dal_number_1954
{
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
	        int x=0;
	        int y=-1;
	        int N = sc.nextInt();
	        int[][] arr= new int[N][N];
	        int number=1;
	        int move=N; //움직여야하는 횟수
	        int di=1; //다음칸으로 가기위한 인자
	        while(move >0) {
	            for(int i=0;i<move;i++) {
	                y=y+di;
	                arr[x][y]=number++;
	            }
	            move--;
	            if(move==0)break;
	            for(int i=0;i<move;i++) {
	                x=x+di;
	                arr[x][y]=number++; 
	            }
	            di =di*-1; //방향 전환 으로 -1로 변환
	        }
	        for(int i=0;i<N;i++) {
	            for(int j=0;j<N;j++) {
	            	System.out.print(arr[i][j]+" ");
	            }
	            System.out.println();
	        }
		}
	}
}