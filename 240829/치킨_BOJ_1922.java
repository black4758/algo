import java.util.Arrays;
import java.util.Scanner;

public class 치킨_BOJ_1922 {
	static int[] nodarr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		int E= sc.nextInt();
		Edge[] edge = new Edge[E];
		for(int i=0;i<E;i++) {
			edge[i]=new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		nodarr=new int[N+1];
		Arrays.sort(edge);
		int cnt=0,cost=0;
		for(Edge now : edge) {
			if(union(now.start, now.end)) {
				cost += now.weight;
				if(++cnt==N-1) break;
			}
		}
		System.out.println(cost);
	}
	static int  findeset(int a) {
		if(nodarr[a]==0) {
			return a;
		}
		return nodarr[a]=findeset(nodarr[a]);
	}
	static boolean union(int a, int b) {
		int Roota= findeset(a);
		int Rootb= findeset(b);
		if(Roota==Rootb) {
			return false;
		}
		nodarr[Rootb]=Roota;
		return true;
	}
	
	static class Edge implements Comparable<Edge>{
		int start, end, weight;

		
		public Edge(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}


		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.weight-o.weight;
		} 
	}
}
