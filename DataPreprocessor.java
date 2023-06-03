import java.io.*;
import java.util.*;

public class DataPreprocessor {
    // Map to store the relation between original identifiers and integer identifiers
    private HashMap<String, Integer> identifierMap;

    // Counter to create unique integer identifiers
    private int identifierCounter;

    public DataPreprocessor() {
        this.identifierMap = new HashMap<>();
        this.identifierCounter = 0;
    }

    // Method to convert an original identifier into an integer identifier
    private int getIntegerIdentifier(String originalIdentifier) {
        // If the identifier is new, store it in the map with a new integer identifier
        if (!identifierMap.containsKey(originalIdentifier)) {
            identifierMap.put(originalIdentifier, identifierCounter);
            identifierCounter++;
        }
        // Return the integer identifier associated with the original identifier
        return identifierMap.get(originalIdentifier);
    }

    // Method to preprocess the data
    public void preprocessData(String inputFilePath, String outputFilePath) throws IOException {
        // Create a BufferedReader to read the input file
        BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
        // Create a BufferedWriter to write the preprocessed data into the output file
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath));
        String line;
        // Read the input file line by line
        while ((line = reader.readLine()) != null) {
            // Split each line into tokens
            String[] tokens = line.split("\\s+");
            // Convert the original identifiers into integer identifiers
            int v1 = getIntegerIdentifier(tokens[0]);
            int v2 = getIntegerIdentifier(tokens[1]);
            // Parse the other columns of the line
            int start1 = Integer.parseInt(tokens[5]);
            int end1 = Integer.parseInt(tokens[6]);
            int start2 = Integer.parseInt(tokens[9]);
            int end2 = Integer.parseInt(tokens[10]);

            // Calculate the overlap lengths
            int overlapLength1 = end1 - start1;
            int overlapLength2 = end2 - start2;

            // Check if the overlap is 'sufficiently large' in both sequences
            if (overlapLength1 >= 1000 && overlapLength2 >= 1000) {
                // Write the preprocessed data into the output file
                writer.write(String.format("%d %d %d %d %d %d\n", v1, v2, start1, end1, start2, end2));
            }
        }
        // Close the BufferedReader and the BufferedWriter
        reader.close();
        writer.close();
    }

    // Main method to test the DataPreprocessor
    public static void main(String[] args) throws IOException {
        DataPreprocessor preprocessor = new DataPreprocessor();
        // Preprocess the data
        preprocessor.preprocessData("Spruce_fingerprint_2017-03-10_16.48.olp.m4", "preprocessed_data.txt");
    }
}
