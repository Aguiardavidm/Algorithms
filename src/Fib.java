import java.math.BigInteger;
import java.util.Scanner;

public class Fib
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

        System.out.println("Fib at that n is " + fib(n) );
        System.out.println("Took " + count + " adds");

    }

    private static BigInteger fib( int n )
    {
        if (arrayOfValues[n]!= null)
            return arrayOfValues[n];
        if( n == 0 )
            {
            arrayOfValues[n] = BigInteger.ONE;
            return arrayOfValues[n];
            }
        else if( n == 1 )
            {
            arrayOfValues[n] = BigInteger.ONE;
            return arrayOfValues[n];
            }
        else
        {
            count = count.add( BigInteger.ONE );
            arrayOfValues[n] =  fib( n-1 ).add( fib( n-2 ) );
            return arrayOfValues[n];
        }

    }

}