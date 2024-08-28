import java.util.ArrayList;

import java.util.Scanner;

public class ABCDE_BOJ_13023 {
    static boolean[] status;
    static int an=0;
    static  ArrayList<Integer>[] graph;
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        graph= new ArrayList[n];
        status= new boolean[n];
        for(int i=0;i<n;i++) {
            graph[i]=new ArrayList<>(); 
        }
        for(int i =0; i < m; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph[x].add(y);
            graph[y].add(x);
        }
		for(int i=0;i<n;i++) {
			if(an==0) {
				dfs(i,1);
			}
			else break;
		}
			
		
       
        System.out.println(an);
        
    }
	private static void dfs(int st,int cnt) {
		status[st]=true;
		if(cnt==5) {
			an=1;
			return;
		}
		for(int next:graph[st]) {
			if(!status[next]) {
				dfs(next,cnt+1);
			}
		}
		status[st]=false;
	}

}