import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2644 {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int n=sc.nextInt();
		int p1=sc.nextInt();
		int p2=sc.nextInt();
		int m=sc.nextInt();
		ArrayList<Integer>[] graph= new ArrayList[n+1];
		for(int i=1;i<n+1;i++) {
			graph[i]=new ArrayList<>(); 
		}
        for(int i =0; i < m; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph[x].add(y);
            graph[y].add(x);
        }
        int [] visited= new int[n+1];
        

        Queue<Integer> q = new LinkedList<>();
        q.add(p1);
        while(!q.isEmpty()) {
        	int temp=q.poll();
        	if(temp == p2) break;
            for(int next : graph[temp]){
                if(visited[next]==0){
                    q.offer(next);
                    visited[next] = visited[temp] +1;
                }
            }
        }
        if( visited[p2]==0)visited[p2]=-1;
        System.out.println(visited[p2]);
	}

}
