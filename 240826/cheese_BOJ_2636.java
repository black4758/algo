import java.util.Scanner;

public class cheese_BOJ_2636 {
	static int N, M,cheese,answer;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	static boolean[][] outArr;
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
	    N = sc.nextInt();
	    M = sc.nextInt();
	    int[][] arr = new int[N][M];
	    for (int i = 0; i < N; i++) { //입력
	        for (int j = 0; j < M; j++) {
	        	arr[i][j] = sc.nextInt();
	            if (arr[i][j] == 1) {
	                cheese++;
	            }
	        }
	    }
	    int before=0;
	    while(cheese!=0) {
	    	before=cheese;
	    	answer++;
	    	outArr= new boolean[N][M];
	    	findOutAir(0,0,arr);
		    for (int i = 0; i < N; i++) {
		        for (int j = 0; j < M; j++) {
		        	if(arr[i][j]==1) { 
		        		for (int n = 0; n < 4; n++) {
		        			int nx = i + dx[n];
		        			int ny = j + dy[n];
		        			if (nx >= 0 && nx < N && ny>= 0 && ny < M) {
		        				if (outArr[nx][ny] == true) {
			        				arr[i][j]=0;
			        				cheese--;
			        				break;
		        				}

		        			}
		        		}
		        	}
		        }
		    }
	    }
	    System.out.println(answer);
	    System.out.println(before);
	}
	
	private static void findOutAir(int x,int y,int[][] arr) {
		outArr[x][y]= true;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && nx < N && ny>= 0 && ny < M) {
	            if (outArr[nx][ny] == false && arr[nx][ny] == 0) 
	            findOutAir(nx, ny,arr);
			   }
		   }
		
	}
}
