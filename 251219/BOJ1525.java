import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<String> q = new LinkedList<>();
        String input="";
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(int i=0;i<3;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++){
                input+=st.nextToken().charAt(0);
            }
        }
        q.add(input);
        map.put(input,0);
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        while(!q.isEmpty()){
            String now = q.poll();
            if(now.equals("123456780")){
                System.out.println(map.get(now));
                return;
            }
            int x = now.indexOf('0')/3;
            int y = now.indexOf('0')%3;
            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx>=0 && ny>=0 && nx<3 && ny<3){
                    String next ="";
                    int index = nx*3+ny;
                    char[] arr = now.toCharArray();
                    char num = arr[index];
                    arr[index] = arr[now.indexOf('0')];
                    arr[now.indexOf('0')] = num;
                    next = new String(arr);
                    if(!map.containsKey(next)){
                        map.put(next,map.get(now)+1);
                        q.add(next);
                    }
                }
            }
        }
        System.out.println(-1);
        return;
    }
}
