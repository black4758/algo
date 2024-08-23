
import java.util.Scanner;


public class SW_1247
{	
	static int N,an;
	static position[] map;
	static position[] selected;
	static boolean[] visited;
	public static void main(String args[])
	{

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			an=Integer.MAX_VALUE;
			N=sc.nextInt();
			map = new position [N];
			selected = new position [N+2];
			visited = new boolean [N];
			selected[0]=new position(sc.nextInt(),sc.nextInt());
			selected[N+1]=new position(sc.nextInt(),sc.nextInt());
			for(int i=0;i<N;i++) {
				map[i]=new position(sc.nextInt(),sc.nextInt());
			}
			solution(1,0);
			System.out.println("#"+test_case+" "+an);
		}
	}

	private static void solution(int cnt,int sum) {
		if(sum>an) {
			return;
		}
		
		if(cnt==N+1) {
			an=Math.min(sum, an);
			return;
		}
		for(int i=0;i<N;i++) {
			if(visited[i])continue;
			visited[i]=true;
			selected[cnt]=map[i];
			if(cnt==N) {
				sum=sum+Math.abs(selected[cnt+1].x-selected[cnt].x)+Math.abs(selected[cnt+1].y-selected[cnt].y);
			}
			solution(cnt+1,sum+Math.abs(selected[cnt-1].x-selected[cnt].x)+Math.abs(selected[cnt-1].y-selected[cnt].y));
			visited[i]=false;
		}
	}


	static class position {
		int x;int y;

		public position(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}