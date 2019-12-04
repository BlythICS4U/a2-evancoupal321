package problem1;
import java.util.Scanner;
/**
 *
 * @author cgallinaro
 */
public class Problem1 {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        double x, y, f, g, h, i, j; //Declare variables
        
        System.out.println("Enter a value for x."); //Set values
        x = scan.nextDouble();
        System.out.println("Enter a value for y.");
        y = scan.nextDouble();
        
        f = getF(x); //Methods for calculation
        g = getG(x);
        h = getH(x);
        i = getI(x);
        j = getJ(x, y);
        
        System.out.println("f(x) = " + f); //Print Result
        System.out.println("g(x) = " + g);
        System.out.println("h(x) = " + h);
        System.out.println("i(x) = " + i);
        System.out.println("j(x) = " + j);
        
    }
    
    public static double getF(double x) //Calculations
    {
        return Math.sqrt(x-1);
    }
    public static double getG(double x)
    {
        return x*x*x - 2*x*x + x - 4;
    }
    public static double getH(double x)
    {
        return Math.pow(Math.sin(x), 2);
    }
    public static double getI(double x)
    {
        return Math.pow(Math.sin(Math.toRadians(x)), 2);
    }
    public static double getJ(double x, double y)
    {
        return Math.pow(x, 2) + Math.pow (y, 2);
    }
    
}
