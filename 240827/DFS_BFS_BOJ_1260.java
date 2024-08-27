import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class DFS_BFS_BOJ_1260 {
	static int N;
	static int[][]adjMatrix;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N= sc.nextInt();
		int M= sc.nextInt();
		int st= sc.nextInt();
		adjMatrix= new int[N+1][N+1];
		for(int i=0;i<M;i++) {
			int from=sc.nextInt();
			int to=sc.nextInt();
			adjMatrix[to][from]=adjMatrix[from][to]=1;
		}

		
		dfs(st,new boolean[N+1]);
		System.out.println();
		bfs(st);
	}
	private static void dfs(int cur,boolean[] visited) {

		visited[cur]=true;
			
		System.out.print((cur+" "));
			
		for(int i=1;i<=N;i++) {
			if(adjMatrix[cur][i]==0||visited[i]) continue;
			dfs(i,visited);
		}
	}
	
	private static void bfs(int start) {
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[N+1];
		
		visited[start]=true;
		queue.offer(start);
		
		while (! queue.isEmpty()) {
			int cur=queue.poll();
			
			System.out.print((cur+" "));
			
			for(int i=1;i<=N;i++) {
				if(adjMatrix[cur][i]==0||visited[i]) continue;
				
				visited[i]=true;
				queue.offer(i);
			}
		}
	}

	
}
