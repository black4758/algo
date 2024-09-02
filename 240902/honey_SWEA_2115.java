
import java.util.Scanner;

public class honey_SWEA_2115 {
    static int  N,M,C;
    static boolean [] select;
    static int [][] map;
    static int [][] honeyArr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1;tc<=T;tc++) {
            N=sc.nextInt();
            M=sc.nextInt();
            C=sc.nextInt();
            map = new int[N][N]; 
            honeyArr = new int[N][N];
            for(int i=0;i<N;i++) { //입력
                for(int j=0;j<N;j++) {
                	map[i][j]=sc.nextInt();
                }
            }
            select = new boolean[M];
            for(int i = 0; i < N; i++) { // 조건에 맞는 제곱 구하기
                for(int j = 0 ; j <= N-M; j++) {
                	make_honey_subset(i, j, 0,0,0); 
                }
            }
            select_honey_combination(tc); //2개 고르기
         }
    }
    static void select_honey_combination(int tc) {
    	//조합이용
        int ans=0;
        for(int i = 0 ; i < N; i++) {
            for(int j = 0; j <= N-M; j++){
                for(int x = i ; x < N; x++){
                	int y=0;
                	if(i==x) y=j+M; // 같은 행에 있을떄 
                	for( ; y <= N-M; y++){
                		if(ans<honeyArr[i][j]+honeyArr[x][y]){
                			ans=honeyArr[i][j]+honeyArr[x][y];
                    		}
                    	}
                	}
                }
            }
        System.out.println("#"+tc+" "+ ans);
    	
    }

        
  
	static void make_honey_subset (int x, int y, int cnt,int sum,int squareSum) {
	   // 부분집합 이용
		//C보다 작은 값들 중 제곱합이 가장 큰값을 배열에 저장 
		if(cnt == M) {
	        if(sum <= C && honeyArr[x][y] < squareSum) {
	        	honeyArr[x][y] = squareSum;
	        }
	        return;
	    }
	    make_honey_subset(x, y, cnt+1,sum+map[x][y+cnt],squareSum+map[x][y+cnt]*map[x][y+cnt]);
	    
	    make_honey_subset(x, y, cnt+1,sum,squareSum);
	}
}