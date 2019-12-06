package problem5;
import java.io.*;
import java.util.*; 
/**
 *
 * @author cgallinaro
 */
public class Problem5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        try
        {
            BufferedReader br = null; //Declare variables
            File file = new File("Teacher data Windows.txt");
            br = new BufferedReader(new FileReader("Teacher data Windows.txt"));
            String[][] teacherData = new String[50][3];
            String currentLine = "";
            StringTokenizer split = new StringTokenizer("");
            int mathYears = 0, scienceYears = 0, techYears = 0, mathTeacherCount = 0, scienceTeacherCount = 0, techTeacherCount = 0, totalYears = 0, totalTeacherCount = 0;
            
            for (int i = 0; i < 50; i++) //Loop to read file and set teacher data
            {
                currentLine = br.readLine();
                if (currentLine == null)
                {
                    break;
                }
                split = new StringTokenizer(currentLine);
                teacherData[i][0] = split.nextToken();
                teacherData[i][1] = split.nextToken();
                teacherData[i][2] = split.nextToken();

            }
            br.close();
            
            for (int i = 0; i < 50; i++) //Reads through the teacherData array
            {
                if (teacherData[i][1].equals("math") || teacherData[i][1].equals("science") || teacherData[i][1].equals("tech"))
                {
                    totalTeacherCount++;
                    totalYears += Integer.parseInt(teacherData[i][2]);
                }
                if (teacherData[i][1].equals("math")) //If the teacher teaches math, add value to the corresponding variables
                {
                    mathTeacherCount++;
                    mathYears += Integer.parseInt(teacherData[i][2]);
                }
                if (teacherData[i][1].equals("science")) //If the teacher teaches science, add value to the corresponding variables
                {
                    scienceTeacherCount++;
                    scienceYears += Integer.parseInt(teacherData[i][2]);
                }
                if (teacherData[i][1].equals("tech")) //If the teacher teaches tech, add value to the corresponding variables
                {
                    techTeacherCount++;
                    techYears += Integer.parseInt(teacherData[i][2]);
                }
            }
            
            double averageMathYears = mathYears / (double)mathTeacherCount; //Calculate averages
            double averageScienceYears = scienceYears / (double)scienceTeacherCount;
            double averageTechYears = techYears / (double)techTeacherCount;
            double averageTotalYears = totalYears/ (double)totalTeacherCount;
            
            System.out.printf("%-1s%-1.2f%-1s", "Average teaching experience of math teachers: ", averageMathYears, " years"); //Print result
            System.out.println();
            System.out.printf("%-1s%-1.2f%-1s", "Average teaching experience of science teachers: ", averageScienceYears, " years");
            System.out.println();
            System.out.printf("%-1s%-1.2f%-1s", "Average teaching experience of tech teachers: ", averageTechYears, " years");
            System.out.println();
            System.out.printf("%-1s%-1.2f%-1s", "Average teaching experience of math, science, and tech teachers: ", averageTotalYears, " years");
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    }
}
