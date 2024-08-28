import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class contact_SWEA_1238 {
	static boolean status;
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int T= 10;
		for(int t=1;t<=T;t++) {
			int n=sc.nextInt();
			int m=sc.nextInt();
			ArrayList<Integer>[] graph= new ArrayList[101];
			for(int i=1;i<=100;i++) {
				graph[i]=new ArrayList<>(); 
			}
	        for(int i =0; i < n/2; i++){
	            int x = sc.nextInt();
	            int y = sc.nextInt();
	            graph[x].add(y);
	        }
	        boolean [] visited= new boolean[101];
	        Queue<Integer> q = new LinkedList<>();
	        q.add(m);
	        visited[m]=true;
	        int an=0;
	        while(!q.isEmpty()) {
	        	 int len=q.size();
	        	 an=0;
		        for(int i=0;i<len;i++) {
		        	int temp=q.poll();
		        	an= Math.max(an, temp);
		            for(int next : graph[temp]){
		                if(!visited[next]){
		                    q.offer(next);
		                    visited[next] =true;
		                }
		            }
		        }
	        }
	        System.out.println("#"+t+" "+an);
		}

        
	}

}
