package problem3;

/**
 *
 * @author cgallinaro
 */
public class Problem3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        int gradesArray[][]={ //Declare variables
        { 56 , 38 , 38 , 88 , 52 , 42 },
        { 85 , 35 , 91 , 94 , 60 , 47 },
        { 78 , 62 , 70 , 42 , 93 , 65 },
        { 33 , 75 , 82 , 45 , 73 , 83 },
        { 60 , 80 , 71 , 82 , 73 , 38 },
        { 80 , 55 , 48 , 59 , 36 , 80 },
        { 30 , 91 , 79 , 81 , 61 , 61 },
        { 47 , 54 , 68 , 64 , 73 , 65 },
        { 32 , 54 , 84 , 52 , 64 , 80 },
        { 82 , 82 , 39 , 65 , 48 , 41 },
        { 65 , 81 , 81 , 38 , 93 , 86 },
        { 44 , 74 , 64 , 61 , 58 , 77 },
        { 31 , 31 , 44 , 93 , 52 , 94 }};
        double[] studentAverage = new double[gradesArray.length];
        double[] testAverage = new double[gradesArray[0].length];
        double classAverage, sum;
        
        for (int i = 0; i < gradesArray.length; i++) //Loop to get student averages
        {
            sum = 0;
            for (int j = 0; j < gradesArray[0].length; j++) //Runs through the entire row to get the sum
            {
                sum += gradesArray[i][j];
            }
            studentAverage[i] = sum /(double)gradesArray[0].length; //Divides to calculate average
        }
        
        for (int i = 0; i < gradesArray[0].length; i++) //Similar loop to get test averages
        {
            sum = 0;
            for (int j = 0; j < gradesArray.length; j++) //Runs through the entire column to get the sum
            {
                sum += gradesArray[j][i];
            }
            testAverage[i] = sum / (double)gradesArray.length; //Divides to calculate average
        }
        
        sum = 0;
        for (int i = 0; i < testAverage.length; i++) //Uses test averages to get the overall average (studentAverage would also work because everything is weighted equally)
        {
            sum += testAverage[i];
        }
        classAverage = sum / (double)testAverage.length;
        
        //Printing chart
        System.out.printf("%-15s", "Name"); //Name header
        for (int i = 1; i <= testAverage.length; i++) //Test headers
        {
            System.out.printf("%-5s%-3d", "Test ", i);
        }
        System.out.printf("%7s", "Average"); //Average header
        System.out.println();
        
        System.out.printf("%-15s", "-------------"); //Hyphen separators
        for (int i = 1; i <= testAverage.length; i++)
        {
            System.out.printf("%-8s", "------");
        }
        System.out.printf("%7s", "-------");
        System.out.println();
        
        for (int i = 1; i <= studentAverage.length; i++) //Loop for the main body of the chart, prins one row for every student
        {
            System.out.printf("%-8s%-7d", "Student ", i); //Student number
            for (int j = 1; j <= testAverage.length; j++)
            {
                System.out.printf("%6d", gradesArray[i-1][j-1]); //Student's grade for each test
                System.out.print("  ");
            }
            System.out.printf("%7.2f", studentAverage[i-1]); //Student's average
            System.out.println();
        }
        System.out.println();
        
        System.out.printf("%-15s", "Test Average"); //Test Averages
        for (int i = 1; i <= testAverage.length; i++)
        {
            System.out.printf("%6.1f", testAverage[i-1]); //Each individual average
            System.out.print("  ");
        }
        System.out.println();
        System.out.println();
        System.out.print("Class Average: "); //Class average
        System.out.printf("%.1f", classAverage);
    }
    
}
