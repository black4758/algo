package main.java._2025_06_26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10775 {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G=Integer.parseInt(br.readLine());
        int P=Integer.parseInt(br.readLine());
        parent = new int[G+1];
        int ans = 0;
        for (int i = 0; i <= G; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < P; i++) {
            int input = Integer.parseInt(br.readLine());
            input=find(input);
            if(input==0){
                break;
            }
            else{
                parent[input]=find(input-1);
                ans++;
            }
        }
        System.out.println(ans);
    }
    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
}
