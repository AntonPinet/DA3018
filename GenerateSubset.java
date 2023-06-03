import java.util.Random;
import java.io.*;
import java.nio.file.*;

public class GenerateSubset {
    public static void main(String[] args) throws IOException {
        // Define sizes for subsets
        int[] subsetSizes = {10, 1000, 100000};

        // Create File object for source file
        File source = new File("preprocessed_data.txt");

        // Create a new Random object
        Random rand = new Random();

        // Loop over the subset sizes
        for (int subsetSize : subsetSizes) {
            // Create File object for destination file
            File destination = new File("subsetData" + subsetSize + ".txt");

            // Create a BufferedReader object to read lines from source file
            BufferedReader reader = new BufferedReader(new FileReader(source));

            // Create a BufferedWriter object to write lines to destination file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(destination))) {
                String line;
                int lineCount = 0;
                // Read lines from the source file one by one
                // Stop reading lines when either the end of the source file is reached, or when the desired subset size is reached
                while((line = reader.readLine()) != null && lineCount < subsetSize) {
                    // Assign the line just read to randomLine
                    String randomLine = line;
                    // Write randomLine to the destination file
                    writer.write(randomLine);
                    // Add a newline character to the destination file
                    writer.newLine();
                    // Increment the count of lines written to the destination file
                    lineCount++;
                }
            } finally {
                // Close the BufferedReader
                reader.close();
            }
        }
    }
}
