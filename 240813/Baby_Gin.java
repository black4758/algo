import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baby_Gin {
	static boolean isSelected[];
	static  int arr[];
	static int[] selected;
	static  boolean answer;

	//순열로 모든 걍우의 수를 구한 후 베이비진 인지 구하기

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr= new int[6];
		isSelected= new boolean[6];
		selected = new int[6];
		int n= Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			answer=false;
			String input= br.readLine();
			for (int j = 0; j < 6; j++) {
				arr[j]=input.charAt(j)-'0';
			}
			permutation(0);
			if(answer){
				System.out.println("YES");
			}
			else{
				System.out.println("NO");
			}
		}
	}

	private static void permutation(int cnt) {
		if (answer){
			return;
		}
		if(cnt==6){
			if(isBabyGin()){
				answer=true;
			};
			return;
		}

		for(int i=0;i<6;i++){
			if(isSelected[i]){
				continue;
			}
			selected[cnt]=arr[i];
			isSelected[i]=true;
			permutation(cnt+1);
			isSelected[i]=false;
		}
	}

	private static boolean isBabyGin() {
		if(selected[0]==selected[1] && selected[1]==selected[2]){
			if(selected[3]+1==selected[4] &&selected[4]==selected[5]-1 ){
				return true;
			}
			if(selected[3]==selected[4] &&selected[4]==selected[5]){
				return true;
			}
		}
		if(selected[0]+1==selected[1] && selected[1]==selected[2]-1){
			if(selected[3]+1==selected[4] &&selected[4]==selected[5]-1 ){
				return true;
			}
			if(selected[3]==selected[4] &&selected[4]==selected[5]){
				return true;
			}
		}
		return false;
	}
}
