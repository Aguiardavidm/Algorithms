import java.sql.SQLOutput;
import java.util.Scanner;

public class Project4 {

    static int[][] chart;
    static int[][] connections;
    static Integer INFINITE = Integer.MAX_VALUE;

    public static void main(String[] args) {
        //User Input
        //getInput();

        //Internal Testing
        chart = new int[][]{{0,5,8,12,15},{-1,0,5,8,-1},{-1,-1,0,2,4},{-1,-1,-1,0,1},{6,-1,-1,-1,0}};
        connections = new int[chart.length][chart[0].length];
        addInfinity();
        System.out.println("Entered Chart");
        printChart(chart);

        for (int i= 0; i < chart.length; i++)
            fillChart(i);
    }

    private static void fillChart(int jump){
        for (int i = 0; i<chart.length; i++){
            for (int j = 0; j<chart.length; j++){
                if (chart[i][j]> (chart[i][jump]+chart[jump][j]) && chart[i][j] != 0
                        && chart[i][jump] != INFINITE && chart[jump][j] != INFINITE) {
                    chart[i][j] = chart[i][jump]+chart[jump][j];
                    connections[i][j] = jump+1;
                }
            }
        }
        System.out.println("This is the value chart for D" + (jump+1));
        printChart(chart);
        System.out.println("This is the chart that shows the paths for D" + (jump+1));
        printChart(connections);
        System.out.println();
    }

    private static void addInfinity(){
        for (int i = 0; i<chart.length; i++){
            for (int j = 0; j<chart.length; j++){
                if(chart[i][j] == -1)
                    chart[i][j] = INFINITE;
            }
        }
    }

    private static void getInput() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Please provide the number of vertices: ");
        int numVertex = scan.nextInt();
        chart = new int[numVertex][numVertex];

        System.out.println("Please provide the directed graph using -1 for no connection ");
        for(int i = 0; i < numVertex; i++){
            for(int j = 0; j < numVertex; j++){
                if(i == j)
                    chart[i][j]= 0;
                else{
                    System.out.println("Please enter the weight from " + i + " to " + j + " : ");
                    chart[i][j] = scan.nextInt();
                }
            }
        }
        printChart(chart);
    }

    public static void printChart(int[][] printChart){
        for(int i = 0; i < printChart.length; i++){
            for(int j = 0; j < printChart[0].length; j++){
                if(chart[i][j] == INFINITE)
                    System.out.print("- ");
                else
                    System.out.print(printChart[i][j]+ " ");
            }
            System.out.println();
        }
        System.out.println();
    }


}
