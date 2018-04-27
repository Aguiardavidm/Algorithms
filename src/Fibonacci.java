import java.math.BigInteger;

public class Fibonacci
{
    public static void main(String[] args)
    {
        BigInteger fn, fn1, fn2;

        fn1 = BigInteger.ONE;
        fn2 = BigInteger.ONE;

        System.out.println("0:  1\n" );
        System.out.println("1:  1\n" );

        BigInteger n = new BigInteger( "2" );

        while( true )
        {
            fn = fn1.add( fn2 );  // fn = fn1 + fn2
            System.out.println( n + ": " + fn + "\n" );
            fn2 = fn1;
            fn1 = fn;
            n = n.add( BigInteger.ONE );
        }
    }

}