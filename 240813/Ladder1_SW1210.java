import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
class Solution
{
    static class Position{
        int x;
        int y;
 
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[][] map;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        Position position = null;
        for (int i = 0; i < 10; i++) {
            int N= Integer.parseInt(br.readLine());
            map = new int[100][100];
            for (int j = 0; j < 100; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 100; k++) {
                    map[j][k] = Integer.parseInt(st.nextToken());
                    if(map[j][k] == 2){
                        position=new Position(j, k);
                    }
                }
            }
            int nx=0;
            int ny=0;
            int[] dx= {0,0,-1};
            int[] dy= {-1,1,0};
            while (position.x>0){
                for(int j=0;j<3;j++) {
                    nx=position.x+dx[j];
                    ny=position.y+dy[j];
                    if(nx>=0&&nx<100&&ny>=0&&ny<100&&map[nx][ny]==1){
                        map[nx][ny]=0;
                        position.x=nx;
                        position.y=ny;
                    }
                }
            }
            System.out.println("#"+N+" "+position.y);
        }
    }
}
