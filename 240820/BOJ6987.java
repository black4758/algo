package main.java._2025_06_26;

import java.util.Scanner;

public class BOJ6987 {
    static int[][] matches;
    static int[][] arr;
    static boolean possible;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        matches=new int[15][2];
        arr=new int[6][3];
        int index=0;
        for (int i = 0; i < 6; i++) {
            for (int j = i+1; j < 6; j++) {
                matches[index][0]=i;
                matches[index][1]=j;
                index++;
            }
        }
        for (int i = 0; i < 4; i++) {
            boolean isValid = true;
            possible=false;
            for (int j = 0; j < 6; j++) {
                arr[j][0]=sc.nextInt();
                arr[j][1]=sc.nextInt();
                arr[j][2]=sc.nextInt();
                if(arr[j][0]+arr[j][1]+arr[j][2] != 5){
                    isValid=false;
                }
            }
            if(!isValid){
                System.out.print("0 ");
                continue;
            }
            dfs(0);
            if(possible){
                System.out.print("1 ");
            }
            else System.out.print("0 ");
        }
        return;
    }

    private static void dfs(int cnt) {
        if (cnt == 15) {
            possible=true;
            return;
        }
        if (possible) {
            return;
        }
        int team1=matches[cnt][0];
        int team2=matches[cnt][1];

        if(arr[team1][0]>0 &&arr[team2][2]>0){
            arr[team1][0]--;
            arr[team2][2]--;
            dfs(cnt+1);
            arr[team1][0]++;
            arr[team2][2]++;
        }
        if(arr[team1][1]>0 &&arr[team2][1]>0){
            arr[team1][1]--;
            arr[team2][1]--;
            dfs(cnt+1);
            arr[team1][1]++;
            arr[team2][1]++;
        }
        if(arr[team1][2]>0 &&arr[team2][0]>0){
            arr[team1][2]--;
            arr[team2][0]--;
            dfs(cnt+1);
            arr[team1][2]++;
            arr[team2][0]++;
        }

    }
}
