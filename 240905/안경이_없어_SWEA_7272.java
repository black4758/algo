import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 안경이_없어_SWEA_7272 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T= Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String an;
			st=new StringTokenizer(br.readLine());
			String a= st.nextToken();
			String b= st.nextToken();
	        a=a.replaceAll("[CEFGHIJKLMNSTUVWXYZ]","C").replaceAll("[ADOPQR]","A");
            b=b.replaceAll("[CEFGHIJKLMNSTUVWXYZ]","C").replaceAll("[ADOPQR]","A");
           if(a.equals(b)) an="SAME";
           else an="DIFF";
           System.out.println("#"+tc+" "+an);
		}

	}
}
