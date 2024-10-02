import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Position{
	int x,y;

	public Position(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}

public class BOJ_3055 {
	


    public static void main(String[] args) throws IOException {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Queue<Position>waterQ= new LinkedList<Position>();
        Queue<Position>goQ= new LinkedList<Position>();
        st = new StringTokenizer( br.readLine() );
        int R = Integer.parseInt( st.nextToken() );
        int C = Integer.parseInt( st.nextToken() );
        char[][] map = new char[R][C];
        int time=0;
        int an=0;
        for (int i = 0; i < R; i++) {
        	String line= br.readLine();
        	for (int j = 0; j < C; j++) {
				map[i][j]=line.charAt(j);
				if(map[i][j]=='S') {
					goQ.add(new Position(i, j));
				}else if(map[i][j]=='*') {
					waterQ.add(new Position(i, j));
				}
			}
		}
        
        while(! goQ.isEmpty()) {
        	int w_size=waterQ.size();
        	for (int i = 0; i < w_size; i++) {
				Position now = waterQ.poll();
                for( int j=0; j<4; j++ ) {
                    int nx = now.x + dx[j];
                    int ny = now.y + dy[j];
                    if(nx>=0 && nx<R && ny>=0 && ny<C && map[nx][ny]=='.' ) {
                    	map[nx][ny]='*';
                    	waterQ.add(new Position(nx, ny));
                    }
			}
        }
        	int go_size=goQ.size();
        	time++;
        	for (int i = 0; i < go_size; i++) {
				Position now = goQ.poll();
				
                for( int j=0; j<4; j++ ) {
                    int nx = now.x + dx[j];
                    int ny = now.y + dy[j];
                    if(nx>=0 && nx<R && ny>=0 && ny<C  ) {
                    	if(map[nx][ny]=='D') {
                    		an=time;
                    		System.out.println(an);
                    		return;
                    	}
                    	if(map[nx][ny]=='.') {
                        	map[nx][ny]='S';
                        	goQ.add(new Position(nx, ny));
                    	}
                    }

                 }
			}
        }
        if(an==0) {
        	System.out.println("KAKTUS");
        }
        else System.out.println(an);
    }


}
