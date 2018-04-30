import java.util.Comparator;

public class boundObjComparator implements Comparator<boundObj> {
    @Override
    public int compare(boundObj o1, boundObj o2) {
        return (int)(o1.getBound() - o2.getBound());
    }
}
