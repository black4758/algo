import java.util.Scanner;

public class color_BJ_2567 {
	public static void main(String[] args) {
		int [][] arr= new int[100][100];
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		//배열 입력
		for(int i=0;i<N;i++) {
			int y=sc.nextInt();
			int x=sc.nextInt();
			for(int j=x;j<x+10;j++) {
				for(int k=y;k<y+10;k++) {
					arr[j][k]=1;
				}
			}
		}
		int an=0;
		int dx[]= {-1,1,0,0};
		int dy[]= {0,0,-1,1};
		//주변이 0이거나 x,y가 0이가나  99일떄 카운트
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if(arr[i][j]==1) {
					for(int k=0;k<4;k++) {
						int nx=i+dx[k];
						int ny=j+dy[k];
						if(nx<0||nx>=100||ny<0||ny>=100||arr[nx][ny]==0) {
							an++;
						}
					}
				}
			}
		}
		System.out.println(an);
	}
}
