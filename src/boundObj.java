import java.util.ArrayList;
import java.util.Comparator;

public class boundObj implements Comparator<boundObj>{
    private int weight;
    private ArrayList<Integer> setOfItems;
    private double price;
    private double bound;
    private boundObj leftChild;
    private boundObj rightChild;
    private boundObj parent;

    public boundObj(int weight, ArrayList<Integer> setOfItems, double price, double bound) {
        this.weight = weight;
        this.setOfItems = setOfItems;
        this.price = price;
        this.bound = bound;
    }

    @Override
    public int compare(boundObj o1, boundObj o2) {
        return (int)(o1.bound - o2.bound);
    }


    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public ArrayList<Integer> getSetOfItems() {
        return setOfItems;
    }

    public void setSetOfItems(ArrayList<Integer> setOfItems) {
        this.setOfItems = setOfItems;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getBound() {
        return bound;
    }

    public void setBound(int bound) {
        this.bound = bound;
    }

    public boundObj getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(boundObj leftChild) {
        this.leftChild = leftChild;
    }

    public boundObj getRightChild() {
        return rightChild;
    }

    public void setRightChild(boundObj rightChild) {
        this.rightChild = rightChild;
    }

    public boundObj getParent() {
        return parent;
    }

    public void setParent(boundObj parent) {
        this.parent = parent;
    }
}
