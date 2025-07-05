import java.util.Scanner;
import java.io.FileInputStream;


class DalNumber1954
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



// public class dal_number_1954 {
//     static int[] dx={0,1,0,-1};
//     static int[] dy={1,0,-1,0};
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         int T = scanner.nextInt();

//         for (int t = 1; t <= T; t++) {
//             int dir=0;
//             int n = scanner.nextInt();
//             int[][] arr = new int[n][n];
//             int x = 0 ;
//             int y = 0 ;
//             for (int i = 0; i < n; i++) {
//                 for (int j = 0; j < n; j++) {
//                     arr[x][y]=i*n+j+1;

//                     int nx=x+dx[dir];
//                     int ny=y+dy[dir];
//                     if(!(nx>=0 && nx<n && ny>=0 && ny<n && arr[nx][ny]==0)){
//                         dir=(dir+1)%4;
//                     }
//                     x=x+dx[dir];;
//                     y=y+dy[dir];
//                 }
//             }
//             System.out.println("#" + t);
//             for (int i = 0; i < n; i++) {
//                 for (int j = 0; j < n; j++) {
//                     System.out.print(arr[i][j] + " ");
//                 }
//                 System.out.println();
//             }
//         }
//     }
// }
