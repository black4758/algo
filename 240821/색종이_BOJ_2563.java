import java.util.Scanner;

public class 색종이_BOJ_2563 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] map= new int [101][101];
		int mapdouble=0;
		int N=sc.nextInt();
		for(int i=0;i<N;i++) {
			int x=sc.nextInt();
			int y=sc.nextInt();
			for(int j=y;j<y+10;j++) {
				for(int z=x;z<x+10;z++) {
					map[j][z]++;
					if(map[j][z]>=2) {
						mapdouble++;
					}
				}
			}

		}
		int sum=100*N-mapdouble;
		System.out.println(sum);
	}
}
