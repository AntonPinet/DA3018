# Analysis of the Genome Assembly Graph

## Introduction:

This project's primary objective is to decipher and graphically represent a graph G=(V, E), which originates from genome assembly data. Each vertex denotes a DNA segment, or contig, while each edge signifies an overlap between a pair of contigs. Our goal is to distill this intricate genome assembly graph into its essential features like the node degree distribution, the count of components with a minimum of three vertices, and the distribution of component density, without losing any critical information. This streamlined representation will enable our collaborators to comprehend the data set more effectively.

## Methods:

Our analysis of this project encompassed multiple stages, including data preprocessing, graph construction, feature extraction, and data visualization. The first stage was data preprocessing, where we cleaned the data and stored it in an easily readable format, emphasizing overlaps of at least 1000 bases, described as "sufficiently large". Next, during the graph construction stage, we utilized a hashmap-based adjacency list data structure to ease the addition of edges and simplify graph-based data analysis. The feature extraction stage involved calculating the node degree distribution, the count of components with a minimum of three vertices, and the component density distribution. Ultimately, the visualization stage displayed these findings in histogram form.

## Results:

To manage the substantial genomic data, we utilized "java -Xss1G -Xms7G BuildGraphFromPreprocessedData", which helped us build the graph and ascertain essential metrics. The total count of vertices was 7,960,435, while the total number of edges was 31,981,447, and the total count of connected components with at least three vertices was 661,678. The node degree distribution of G was successfully extracted and stored in 'node_degree_distribution.csv'. The component count of G with a minimum of three vertices was found to be 661,678. Lastly, a histogram displaying the component density distribution was generated, showing the ratio of actual edges to possible edges. The density results were stored in 'densities.txt'. These findings make the genomic graph more comprehensible and help simplify it without losing any crucial data. 

The histogram images below was the output of "Visualize_data.py" displying the results.

![Node Degree Distribution Histogram](node_degree_distribution.png)
![Component Density Distribution Histogram](component_density_distribution.png)




## Discussion


The successful implementation of our genome assembly program rested heavily on our choice of algorithms and data structures. Central to this was the use of the Depth-First Search (DFS) algorithm and the data structures of HashMap, ArrayList, and Arrays. These tools provided the basis for the efficient execution and effective performance of the program.


DFS, a prominent algorithm taught in our course, was central to our graph traversal mechanism. It offered an efficient means to explore the graph deeply and to identify connected components that contain at least three vertices. The algorithm's time complexity is O(V+E), where V is the number of vertices, and E is the number of edges. Given that our application involved dealing with large genomic data, DFS ensured that only meaningful genomic segments were considered for subsequent analysis, helping us manage the computational load effectively.


However, DFS does have its limitations. For instance, it is not well-suited for solving shortest path problems in weighted graphs. But since our objective was to identify connected components rather than finding shortest paths, DFS was an appropriate choice.


The DFS implementation was complemented by our judicious use of data structures - namely HashMaps, ArrayLists, and Arrays. HashMaps provided an efficient way to store and retrieve vertex-edge associations in the graph, significantly contributing to the performance of the DFS algorithm. The constant-time complexity for get and put operations in a HashMap ensured that the retrieval and storage of vertices and their corresponding edges were done swiftly, allowing us to maintain the overall efficiency of the DFS traversal.


ArrayLists were instrumental in dynamically storing the vertices visited during the DFS. Their dynamic nature, along with the constant-time complexity for the add operation, made ArrayLists a preferable choice over traditional arrays for this application. They also enabled us to keep track of the count of vertices in each component, which was crucial in identifying components with at least three vertices.


Arrays were also a crucial part of our program, especially when dealing with static data. The usage of arrays, particularly multi-dimensional ones, helped us efficiently store and access various preprocessed genomic data. Their constant-time access was advantageous, but we had to be cautious about memory usage due to the static nature of arrays.


Reflecting on our usage of these algorithms and data structures, it becomes clear that they provided the necessary performance and flexibility for our specific project requirements. In the realm of bioinformatics, where data can be vast and complex, such thoughtful design decisions are essential to achieving both analytical depth and computational efficiency. Through this project, we have learned the importance of not only selecting the appropriate algorithm and data structures but also understanding their potential limitations and trade-offs when applied to real-life datasets.

## Conclusion:

This project effectively processed a genome assembly data set, constructed a graph using the processed data, distilled meaningful features like node degree distribution and component density distribution, and visualized these distributions. 

