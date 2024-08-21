import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SW_6109 {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		
		for (int test_case = 1; test_case <= T; test_case++) {
			int N=sc.nextInt();
			String S =sc.next();
			int[][] arr= new int[N][N];
			int[][] anarr= new int[N][N];
			

			
			for (int i = 0; i < N; ++i) {
	
				
				for (int j = 0; j < N; ++j) {
					arr[i][j]=sc.nextInt();
				}
			}
			
			if (S.equals("up")) {
				for(int i=0;i<N;i++) {
					for(int j=0;j<N-1;j++) {
						if(arr[j][i]==0) continue;
						else {
							int temp=j+1; int sw=0;
							while(temp!=N) {
								if(arr[temp][i] !=0) {
									sw=1;
									break;
								}
								temp++;
							}
							if(sw==1) {
								if(arr[j][i]==arr[temp][i]) {
									arr[j][i]+=arr[temp][i];
									arr[temp][i]=0;
								}
							}
						}
					}
					int idx = 0;
					for (int j = 0; j < N; j++) {
						if (arr[j][i] != 0) {
							anarr[idx++][i] = arr[j][i];
						}
					}
				}
			}
			else if(S.equals("down")) {
				for(int i=0;i<N;i++) {
					for(int j=N-1;j>0;j--) {
						if(arr[j][i]==0) continue;
						else {
							int temp=j-1; int sw=0;
							while(temp!=-1) {
								if(arr[temp][i] !=0) {
									sw=1;
									break;
								}
								temp--;
							}
							if(sw==1) {
								if(arr[j][i]==arr[temp][i]) {
									arr[j][i]+=arr[temp][i];
									arr[temp][i]=0;
								}
							}
						}
					}
					int idx = N-1;
					for (int j = N-1; j >= 0; j--) {
						if (arr[j][i] != 0) {
							anarr[idx--][i] = arr[j][i];
						}
					}
				}
			}
			else if (S.equals("left")) {
				for(int i=0;i<N;i++) {
					for(int j=0;j<N-1;j++) {
						if(arr[i][j]==0) continue;
						else {
							int temp=j+1; int sw=0;
							while(temp!=N) {
								if(arr[i][temp] !=0) {
									sw=1;
									break;
								}
								temp++;
							}
							if(sw==1) {
								if(arr[i][j]==arr[i][temp]) {
									arr[i][j]+=arr[i][temp];
									arr[i][temp]=0;
								}
							}
						}
					}
					int idx = 0;
					for (int j = 0; j < N; j++) {
						if (arr[i][j] != 0) {
							anarr[i][idx++] = arr[i][j];
						}
					}
				}
			}
			else if(S.equals("right")) {
				for(int i=0;i<N;i++) {
					for(int j=N-1;j>0;j--) {
						if(arr[i][j]==0) continue;
						else {
							int temp=j-1; int sw=0;
							while(temp!=-1) {
								if(arr[i][temp] !=0) {
									sw=1;
									break;
								}
								temp--;
							}
							if(sw==1) {
								if(arr[i][j]==arr[i][temp]) {
									arr[i][j]+=arr[i][temp];
									arr[i][temp]=0;
								}
							}
						}
					}
					int idx = N-1;
					for (int j = N-1; j >= 0; j--) {
						if (arr[i][j] != 0) {
							anarr[i][idx--] = arr[i][j];
						}
					}
				}
			}
			
			System.out.println("#"+test_case);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(anarr[i][j]+" ");
				}
				System.out.println();
			}
		}
	}
}
	

