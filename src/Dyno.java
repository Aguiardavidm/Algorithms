// Java program to find out maximum value from a given sequence of coins
import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.*;

class Dyno
{
    // Utility functions to get maximum and minimum of two intgers
    int max(int a, int b) { return a > b ? a : b; }
    int min(int a, int b) { return a < b ? a : b; }

    // Returns optimal value possible that a player can collect from an array of coins of size sizeOfList.
    // Note than sizeOfList must be even
    static int optimalStrategyOfGame(int arrayWithValues[], int sizeOfList)
    {
        // Create a table to store solutions of subproblems
        int table[][] = new int[sizeOfList][sizeOfList];
        int gap, i, j, x, y, z;

        // Fill table using above recursive formula. Note that the table is filled in diagonal fashion (similar to http://goo.gl/PQqoS),
        // from diagonal elements to table[0][sizeOfList-1] which is the result.
        for (gap = 0; gap < sizeOfList; ++gap)
        {
            for (i = 0, j = gap; j < sizeOfList; ++i, ++j)
            {
                // Here x is value of F(i+2, j), y is F(i+1, j-1) and z is
                // F(i, j-2) in above recursive formula
                //x = ((i + 2) <= j) ? table[i + 2][j] : 0;
                if  ((i+2)< j ){
                    x= table[i +2 ][j]; }
                else {
                    x=0; }

                //y = ((i + 1) <= (j - 1)) ? table[i +1 ][j -  1] : 0;
                if ((i+1)<= (j-1)){
                    y = table[i +1] [j-1]; }
                else{
                    y = 0; }

                //z = (i <= (j - 2)) ? table[i][j - 2]: 0;
                if( i<= (j-2)){
                    z = table[i][j-2]; }
                else {
                    z=0; }

                table[i][j] = Math.max(arrayWithValues[i] + Math.min(x, y) , arrayWithValues[j] + Math.min(y, z));
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
        return table[0][sizeOfList - 1];
    }

    // Driver program 
    public static void main (String[] args)
    {
        int arr1[] = {8, 15, 3, 7};
        int n = arr1.length;
        System.out.println("" + optimalStrategyOfGame(arr1, n)+ "\n");

        int arr2[] = {2, 2, 2, 2};
        n = arr2.length;
        System.out.println("" + optimalStrategyOfGame(arr2, n)+ "\n");

        int arr3[] = {20, 30, 2, 2, 2, 10};
        n = arr3.length;
        System.out.println("" + optimalStrategyOfGame(arr3, n)+ "\n");


    }
}

// This code is contributed by vt_m