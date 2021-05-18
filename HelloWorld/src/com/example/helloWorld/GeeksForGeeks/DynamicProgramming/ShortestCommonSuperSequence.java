package com.example.helloWorld.GeeksForGeeks.DynamicProgramming;
//https://practice.geeksforgeeks.org/problems/shortest-common-supersequence0322/1#
import java.io.*;
import java.util.*;
class ShortestCommonSuperSequence {
    public static void main (String[] args) {

        //taking input using Scanner class
        Scanner sc=new Scanner(System.in);

        //taking total testcases
        int t=sc.nextInt();

        sc.nextLine();
        while(t-->0)
        {
            //taking String X and Y
            String S[]=sc.nextLine().split(" ");
            String X=S[0];
            String Y=S[1];

            //calling function shortestCommonSupersequence()
            System.out.println(shortestCommonSupersequence(X, Y, X.length(), Y.length()));
        }
    }

    public static int shortestCommonSupersequence(String x,String y,int m,int n)
    {
        int i, j;
        int[][] dp = new int[m+1][n+1];
        for(i=0;i<=m;i++)
            dp[i][0]=0;
        for(i=1;i<=n;i++)
            dp[0][i]=0;

        for (i = 0; i <= m; i++) {
            for (j = 0; j <= n; j++) {
                if (i == 0)
                    dp[i][j] = j;
                else if (j == 0)
                    dp[i][j] = i;
                else if (x.charAt(i - 1) == y.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = 1
                            + Math.min(dp[i - 1][j],
                            dp[i][j - 1]);
            }
        }

        return dp[m][n];
    }
}
