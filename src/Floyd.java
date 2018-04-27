import java.util.Scanner;

/**
 * @author chris Spaulding
 */
public class Floyd {


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Floyd driver = new Floyd();
        data[][] map = driver.getInput();
        driver.Floyd(map, map.length);
        driver.print(map, map.length);
    }


    private void print(data[][] x, int size) {
        String text = "";
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                text = text + x[i][j] + "    ";
            }
            text = text + "\n";
        }
        System.out.println(text);
    }


    private data[][] getInput() {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter the number of nodes.");
        int nodes = in.nextInt();
        data[][] nodeMap = new data[nodes][nodes];
        System.out.println("enter the the weits row by row and column by column \n "
                + "with -1 to indicate no edge");
        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++) {
                data temp = new data(in.nextInt());
                nodeMap[i][j] = temp;
            }
        }
        return nodeMap;
    }

    public data[][] Floyd(data[][] map, int size) {
        for (int bridge = 0; bridge < size; bridge++) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    int temp = checkAlt(map, bridge, i, j);
                    map[i][j].setValue(temp);
                }
            }
        }
        return map;
    }

    private int checkAlt(data[][] map, int bridge, int i, int j) {
        int current = map[i][j].value;
        int leg1 = map[i][bridge].value;
        int leg2 = map[bridge][j].value;
        int newPath = leg1 + leg2;
        if (leg2 == -1 || leg1 == -1) {
            return current;
        }
        if (current == -1) {
            map[i][j].setPath(bridge);
            return newPath;
        } else {
            if (current < newPath) {
                return current;
            } else {
                map[i][j].setPath(bridge);
                return newPath;
            }
        }

    }

    private class data {
        int value;
        int path;

        data() {
            value = -1;
        }

        data(int v) {
            value = v;
            path = 0;
        }

        void setPath(int x) {
            path = x;
        }

        void setValue(int x) {
            value = x;
        }

        @Override
        public String toString() {
            return "Value: " + value + " path: " + path;
        }
    }

}
