import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;


public class 최단경로_BOJ_1753 {
	static int V,st;
	static int[] minDistance;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V= sc.nextInt();
		int E=sc.nextInt();
		int st= sc.nextInt();
		int INF=Integer.MAX_VALUE;
		minDistance= new int[V+1];
		
		ArrayList<position>[] arr =new ArrayList[V+1];
		for(int i=0;i<=V;i++) {
			arr[i]=new ArrayList<>();
			minDistance[i]=INF;
		}
		for(int i=0;i<E;i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int weight = sc.nextInt();
			arr[from].add(new position(to, weight));
		}
		getMinDistance(arr, st);
		
	}
	static void getMinDistance(ArrayList<position>[] arr,int start) {
		int INF=Integer.MAX_VALUE;
		boolean[] visited= new boolean[V+1];
		PriorityQueue<position> queue= new PriorityQueue<>((a,b)->Integer.compare(a.cost,b.cost));
		queue.add(new position(start, 0));
		minDistance[start] = 0;
		while(! queue.isEmpty()) {
			position curNode = queue.poll();
	        int cur = curNode.vertex;
	        if(visited[cur] == true) continue;
	        visited[cur] = true;
	        
	        for(position node : arr[cur]){
	           if(!visited[node.vertex]&& minDistance[node.vertex] > minDistance[cur]+node.cost){
	        	   minDistance[node.vertex]=minDistance[cur]+node.cost;
	        	   queue.add(new position(node.vertex, minDistance[cur]+node.cost));
	           }
	        }
		}
		 
		for(int i = 1; i <= V; i++) {
			if(minDistance[i]==INF) System.out.println("INF");
			else System.out.println(minDistance[i]);
		}
	}
	static class position{
		int vertex,cost;

		public position(int to, int cost) {
			super();
			this.vertex = to;
			this.cost = cost;
		}
	}
}