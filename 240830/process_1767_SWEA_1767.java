import java.util.ArrayList;
import java.util.Scanner;
 
public class process_1767_SWEA_1767 {
    static int[][] arr;
    static ArrayList<position> coreList;
    static int[] dx = { 1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N;
    static int minWireLength,maxCore;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T=sc.nextInt();
        for(int tc=1;tc<=T;tc++) {
            N= sc.nextInt();
            coreList = new ArrayList<>();
            arr= new int[N][N];
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    arr[i][j]=sc.nextInt();
                    if (i == 0 || i == (N - 1) || j == 0 || j == (N - 1)) continue;
                    if (arr[i][j] == 1) coreList.add(new position(i, j)); 
                }
            }
            minWireLength = Integer.MAX_VALUE;
            maxCore = Integer.MIN_VALUE;
            Connect(0,0,0);
            System.out.println("#"+tc+" "+minWireLength);
        }        
    }
    private static void Connect(int cnt,int coreCnt, int wireCnt ) {
        if (cnt == coreList.size()) {
            if (maxCore  < coreCnt) {
                maxCore = coreCnt;
                minWireLength = wireCnt;
            }
            else if (maxCore  == coreCnt) {
                minWireLength = Math.min(wireCnt, minWireLength);
            }
            return;
        }
        int x = coreList.get(cnt).x;
        int y = coreList.get(cnt).y;
        for(int dir=0; dir<4; dir++) {
            int count=0, nx=x, ny=y;
            while(true) {
                nx += dx[dir];
                ny += dy[dir];                     
                if(ny<0 || ny>=N || nx<0 || nx>=N) {
                        break;
                    }
                   
                    if(arr[nx][ny] == 1) {
                        count = 0;
                        break;
                    }
                    count++;
                }
                int fill_x = x;
                int fill_y = y;
                 
                for(int i=0; i<count; i++) {
                    fill_x += dx[dir];
                    fill_y += dy[dir];
                    arr[fill_x][fill_y] = 1;
                }
                if(count==0)
                    Connect(cnt+1, coreCnt, wireCnt);
                else {
                    Connect(cnt+1, coreCnt+1, wireCnt+count);
                     
                    fill_x = x;
                    fill_y = y;
                      
                    for(int i=0; i<count; i++) {
                        fill_x += dx[dir];
                        fill_y += dy[dir];
                        arr[fill_x][fill_y] = 0;
                    }
                }
            }
        }
    static class position{
        int x,y;
        public position(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }
    }
}