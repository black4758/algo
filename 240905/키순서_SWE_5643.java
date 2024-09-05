import java.awt.List;
import java.util.LinkedList;
import java.util.Scanner;

public class 키순서_SWE_5643 {
	static LinkedList<Integer>[] list ;
	static boolean[] visited;
	static int[] countArr;
	static int out;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T= sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int N=sc.nextInt();
			int M =sc.nextInt();
			list =new LinkedList[N+1];
			countArr= new int[N+1]; //나를 거처간것 + 내가 진출한 갯수 배열
			for (int j = 1; j <= N; j++) {
				list[j]=new LinkedList<>();
			}
			for (int j = 0; j < M; j++) {
				list[sc.nextInt()].add(sc.nextInt());
			}
			
			for (int i = 1; i < N+1 ; i++) {
				out=0;
				visited=new boolean[N+1]; //방문 확인
				visited[i]=true;
				dfs(i);
				countArr[i]+=out;
			}
			int an=0;
			for (int i = 1; i <= N; i++) {
				if(countArr[i]==N) {
					an++;
				}
			}
			System.out.println("#"+" "+an);
		}
	}
	private static void dfs(int i) {
		out++;
		for(int next :list[i] ) {
			if (!visited[next]) {
				visited[next]= true;
				countArr[next]++;
				dfs(next);
			}
		}
		
	}
}
