import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ5639 {
    static List<Integer> preorder = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input = br.readLine()) != null && !input.isEmpty()) {
            preorder.add(Integer.parseInt(input));
        }
        solution(0,preorder.size()-1);
        System.out.println(sb);
    }
    static void solution(int st, int end){
        if(st>end){
            return;
        }

        int rightRoot=end+1;
        for(int i=st+1;i<=end;i++){
           if(preorder.get(st)<preorder.get(i)){
               rightRoot = i;
               break;
           }
        }
        solution(st+1,rightRoot-1);
        solution(rightRoot,end);
        sb.append(preorder.get(st)).append("\n");


    }
}
