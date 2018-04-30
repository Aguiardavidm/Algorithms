import java.util.*;

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
        Integer counter = 0;
        do {
            if(priority == null){
                priority = new PriorityQueue<boundObj>(11,new boundObjComparator());
                boundObj first = new boundObj(0, new ArrayList<Integer>(),new ArrayList<Integer>(),0,
                        getBound(null,null,0,0));
                priority.add(first);
                printNode(first);
            }
            boundObj current = priority.peek();

            ArrayList<Integer> addList = new ArrayList<Integer>(current.getSetOfItems());
            ArrayList<Integer> addExclude = new ArrayList<Integer>(current.getExcludes());

            try {
                counter = Math.max(Collections.max(addList), Collections.max(addExclude)) + 1;
            }catch(NoSuchElementException e){
                if(addList.isEmpty()) {
                    if (addExclude.isEmpty()) {
                        counter++;
                    }
                    else {
                        counter = Collections.max(addExclude) + 1;
                    }
                }
                else {
                    counter = Collections.max(addList)+ 1;
                }
            }

            if(!addList.contains((Integer)6) && !addExclude.contains((Integer)6)) {
                addList.add(counter);
                current.setRightChild(createNode(addList, current.getExcludes()));

                addExclude.add(counter);
                current.setLeftChild(createNode(current.getSetOfItems(), addExclude));

                isBest = addChildrenToPriority(current.getRightChild());
                isBest = isBest || addChildrenToPriority(current.getLeftChild());
            }
            else{
                priority.poll();
            }

        } while (!isBest);
    }

    private static boolean addChildrenToPriority(boundObj child){
        if(child.getWeight() > capacity) {
            return false;
        }
        else if (child.getBound() == child.getPrice()){
            priority.add(child);
            return true;
        }
        priority.add(child);
        return false;
    }

    private static boundObj createNode(ArrayList<Integer> listOfItems, ArrayList<Integer> exclude){
        double weight = listOfItems.stream().mapToDouble(i -> items[i-1][1]).sum();
        double price = listOfItems.stream().mapToDouble(i -> items[i-1][0]).sum();
        double bound = getBound(listOfItems, exclude, weight, price);
        boundObj node = new boundObj(weight, listOfItems,exclude, price, bound);
        printNode(node);
        return node;
    }

    private static double getBound(ArrayList<Integer> listOfItems, ArrayList<Integer> exclude, double weight, double price) {
        double counter = 0.0;
        if(weight<capacity) {
            while (counter < numberOfItems+1) {
                if(listOfItems != null && listOfItems.contains(counter) ){
                    counter ++;
                }
                else if(exclude!= null && exclude.contains(counter)){
                counter++;
                }
                else if(weight < capacity){
                    if(weight + items[(int)counter][1] > capacity){
                        price += items[(int)counter][2]*(items[(int)counter][1]-(capacity-weight));
                        weight = capacity;
                        counter = numberOfItems;
                    }
                    else {
                        weight += items[(int)counter][1];
                        price += items[(int)counter][0];
                    }
                }
                counter++;
            }
        }
        return price;
    }

    private static void printNode(boundObj boundO){
        System.out.println("Created Node with weight "+boundO.getWeight()+" Items "+boundO.getSetOfItems()+
                " Excludes "+ boundO.getExcludes()+" Price "+boundO.getPrice()+" bound "+boundO.getBound() + "\n");
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

    public int compare(boundObj o1, boundObj o2) {
        return (int)(o1.getBound() - o2.getBound());
    }
}
