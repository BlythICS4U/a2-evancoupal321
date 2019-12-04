package problem2;
import java.util.Scanner;
/**
 *
 * @author cgallinaro
 */
public class Problem2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in); //Declare/set variables
        System.out.println("Enter the number you would like to check up to.");
        int size = scan.nextInt();
        boolean[] primes = new boolean[size+1];
        for (int i = 0; i < primes.length; i++)
        {
            primes[i] = true;
        }
        
        //Loop to set non-primes to false
        for (int i = 2; i <= Math.sqrt(size); i++) //Runs through every number up to the squre root of size
        {
            for(int j = i+1; j <= size; j++) //Checks if every number larger than i is a multiple of i
            {
                if (j%i == 0)
                {
                    primes[j] = false;
                }
            }
        }
        
        //Print result
        int rowPos = 1;
        System.out.println("All primes less than or equal to " + size + " are:");
        for (int i = 2; i <= size; i++) //Checks every number up to size
        {
            if (primes[i])
            {
                System.out.printf("%-8d", i); //Prints the number if it is prime
                rowPos++;
                if (rowPos > 10) //Moves to the next row for there are 10 numbers in the row
                {
                    System.out.println();
                    rowPos = 1;
                }
            }
        }
    }
}