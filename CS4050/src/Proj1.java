/*
    David Aguiar

    Problem Statement:
    given a positive integer n, list all the different ways to
    get a collection positive integers adding up to n. Assume that we don’t care about order,
    so 1 + 2 and 2 + 1 are the same possibility.
*/

import java.util.Scanner;

public class Proj1 {

    public static void main(String[] args) {

        //user input
        System.out.print("enter the number to add to: ");
        int input = new Scanner( System.in ).nextInt();

        //generate trees starting starting with 1-n
        for(int x = 1; x <= input; x++)
            generate(input, ""+x, x, x);
    }

    private static void generate(int goal, String toPrint, int current, int total) {

        //check if you currently have a good answer
        if(total == goal)
            System.out.println(toPrint);

        //trim the branches that are greater than the goal
        else if(total < goal)
            for(int i = current; i < goal; i++ )
                generate(goal, toPrint + " + " + i, i, total + i);
    }
}