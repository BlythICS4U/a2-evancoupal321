/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem4;
import java.io.*;
import java.util.*;
/**
 *
 * @author cgallinaro
 */
public class Problem4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        try
        {
            File inputFile = new File("myTextWindows.txt"); //Declare Variables
            File outputFile = new File("myTextData.txt");
            if (!outputFile.exists())
            {
                outputFile.createNewFile();
            }
            BufferedReader br = new BufferedReader(new FileReader("mytextWindows.txt"));
            PrintWriter pw = new PrintWriter (new BufferedWriter(new FileWriter("mytextData.txt", false)));
            String fileLine = " ", fileText = "";
            int wordCount, lineCount = 0, characterCount = 0;
            double averageLength;
            String longestWord = "", currentWord = "";
            
            fileLine = br.readLine(); //Loop that counts lines
            while (fileLine != null) 
            {
                fileText = fileText + fileLine + " ";
                fileLine = br.readLine();
                lineCount++;

            }
            
            StringTokenizer fileWords = new StringTokenizer(fileText);
            wordCount = fileWords.countTokens(); //Word count
            while (fileWords.hasMoreTokens()) //Loop through each word, used to get longest word and calculate sum of word lengths
            {
                currentWord = fileWords.nextToken();
                if (currentWord.length() > longestWord.length())
                {
                    longestWord = currentWord;
                }
                characterCount += currentWord.length();
            }
            averageLength = characterCount / (double)wordCount; //Uses word count to get average word length
            
            pw.println("The file \"" + inputFile + "\" was successfully read.\n"); //Print results to file
            pw.printf("%-21s%-5d", "Number of words: ", wordCount);
            pw.println();
            pw.printf("%-21s%-5d", "Number of lines: ", lineCount);
            pw.println();
            pw.printf("%-21s%-5s", "Longest word: ", longestWord);
            pw.println();
            pw.printf("%-21s%-5d", "Longest word length: ", longestWord.length());
            pw.println();
            pw.printf("%-21s%-5.1f", "Average word length: ", averageLength);
            pw.close();
            
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    }   
}