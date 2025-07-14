import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ20303 {
    static class Friends {
        int friendCnt;
        int candyCnt;
        Friends(int friendCnt, int candyCnt) {
            this.friendCnt = friendCnt;
            this.candyCnt = candyCnt;
        }
    }
    static ArrayList<ArrayList<Integer>> graph;
    static  ArrayList<Friends> friendsList;
    static  boolean[] visited;
    static int[] store;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        store = new int[N+1];
        graph = new ArrayList<>();
        st=new StringTokenizer(br.readLine());
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
            if(i!=0){
                store[i]=Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph.get(start).add(end);
            graph.get(end).add(start);
        }
        friendsList =new ArrayList<>();
        visited=new boolean[N+1];
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {;
                bfs(i);
            }
        }
        int[] dp=new int[K];
        for(Friends friends: friendsList){
            for(int i=K-1; i>=friends.friendCnt;i--){
                dp[i]=Math.max(dp[i],dp[i-friends.friendCnt]+friends.candyCnt);
            }
        }
        System.out.println(dp[K-1]);
    }
    static void bfs(int st){
        visited[st]=true;
        Queue<Integer> q = new LinkedList<>();
        q.add(st);
        int friendCnt=0;
        int candyCnt=0;
        while (!q.isEmpty()) {
            int now = q.poll();
            friendCnt++;
            candyCnt+=store[now];
            for (int next : graph.get(now)) {
                if(!visited[next]){
                    q.add(next);
                    visited[next]=true;
                }
            }
        }
        friendsList.add(new Friends(friendCnt, candyCnt));
    }
}
