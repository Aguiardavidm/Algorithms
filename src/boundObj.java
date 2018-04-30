import java.util.ArrayList;
import java.util.Comparator;

public class boundObj implements Comparator<boundObj> {
    private double weight;
    private ArrayList<Integer> setOfItems;
    private ArrayList<Integer> excludes;
    private double price;
    private double bound;
    private boundObj leftChild;
    private boundObj rightChild;
    private boundObj parent;

    public boundObj(double weight, ArrayList<Integer> setOfItems, ArrayList<Integer> excludes, double price, double bound) {
        this.weight = weight;
        this.setOfItems = setOfItems;
        this.excludes = excludes;
        this.price = price;
        this.bound = bound;
    }

    @Override
    public int compare(boundObj o1, boundObj o2) {
        return (int)(o1.bound - o2.bound);
    }

    double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    ArrayList<Integer> getSetOfItems() {
        return setOfItems;
    }

    public void setSetOfItems(ArrayList<Integer> setOfItems) {
        this.setOfItems = setOfItems;
    }

    public ArrayList<Integer> getExcludes() {
        return excludes;
    }

    public void setExcludes(ArrayList<Integer> excludes) {
        this.excludes = excludes;
    }

    double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    double getBound() {
        return bound;
    }

    public void setBound(int bound) {
        this.bound = bound;
    }

    public boundObj getLeftChild() {
        return leftChild;
    }

    void setLeftChild(boundObj leftChild) {
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
