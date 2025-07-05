package main.java._2025_06_26;

import java.util.Scanner;

public class SWEA1486 {
    static int [] arr;
    static int N,H,sum;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            N= sc.nextInt();
            H= sc.nextInt();
            arr= new int[N];
            for(int i=0;i<N;i++) {
                arr[i]=sc.nextInt();
            }
            sum=Integer.MAX_VALUE;

            subset(0,0);
            System.out.println("#"+test_case+" "+(sum-H));
        }
    }
    private static void subset(int cnt,int max) {
        if(max>=H) {
            sum= Math.min(sum, max);
            return;
        }
        if(cnt==N) {
            return;
        }
        subset(cnt+1,max+arr[cnt]);
        subset(cnt+1,max);
    }
}
