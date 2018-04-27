import java.util.Scanner;

public class Project4 {

    static int[][] chart;

    public static void main(String[] args) {
        //getInput();
        chart = new int[][]
                    {{0,1,-1,1,5},
                    {9,0,3,2,-1},
                    {-1,-1,0,4,-1},
                    {-1,-1,2,0,3},
                    {3,-1,-1,-1,0}};
        printChart(chart);
        fillChart(5);
        printChart(chart);
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
                System.out.print(printChart[i][j]+ " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void fillChart(int verticies){
        for (int i = 0; i<verticies;i++){
            for(int j = 0; j < verticies;j++){
                for(int k = 0; k < verticies; k++){
                    if (chart[j][i] + chart[i][k] < chart[j][k]|| chart[j][k] == -1){
                        chart[j][k] = chart[j][i] + chart[i][k];

                    }
                }
            }
        }
    }
}
