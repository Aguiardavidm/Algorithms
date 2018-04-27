import java.util.Random;
import java.util.Scanner;

public class Project3 {

    //https://www.geeksforgeeks.org/dynamic-programming-set-31-optimal-strategy-for-a-game/

    static int[] theList;
    static int[][] theChart;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please choose the size of the game");
        int size = scan.nextInt();

        System.out.println("The generated list is: ");
        int[] testList = generateList(size);
        theList = testList;
        printArray(testList);

        System.out.println("The chart with the solution is: ");
        theChart = new int[theList.length][theList.length];
        fillChart(0, theList.length-1, true);
        printArray(theChart);
    }


    private static int fillChart(int row, int col, boolean minomax){
        if(theChart[row][col] != 0) {
            return theChart[row][col];
        }
        if(row == col){
            theChart[row][col] = theList[row];
            return theChart[row][col];
        }
        if(row > col){
            return 0;
        }
        if(minomax == false) {
            theChart[row][col] = min((fillChart(row + 1, col, !minomax)), (fillChart(row, col - 1, !minomax)));
        }
        theChart[row][col] = max((fillChart(row+1,col,!minomax)),(fillChart(row,col-1,!minomax)));
        return theChart[row][col];
    }

    public static void printArray(String[][] printChart) {
        for(int i = 0; i < printChart.length; i++){
            for(int j = 0; j < printChart[0].length; j++){
                System.out.print(printChart[i][j]+ " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printArray(int[][] printChart) {
        for(int i = 0; i < printChart.length; i++){
            for(int j = 0; j < printChart[0].length; j++){
                System.out.print(printChart[i][j]+ " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printArray(int[] printList){
        for(int i = 0; i < printList.length; i++){
            System.out.print(printList[i] + " ");
        }
        System.out.println("\n");
    }

    public static int[] generateList(int size){
        int[] returnList = new int[size];
        Random random = new Random();
        for(int i = 0; i < returnList.length; i++){
            returnList[i] = random.nextInt(10);
        }
        return returnList;
    }

    private static int max(int a, int b){
        if(a < b){
            return b;
        }
        return a;
    }

    private static int min(int a, int b){
        if(a < b){
            return a;
        }
        return b;
    }
}
