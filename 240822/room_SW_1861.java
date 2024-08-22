import java.util.Scanner;
import java.io.FileInputStream;

public class room_SW_1861
{    static int dx[]= {-1,1,0,0},arr[][];
    static int dy[]= {0,0,-1,1},N,anData,ancount;
    public static void main(String args[]) throws Exception
    {

    Scanner sc = new Scanner(System.in);
    int T;
    T=sc.nextInt();
    /*
       여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
    */

    for(int test_case = 1; test_case <= T; test_case++)
    {
    	anData=0;ancount=0;
        N=sc.nextInt();
        arr = new int[N][N];
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                arr[i][j]=sc.nextInt();
            }
        }
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
            	 sol(i,j,arr[i][j],1);
            }
        }

        System.out.println("#"+test_case +" "+anData+" "+ancount);
    }
}

private static void sol(int x,int y,int data,int count) {
    for(int i=0;i<4;i++) {
        int dx[]= {-1,1,0,0};
        int dy[]= {0,0,-1,1};
        int nx=x+dx[i];
        int ny=y+dy[i];
        if(nx>=0&&nx<N&&ny>=0&&ny<N&&arr[x][y]==arr[nx][ny]-1) {
        	count++;
        	if(count>ancount) {
        		ancount=count;
        		anData=data;
        	}
        	if(ancount==count) {
        		anData=Math.min(anData, data);
        	}
            sol(nx,ny,data,count);
        }

    	}
	}
    
}

