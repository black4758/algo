import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class gi_SW_6808
{
    static int[] answer;
    static int[] arr;
    static int win,fail;
    static boolean[] ch2;
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();


		for(int test_case = 1; test_case <= T; test_case++)
		{
			 win=0;
		        fail=0;
		        arr = new int [9];
		        int [] arr2 = new int [9];
		        answer= new int [9];
		        ch2= new boolean [9];
		        boolean [] ch = new boolean [19];
		        for(int i=0;i<9;i++) {
		            arr[i]= sc.nextInt();
		            ch[arr[i]]=true;
		        }
		        for(int i=0;i<9;i++) {//입력받지 못한 값을 찾아 배열에 입력
		            for(int j=1;j<=18;j++) {
		                if(ch[j]==false) {
		                    arr2[i]=j;
		                    ch[j]=true;
		                        break;
		                }
		            }
		        }
		        suyal(arr2,0);
		        System.out.println("#"+test_case+" "+win+" " +fail);

		}
	}

	private static void suyal(int[] arr2, int tmp) {
		//수열을 통해 모든 경우의 수 구하기
	    if(tmp==9) {
	        ch(answer);
	        return;
	    }
	    for(int i=0; i<9;i++) {
	        if(ch2[i]==false) {
	            answer[tmp]=arr2[i];
	            ch2[i]=true;
	            suyal(arr2,tmp+1);
	            ch2[i]=false;
	        }
	    }
	}
	
	private static void ch(int[] arr2) {
		// 구한 배열 값을 비교하여 승자 구하기
	    int p1=0,p2=0;
	    for(int i=0;i<9;i++) {
	        if(arr[i]>arr2[i]) {
	            p1=p1+arr[i]+arr2[i];
	        }else {
	        	 p2=p2+arr[i]+arr2[i];
	        }
	    }
	    if(p1>p2) {
	    	win++; //이기면 증가
	    }
	    else fail++; //지면 증가
	}

}