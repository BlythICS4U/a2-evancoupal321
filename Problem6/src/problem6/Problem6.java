package problem6;
import java.io.*;
/**
 *
 * @author cgallinaro
 */
public class Problem6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        ObjectInputStream ois = null;
        try
        {
            File file = new File("myMatrices.bin"); //Read in matrices
            ois = new ObjectInputStream(new FileInputStream(file));
            int [][] matrix1 = new int[3][3];
            int [][] matrix2 = new int[3][3];
            matrix1 = (int[][]) ois.readObject();
            matrix2 = (int[][]) ois.readObject();
            ois.close();
            
            int [][] product = multiplyMatrices(matrix1, matrix2); //Multiply Matrices
            
            System.out.println("Product: "); //Print Result
            for (int i = 0; i < product.length; i++) 
            {
                for (int j = 0; j < product[0].length; j++)
                {
                    System.out.printf("%-5d", product[i][j]);
                }
                System.out.println();
            }
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
        catch (ClassNotFoundException cnfe)
        {
            cnfe.printStackTrace();
        }
    }
    
    public static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) //Method to multiply matrices
    {
        int c1 = matrix1.length; //Declare/set variables
        int r1 = matrix1[0].length;
        int c2 = matrix2.length;
        int r2 = matrix2[0].length;
        int[][] product = new int[c1][r2];
        
        if (r1 != c2) //Return empty array if the matrix cannot be multiplied
        {
            return product;
        }
        
        //Loop for the actual multiplication
        for (int i = 0; i < c1; i++) //Runs through each column of matrix1 to get the position in the columns for the product
        {
            for (int j = 0; j < r2; j++) //Runs through each row of matrix2 to get the position in the rows for the product
            {
                for (int k = 0; k < r1; k++) //Runs through the rows of matrix1 (and columns of matrix2, they are equal) to select the numbers that are being multiplied
                {
                    product[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return product; //Returns resulting product matrix
    }
    
}
