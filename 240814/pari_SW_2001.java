///////////////////////////////////////////
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileInputStream;

public class pari_SW_2001
{
	public static void main(String args[]) throws Exception
	{


		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();


		for(int test_case = 1; test_case <= T; test_case++)
		{
			//풀이법: 누적 합으로 배열을 저장한 후 M 크기의 합을 리스트에 집어넣은 후 정렬 뒤 가장 큰 값 출력
			int N= sc.nextInt();
			int M= sc.nextInt();
			int[][] arr= new int[N+1][N+1];
			List<Integer>list= new ArrayList<>();
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					arr[i][j]=arr[i][j-1]+arr[i-1][j]-arr[i-1][j-1]+sc.nextInt(); //누적합
				}
			}
			for(int i=1;i<=N-(M-1);i++) {
				for(int j=1;j<=N-(M-1);j++) {
					list.add( arr[M+i-1][M+j-1] - arr[i-1][M+j-1] - arr[M+i-1][j-1] + arr[i-1][j-1]); //M 크기에 맞는 합을 리스트에 저장
				}
			}
			list.sort((o1,o2)->(o1-o2)*-1); //내림차순으로 정렬
			System.out.println("#"+test_case+" "+list.get(0));

		}
	}
}