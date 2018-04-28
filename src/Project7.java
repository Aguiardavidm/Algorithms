import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Project7 {

    static int capacity;
    static int numberOfItems;
    static double items[][];
    static PriorityQueue<boundObj> priority;
    static double bestPrice;

    public static void main(String[] args) {
        generateTestValues();
        addPriceByWeightCol();
        printKnapsack();
        generateNodes();
    }

    private static void generateNodes(){
        boolean isBest = false;
        while (!isBest){
            if(priority == null){
                priority = new PriorityQueue<boundObj>();
                priority.add(new boundObj(0,null,0,getBound(null,null,0,0)));

            }
        }
    }

    private static boundObj createNode(ArrayList<Integer> listOfItems, ArrayList<Integer> exclude){
        double weight = listOfItems.stream().mapToDouble(i -> items[i][1]).sum();
        double price = listOfItems.stream().mapToDouble(i -> items[i][0]).sum();
        double bound = getBound(listOfItems, exclude, weight, price);
        boundObj node = new boundObj(weight, listOfItems, price, bound);
        printNode(node);
        return node;
    }

    private static double getBound(ArrayList<Integer> listOfItems, ArrayList<Integer> exclude, double weight, double price) {
        double counter = 0;
        if(weight<capacity) {
            while (counter < numberOfItems) {
                if(listOfItems != null && listOfItems.contains(counter) ){
                    counter ++;
                }
                else if(exclude!= null && exclude.contains(counter)){
                counter++;
                }
                else if(weight < capacity){
                    if(weight + items[(int)counter][1] > capacity){
                        price += items[(int)counter][2]*(capacity-weight);
                        weight = capacity;
                        counter = numberOfItems;
                    }
                    else {
                        price += items[(int)counter][0];
                        weight += items[(int)counter][1];
                    }
                }
                counter++;
            }
        }
        return price;
    }

    private static void printNode(boundObj boundO){
        System.out.println("Created Node with weight "+boundO.getWeight()+" Items "+boundO.getSetOfItems()+
                " Price "+boundO.getPrice()+" bound "+boundO.getBound());
    }


    private static void printKnapsack(){
        System.out.println("Capacity  of knapsack is " + capacity);
        for (int x = 1; x < numberOfItems+1; x++){
            System.out.println(x + " : " + items[x-1][0]+ " "+ items[x-1][1] + " " + items[x-1][2]);
        }
    }

    private static void generateTestValues(){
        capacity = 12;
        numberOfItems = 6;
        items = new double[][]{{100,4,0},{120,5,0},{88,4,0},{80,4,0},{54,3,0},{80,5,0}};
    }

    private static void addPriceByWeightCol(){
        for (int i = 0; i<items.length ; i++){
            items[i][2] = items[i][0] / items[i][1];
        }
    }

    private static void sortByPricePerWeight(){

    }
}
