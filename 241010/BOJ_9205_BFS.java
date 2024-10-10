package woo;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_9205_BFS {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
			Positon st = null,fn=null;
			List<Positon> list = new LinkedList<>();
			int n= sc.nextInt();
			for (int i = 0; i < n+2; i++) {
				if(i==0) st= new Positon(sc.nextInt(), sc.nextInt());
				else if(i==n+1) fn= new Positon(sc.nextInt(), sc.nextInt());
				else list.add(new Positon(sc.nextInt(), sc.nextInt()));
			}
			int an=0;
			Queue<Positon> q = new LinkedList<>();
			boolean[] visited = new boolean[n];
			q.add(st);
			while(!q.isEmpty()){
				Positon now = q.poll();
				if(Math.abs(now.x-fn.x)+Math.abs(now.y-fn.y)<=1000) {
					an =1;
					break;
				}
				for (int i = 0; i < n; i++) {
					if(!visited[i]) {
						if(Math.abs(now.x-list.get(i).x)+Math.abs(now.y-list.get(i).y)<=1000) {
							visited[i]= true;
							q.add(list.get(i));
						}
					}
					
				}
			}
			if(an==1) System.out.println("happy");
			else System.out.println("sad");
			
		}
	}
	static class Positon{
		int x,y;

		public Positon(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
}
