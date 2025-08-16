package main.java._2025_08_16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ3967 {
    static StringBuilder sb;
    static char[][] map;
    static boolean[] visited;
    static ArrayList<int[]> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        map = new char[5][9];
        visited = new boolean[12];
        list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            String input = br.readLine();
            for (int j = 0; j < 9; j++) {
                map[i][j] = input.charAt(j);
                if (map[i][j] == 'x') {
                    list.add(new int[]{i, j});
                } else if (map[i][j] != '.') {
                    visited[map[i][j]-'A'] = true;
                }
            }
        }
        dfs(0);
    }
    public static void dfs(int cnt) {
        if(cnt==list.size()){
            if(check()){
                for(int i=0; i<5; i++){
                    for(int j=0; j<9; j++){
                        sb.append(map[i][j]).append(' ');
                    }
                    sb.append('\n');
                }
                System.out.println(sb);
                System.exit(0);
            }
            return;
        }
        for (int i = 0; i < 12; i++) {
            if (!visited[i]) {
                int [] now = list.get(cnt);
                map[now[0]][now[1]] = (char)('A'+i);
                visited[i] = true;
                dfs(cnt+1);
                visited[i] = false;
                map[now[0]][now[1]] = '.';
            }
        }
    }
    public static boolean check() {
        int sum=0;
        for (int i = 0; i < 4; i++) {
            sum += map[i][4-i]-'A'+1;
        }
        if(sum!=26){
            return false;
        }
        sum=0;
        for (int i = 0; i < 4; i++) {
            sum += map[i][4+i]-'A'+1;
        }
        if(sum!=26){
            return false;
        }
        sum=0;
        for (int i = 0; i < 4; i++) {
            sum += map[1][1+2*i]-'A'+1;
        }
        if(sum!=26){
            return false;
        }
        sum=0;
        for (int i = 0; i < 4; i++) {
            sum += map[1+i][1+i]-'A'+1;
        }
        if(sum!=26){
            return false;
        }
        sum=0;
        for (int i = 0; i < 4; i++) {
            sum += map[1+i][7-i]-'A'+1;
        }
        if(sum!=26){
            return false;
        }
        sum=0;
        for (int i = 0; i < 4; i++) {
            sum += map[3][1+2*i]-'A'+1;
        }
        if(sum!=26){
            return false;
        }
        return true;
    }
}
