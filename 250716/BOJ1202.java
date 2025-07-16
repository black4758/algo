package main.java._2025_06_26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1202 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Store [] stores = new Store[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            stores[i] = new Store(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        int[] bags = new int[K];
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bags);
        Arrays.sort(stores,(o1,o2)-> o1.weight-o2.weight);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long ans = 0;
        int index = 0;
        for (int i = 0; i < K; i++) {
            while(index<N &&stores[index].weight<=bags[i]) {
                pq.add(stores[index].cost);
                index++;
            }
            if(!pq.isEmpty()){
                ans += pq.poll();
            }
        }
        System.out.println(ans);
    }
    static class Store{
        int weight;
        int cost;
        Store(int cnt, int cost){
            this.weight = cnt;
            this.cost = cost;
        }
    }
}
