import java.io.*;
import java.util.*;

// Define a class Edge to represent an edge in the graph
class Edge {
    int v1, v2, start1, end1, length1, start2, end2, length2;

    // This is the constructor of the Edge class
    public Edge(int v1, int v2, int start1, int end1, int length1, int start2, int end2, int length2) {
        this.v1 = v1;
        this.v2 = v2;
        this.start1 = start1;
        this.end1 = end1;
        this.length1 = length1;
        this.start2 = start2;
        this.end2 = end2;
        this.length2 = length2;
    }
}

// Define a class Graph to represent the graph
class Graph {
    HashMap<Integer, ArrayList<Edge>> adjacencyList = new HashMap<>();

    // Method to add an edge to the graph
    public void addEdge(Edge e) {
        if (!adjacencyList.containsKey(e.v1)) {
            adjacencyList.put(e.v1, new ArrayList<>());
        }
        adjacencyList.get(e.v1).add(e);
    }
}

// Define the main class
public class BuildGraphFromPreprocessedData {
    public static void main(String[] args) throws IOException {
        // Create a BufferedReader to read the preprocessed data
        BufferedReader reader = new BufferedReader(new FileReader("preprocessed_data.txt"));
        // Create a Graph to store the graph
        Graph g = new Graph();
        String line;

        // Read the preprocessed data line by line
        while ((line = reader.readLine()) != null) {
            String[] tokens = line.split("\\s+");
            int v1 = Integer.parseInt(tokens[0]);
            int v2 = Integer.parseInt(tokens[1]);
            int start1 = Integer.parseInt(tokens[2]);
            int end1 = Integer.parseInt(tokens[3]);
            int length1 = Integer.parseInt(tokens[4]);
            int start2 = Integer.parseInt(tokens[5]);
            int end2 = Integer.parseInt(tokens[6]);
            int length2 = Integer.parseInt(tokens[7]);
            Edge e = new Edge(v1, v2, start1, end1, length1, start2, end2, length2);
            g.addEdge(e);
        }

        // Close the BufferedReader
        reader.close();

        // Count the degree of each node
        HashMap<Integer, Integer> degreeCount = new HashMap<>();
        for (Map.Entry<Integer, ArrayList<Edge>> entry : g.adjacencyList.entrySet()) {
            int degree = entry.getValue().size();
            degreeCount.put(degree, degreeCount.getOrDefault(degree, 0) + 1);
        }

        // Save the degree and frequency to a file
        PrintWriter pw = new PrintWriter(new File("node_degree_distribution.csv"));
        pw.println("Degree,Frequency");
        for (Map.Entry<Integer, Integer> entry : degreeCount.entrySet()) {
            pw.println(entry.getKey() + "," + entry.getValue());
        }
        pw.close();

        // Print success message
        System.out.println("Successfully built the graph from preprocessed data.");
    }
}
