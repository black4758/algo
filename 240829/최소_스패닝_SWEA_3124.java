import java.util.Arrays;
import java.util.Scanner;


public class 최소_스패닝_SWEA_3124 {
	static int V;
	static int[] parents;
	
	static int findset(int a) {
		if(parents[a]==0) return a;
		return parents[a]= findset(parents[a]);
	}
	static boolean union (int a, int b) {
		int aRoot = findset(a);
		int bRoot =findset(b);
		if(aRoot==bRoot) {
			return false;
			
		}
		parents[bRoot]=aRoot;
		return true;
	}
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T= sc.nextInt();
		for(int t=1;t<=T;t++) {
			V= sc.nextInt();
			int E= sc.nextInt();
			parents= new int[V+1];
			Edge[] edges = new Edge[E];
			for(int i=0;i<E;i++) {
				edges[i] = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
			}
			Arrays.sort(edges);
			long cnt=0,cost=0;
			for(Edge edge: edges) {
				if(union(edge.st, edge.end)) {
					cost += edge.weight;
					if(++cnt==V-1) break;
				}
			}
			System.out.println("#"+t+" "+cost);
		}
		
	}
	
	static class Edge implements Comparable<Edge>{	
		int st,end,weight;
		public Edge(int st, int end, int weight) {
			super();
			this.st = st;
			this.end = end;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.weight, o.weight);
		}
		
	}
}
