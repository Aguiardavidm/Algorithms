public class ExplicitFib
{
    public static void main(String[] args)
    {
        double root5 = Math.sqrt(5);

        double c = (1+root5)/2;
        double d = (1-root5)/2;
        double a = c/root5;
        double b = -d/root5;

        double cn = 1, dn = 1;  // cn = c^n, dn = d^n
        int n = 0;
        while( n < 100 )
        {
            System.out.println( n + ":  " + ( a*cn + b*dn ) );
            cn *= c;
            dn *= d;
            n++;
        }
    }

}