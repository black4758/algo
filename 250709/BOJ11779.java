import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node{
    int end;
    int cost;
    Node(int end, int cost){
        this.end = end;
        this.cost = cost;
    }
}

public class BOJ11779 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n =Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        int [] costs = new int[n+1];
        int[] prevNode = new int[n + 1];
        Arrays.fill(costs, Integer.MAX_VALUE);
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            graph.get(Integer.parseInt(st.nextToken())).add(new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        Queue<Node> q = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        costs[start] = 0;
        q.add(new Node(start, 0));
        while (!q.isEmpty()) {
            Node cur = q.poll();
            int next = cur.end;
            int cost = cur.cost;
            if (costs[next] < cost) {
                continue;
            }
            for(Node node : graph.get(next)) {
                int nextCost = cost+ node.cost;
                if (nextCost < costs[node.end]) {
                    costs[node.end] = nextCost;
                    prevNode[node.end] = next;
                    q.add(new Node(node.end, nextCost));
                }
            }
        }
        System.out.println(costs[end]);
        Stack<Integer>stack = new Stack<>();
        int current = end;
        while(current !=0){
            stack.push(current);
            current = prevNode[current];
        }
        System.out.println(stack.size());
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }
}
