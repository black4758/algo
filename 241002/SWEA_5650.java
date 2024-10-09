import java.util.Scanner;
import java.util.*;

public class SWEA_5650 {

	static int[][] dirChange = {{0, 0, 0, 0}, {1, 2, 3, 0}, {1, 3, 0 ,2}, {3, 0, 1, 2}, {2, 0, 3, 1}, {1, 0, 3, 2}};
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	
	static int[][] map;
	static ArrayList<Pos>[] hole;
	
	static int N;

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc<= T; tc++) {
			N = sc.nextInt();
			map = new int[N][N];
			hole = new ArrayList[5];
			
			for(int i=0; i<5; i++) {
				hole[i] = new ArrayList<>();
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] = sc.nextInt();
					if(map[i][j] >= 6) {
						hole[map[i][j]-6].add(new Pos(i, j));
					}
				}
			}
			
			
			int answer = 0;
		
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j]!=0)
						continue;
					for(int dir=0; dir<4; dir++) {
						
						int score = check(i, j, dir);
						if(score > answer)
							answer = score;
						
					}
				}
			}
			
			System.out.println("#"+tc+" "+answer);
		}

	}
	
	static int check(int x, int y, int dir) {
		int score = 0;
		
		int nx = x;
		int ny = y;
		int move = 0;
		
		while(true) {
			
			//제자리로 
			if(nx == x && ny == y && move !=0) 
				break;
			
			//블랙홀
			if(map[nx][ny] == -1)
				break;
			
			nx = nx + dx[dir];
			ny = ny + dy[dir];
			move++;
			
			
			//벽에 부딪힘 
			if(nx<0 || nx>=N || ny<0 || ny>=N) {
				nx = nx - dx[dir];
				ny = ny - dy[dir];
				
				if(dir == 0)
					dir = 1;
				else if(dir == 1)
					dir = 0;
				else if(dir == 2)
					dir = 3;
				else if(dir == 3)
					dir = 2;
				
				score++;
				
			}
			
			//블록에 부딪힘 
			if(map[nx][ny] >= 1 && map[nx][ny] <=5) {
				int block = map[nx][ny];
				
				dir = dirChange[block][dir];
				score++;
				continue;
			}
			
			//웜홀
			if(map[nx][ny] > 5) {
				int block = map[nx][ny];
				int r1 = hole[block-6].get(0).x;
				int c1 = hole[block-6].get(0).y;
				
				int r2 = hole[block-6].get(1).x;
				int c2 = hole[block-6].get(1).y;
				
				if(nx == r1 && ny == c1) {
					nx = r2;
					ny = c2;
				}
				else {
					nx = r1;
					ny = c1;
				}
			}
			
			
		}
		
		return score;
	}
	
	static class Pos {
		int x, y;
		Pos(int x, int y){
			this.x = x;
			this.y = y;
		}
		
	}

}