public class BOJ4673 {
    public static void main(String[] args) {
        boolean[] visited = new boolean[10001];
        for (int i = 1; i <=10000; i++) {
            int now=i;
            int sum = i;
            while (now != 0) {
                sum+=now%10;
                now=now/10;
            }
            if(sum<=10000){
                visited[sum] = true;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <=10000; i++) {
            if (!visited[i]) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }
}
