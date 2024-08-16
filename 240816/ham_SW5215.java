
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;


public class ham_SW5215
{
	static int N,L,arr[][];
	static boolean charr[];
	static ArrayList<Integer> list;
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		// 문제 풀이 부분집합을 이용하여 모든 경우의 수를 구한 뒤 주어진 칼로리 이하의 점수들을 리스트에 집어넣은 후 정렬하여 찾는다
		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			N= sc.nextInt();
			L= sc.nextInt();
			arr= new int [N][2];
			charr=new boolean [N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<2;j++) {
					arr[i][j]= sc.nextInt();
				}
			}
			list =new ArrayList<>();
			gibhab(0,0,0,0);
			
			list.sort((o1,o2)->(o1-o2)*-1); //가장 큰 점수 찾기
			if(! list.isEmpty()) {
				System.out.println(list.get(0));
			}
			else System.out.println("0");
		}
	}
	private static void gibhab(int cnt,int cal,int scol,int eCnt) {
		if(cnt == N ) {
			if (eCnt>0 && cal<=L)  {
				list.add(scol); //주어진 칼로리 이하의 합의 점수 리스트에 삽입
			}
			return ;
		}

		charr[cnt]= false;
		gibhab(cnt+1,cal,scol,eCnt);
		charr[cnt]= true;
		gibhab(cnt+1,cal+arr[cnt][1],scol+arr[cnt][0],eCnt+1);
	}
}