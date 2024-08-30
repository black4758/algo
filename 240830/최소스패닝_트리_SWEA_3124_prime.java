import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;


public class 최소스패닝_트리_SWEA_3124_prime {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T= sc.nextInt();
		for(int t=1;t<=T;t++) {
			int v=sc.nextInt();
			int e=sc.nextInt();
			ArrayList<Edge>[] list = new ArrayList[v+1];
			for(int i=0;i<=v;i++) {
				list[i] = new ArrayList<>();
			}
			for(int i=0;i<e;i++) {
				int x=sc.nextInt();
				int y=sc.nextInt();
				int w=sc.nextInt();
				list[x].add(new Edge(y, w));
				list[y].add(new Edge(x, w));
			}
			boolean[] visit = new boolean[v+1];
			PriorityQueue<Edge> q = new PriorityQueue<Edge>(new Comparator<Edge>() {

				@Override
				public int compare(Edge o1, Edge o2) {
					
					return Integer.compare(o1.weight, o2.weight);
				}
			});
			q.add(new Edge(1,0));
			int cnt=0;
			long cost=0;
			while(!q.isEmpty()) {
				Edge now =q.poll();
				if(visit[now.end])continue;
				cost += now.weight;
				visit[now.end]=true;
				for(Edge next : list[now.end]) {
					if(!visit[next.end])
					q.add(next);
				}
			}
			System.out.println("#"+t+" "+cost);
		}
		
	}
	
	static class Edge{	
		int end,weight;
		public Edge(int end, int weight) {
			super();
			this.end = end;
			this.weight = weight;
		}
		
	}
}
