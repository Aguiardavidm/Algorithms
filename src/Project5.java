public class Project5 {

    private static String gene1 = "TAAGGTCA";
    private static String gene2 = "AACAGTTACC";
    private static String DASH = "-";
    private static String[][] chart;

    public static void main(String[] args) {
        chart = buildChart();
    }

    private static String[][] buildChart(){
        return new String[gene1.length()+1][gene2.length()+1];
    }

    private static void fillChart(String[][] chartToFill){

    }
}
