import java.math.BigInteger;
import java.util.Scanner;

public class Fib2
{
    public static BigInteger count = BigInteger.ZERO;
    public static BigInteger[] arrayOfValues;
    public static void main(String[] args)
    {
        int n;
        System.out.print("Enter n for which you want Fib(n) computed: ");
        Scanner keys = new Scanner( System.in );
        n = keys.nextInt();
        arrayOfValues = new BigInteger[n+1];
        arrayOfValues[0] = BigInteger.ONE;
        arrayOfValues[1] = BigInteger.ONE;
        for (int i = 2; i < n+1; i++){
            arrayOfValues[i] = arrayOfValues[i-2].add(arrayOfValues[i-1]);
            count = count.add(BigInteger.ONE);
        }

        System.out.println("Fib at that n is " + arrayOfValues[n] );
        System.out.println("Took " + count + " adds");

    }

}