import java.util.ArrayList;
import java.util.PriorityQueue;

public class Project7 {

    static int capacity;
    static int numberOfItems;
    static double items[][];
    static PriorityQueue<boundObj> priority;
    static double bestPrice;

    public static void main(String[] args) {
        generateTestValues();
        printKnapsack();
        generateNodes();
    }

    private static void generateNodes(){
        boolean isBest = false;
        while (!isBest){
            if(priority == null){
                priority = new PriorityQueue<boundObj>();
                //createNode(new ArrayList<Integer>(0));
            }
        }
    }

//    private static boundObj createNode(ArrayList<Integer> listOfItems){
//        int weight = listOfItems.stream().mapToInt(i ->(int)items[i][1]).sum();
//        int
//        while (weight < capacity)
//        boundObj node = new boundObj();
//        return node;
//    }

    private static void printKnapsack(){
        System.out.println("Capacity  of knapsack is " + capacity);
        for (int x = 1; x < numberOfItems+1; x++){
            System.out.println(x + " : " + items[x-1][0]+ " "+ items[x-1][1]);
        }
    }

    private static void generateTestValues(){
        capacity = 12;
        numberOfItems = 6;
        items = new double[][]{{100,4},{120,5},{88,4},{80,4},{54,3},{80,5}};
    }

//    private static void addPriceByWeightCol(){
//        for (int i = 0; i<items.length ; i++){
//            items[i][2] = items[i][1] / items[i][0];
//        }
//    }
}
