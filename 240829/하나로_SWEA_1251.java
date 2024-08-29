import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;



public class 하나로_SWEA_1251 {
	static int[] parents;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T= sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int N =sc.nextInt();
			int[] xarr = new int[N];
			int[] yarr = new int[N];
			int[] parent = new int[N];
			for(int i=0;i<N;i++) {
				xarr[i]=sc.nextInt();
			}
			for(int i=0;i<N;i++) {
				yarr[i]=sc.nextInt();
			}
			double gajungchi=sc.nextDouble();
			
			ArrayList<Edge> list = new ArrayList<>();
			for(int i=0; i<N-1; i++) {
				for(int j=i+1; j<N; j++) {
					double w = gajungchi *(double)(Math.pow(xarr[i]-xarr[j], 2)+Math.pow(yarr[i]-yarr[j], 2));
					list.add(new Edge(i,j, w));
				}
			}
			Collections.sort(list);
			parents= new int[N];
			
			double cnt=0,cost=0;
			
			for(int i=0; i<N; i++) {
				parents[i] = i;
			}
			for(Edge edge : list ) {
				if(union(edge.st,edge.end)) {
					cost += edge.cost;
					if(++cnt==N-1) break;
				}
			}
			System.out.println("#"+tc+" "+Math.round(cost));
		}
	}
	static int findset(int a) {
		if(parents[a]==a) return a;
		return parents[a]= findset(parents[a]);
	}
	
	private static boolean union(int a, int b) {
		int aRoot = findset(a);
		int bRoot =findset(b);
		if(aRoot==bRoot) {
			return false;
			
		}
		parents[bRoot]=aRoot;
		return true;
	}
	static class Edge implements Comparable<Edge>{	
		int st,end;
		double cost;
		public Edge(int st, int end, double cost) {
			super();
			this.st = st;
			this.end = end;
			this.cost = cost;
		}
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Double.compare(this.cost, o.cost);
		}
		
	}
}
