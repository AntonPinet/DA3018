// Run java -Xss1G -Xms7G BuildGraphFromPreprocessedData
import java.io.*;
import java.util.*;

// Define a class Edge to represent an edge in the graph
class Edge {
    int v1, v2, start1, end1, start2, end2;

    // This is the constructor of the Edge class
    public Edge(int v1, int v2, int start1, int end1, int start2, int end2) {
        this.v1 = v1;
        this.v2 = v2;
        this.start1 = start1;
        this.end1 = end1;
        this.start2 = start2;
        this.end2 = end2;
    }
}

// Define a class Graph to represent the graph
class Graph {
    HashMap<Integer, ArrayList<Edge>> adjacencyList = new HashMap<>();
    int max_vertex_number = 0;  // To store the maximum vertex number

    // Method to add an edge to the graph
    public void addEdge(Edge e) {
        if (!adjacencyList.containsKey(e.v1)) {
            adjacencyList.put(e.v1, new ArrayList<>());
        }
        adjacencyList.get(e.v1).add(e);
        max_vertex_number = Math.max(max_vertex_number, Math.max(e.v1, e.v2)); // Update the maximum vertex number
    }

    // Method to calculate the total number of vertices and edges in the graph
    public int[] getVerticesAndEdges() {
        int vertices = adjacencyList.size();
        int edges = 0;
        for (ArrayList<Edge> edgeList : adjacencyList.values()) {
            edges += edgeList.size();
        }
        edges /= 2;  // As this is an undirected graph, each edge was counted twice
        return new int[]{vertices, edges};
    }

    // Method to calculate the density of a connected component
    public double calculateDensity(ArrayList<Integer> component) {
        int V = component.size();
        int E = 0;

        for (Integer vertex : component) {
            ArrayList<Edge> edges = adjacencyList.get(vertex);
            if (edges != null) {
                E += edges.size();
            }
        }

        E /= 2;  // As this is an undirected graph, each edge was counted twice

        if (V < 2) { // Check for division by zero
            return 0.0;
        }

        double density = (double) (2 * E) / (V * (V - 1));
        return density;
    }

    // Method to compute the densities of connected components with at least three vertices
    public ArrayList<Double> computeComponentDensities() {
        ArrayList<Double> densities = new ArrayList<>();

        boolean[] visited = new boolean[max_vertex_number + 1];  // Now creating the visited array based on max_vertex_number
        for (int i = 0; i <= max_vertex_number; i++) { // Looping till max_vertex_number
            if (!visited[i]) {
                ArrayList<Integer> component = new ArrayList<>();
                DFS(i, visited, component);

                if (component.size() >= 3) {
                    densities.add(calculateDensity(component));
                }
            }
        }

        return densities;
    }

    // Depth-First Search (DFS) method to find connected components
    private void DFS(int vertex, boolean[] visited, ArrayList<Integer> component) {
        visited[vertex] = true;
        component.add(vertex);

        if (adjacencyList.get(vertex) != null) {
            for (Edge e : adjacencyList.get(vertex)) {
                int adjacentVertex = (e.v1 == vertex) ? e.v2 : e.v1;
                if (!visited[adjacentVertex]) {
                    DFS(adjacentVertex, visited, component);
                }
            }
        }
    }

    // Method to compute the degree distribution
    public HashMap<Integer, Integer> computeDegreeDistribution() {
        HashMap<Integer, Integer> degreeCount = new HashMap<>();
        for (Map.Entry<Integer, ArrayList<Edge>> entry : adjacencyList.entrySet()) {
            int degree = entry.getValue().size();
            degreeCount.put(degree, degreeCount.getOrDefault(degree, 0) + 1);
        }
        return degreeCount;
    }
}

// Define the main class
public class BuildGraphFromPreprocessedData {
    public static void main(String[] args) throws IOException {
        // Create a BufferedReader to read the preprocessed data
        BufferedReader reader = new BufferedReader(new FileReader("preprocessed_data.txt"));

        // Create a Graph to store the graph
        Graph g = new Graph();

        // Variable to store each line of the file
        String line;

        // Read the preprocessed data line by line
        while ((line = reader.readLine()) != null) {
            // Split the line into tokens
            String[] tokens = line.split("\\s+");
            
            // Parse each token to its respective attribute in the Edge object
            int v1 = Integer.parseInt(tokens[0]);
            int v2 = Integer.parseInt(tokens[1]);
            int start1 = Integer.parseInt(tokens[2]);
            int end1 = Integer.parseInt(tokens[3]);
            int start2 = Integer.parseInt(tokens[4]);
            int end2 = Integer.parseInt(tokens[5]);

            // Create a new Edge object with the parsed attributes
            Edge e = new Edge(v1, v2, start1, end1, start2, end2);

            // Add the Edge object to the Graph
            g.addEdge(e);
        }

        // Close the BufferedReader
        reader.close();

        // Print success message
        System.out.println("Successfully built the graph from preprocessed data.");

        // Print the total number of vertices and edges in the graph
        int[] verticesAndEdges = g.getVerticesAndEdges();
        System.out.println("Total number of vertices in the graph: " + verticesAndEdges[0]);
        System.out.println("Total number of edges in the graph: " + verticesAndEdges[1]);

        // Compute the densities of connected components with at least three vertices
        ArrayList<Double> densities = g.computeComponentDensities();

        // Print the number of connected components with at least three vertices
        System.out.println("Number of connected components with at least three vertices: " + densities.size());

        // Create a PrintWriter to write the densities to a file
        PrintWriter writer = new PrintWriter(new FileWriter("densities.txt"));

        // Write the densities to the file
        for (double density : densities) {
            writer.println(density);
        }

        // Close the PrintWriter
        writer.close();

        // Compute the degree distribution of the graph
        HashMap<Integer, Integer> degreeCount = g.computeDegreeDistribution();

        // Create a PrintWriter to write the degree distribution to a file
        PrintWriter pw = new PrintWriter(new File("node_degree_distribution.csv"));

        // Write the header line to the file
        pw.println("Degree,Frequency");

        // Write the degree distribution to the file
        for (Map.Entry<Integer, Integer> entry : degreeCount.entrySet()) {
            pw.println(entry.getKey() + "," + entry.getValue());
        }

        // Close the PrintWriter
        pw.close();

        // Print success message
        System.out.println("Successfully wrote the degree distribution to node_degree_distribution.csv.");
    }
}
