import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Position {
    int end;
    int time;
    Position(int end, int time) {
        this.end = end;
        this.time = time;
    }
}

public class BOJ1238 {
    static  int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Position>> toX = new ArrayList<>();
        ArrayList<ArrayList<Position>> backX = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            toX.add(new ArrayList<>());
            backX.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            toX.get(start).add(new Position(end, time));
            backX.get(end).add(new Position(start, time));
        }
        int [] go = solution(X,toX);
        int [] back = solution(X,backX);
        int maxTime=0;
        for (int i = 1; i <= N; i++) {
            maxTime = Math.max(maxTime,go[i]+back[i]);
        }
        System.out.println(maxTime);
    }
    static int[] solution(int start, ArrayList<ArrayList<Position>> list) {
        PriorityQueue<Position> queue = new PriorityQueue<Position>((o1,o2)-> o1.time-o2.time);
        queue.add(new Position(start, 0));
        int[] arr= new int[N+1];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[start] = 0;
        while (!queue.isEmpty()) {
            Position now = queue.poll();
            if(now.time >arr[now.end]) {
                continue;
            }
            for(Position next : list.get(now.end)) {
                int nextTime=next.time+ now.time;
                if(arr[next.end] >nextTime) {
                    arr[next.end] = nextTime;
                    queue.add(new Position(next.end, nextTime));
                }
            }
        }
        return arr;
    }
}
