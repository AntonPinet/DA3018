# Lab Notebook for DA3018 project

## By: [Anton Pinet Magnusson]

## Date: Start from 2023-05-27

## Project Description:
The project aims to analyze, visualize, and understand a graph G=(V, E) generated from a genome assembly data set. Each vertex in this graph represents a DNA segment, also known as a contig, while an edge signifies an overlap between two contigs. The goal is to extract features from this graph, such as node degree distribution, number of components with at least three vertices, and component density distribution, to help an imaginary collaborator better understand the dataset. The ultimate aim is to simplify the graph for standard genome assembly tools without losing crucial data. 

## Day 1 - 2023-05-27

**Activities:**
1. Project initiation: Understood the project requirements and the provided set.

2. Studied the genome assembly process and the significance of contigs and their overlaps.

3. We make an overall plan for the projekt. The overall steps in completing the project consists of 
-  Making scripts for data cleaning and reading.
-  Analysing the data once it is clean.
-  Buldning the overlaps graph.
-  Analysing the the graph to answer the questions possed in the assignment abou the graph.
-  Writing a report displaying the results of the project.
4. Since we are dealing with a massive data file we need to find a way to clean and extract the useful data and make it ready for processing. This will be where the we start the project. We will write a data processing program to clean the data and store it in a readable file. 

**Outcomes:**
1. The requirements have been read through and the data format has been understood as describing the details of contig overlaps in genome sequencing data. Specifically, each line in the dataset represents a pair of contigs that overlap, along with the start, end, and length of the overlapping region for each contig. The identifiers for each contig are also provided. This data is crucial for assembling the entire genome sequence from the given contigs by understanding their overlapping regions.
2. The identified computational problems to be solved are:
 -  Find node Degree Distribution.
 -  Find number of Components with At Least Three Vertices.
 -  Find component Density Distribution.
3. The java program "DataPreprocessor.java" has been created to clean the data. The code reads the genome data from the input file, processes it, and writes the preprocessed data into the output file. The preprocessed data consists of integer identifiers for the contigs and the respective start, end, and length information. The outcome facilitates downstream tasks in the genome assembly project by providing cleaned, structured, and consistent data. 

## Day 2 - 2023-05-28

**Tasks Undertaken:**
1. Today's efforts were concentrated on constructing a graph representation from the preprocessed genome assembly dataset. The goal is to provide a more intimate understanding of the intricacies of the dataset by visualizing its structure in the form of a graph.
2. We formulated an 'Edge' class to symbolize the connections in the graph. Each 'Edge' object holds the information about a pair of overlapping contigs, inclusive of the start, end, and the span of the overlap for each contig. This detail is instrumental in decoding the relationships and structure within the dataset.
3. We also devised a 'Graph' class that embodies the entire graph, designed as an adjacency list. It is a HashMap where each key is a vertex (an integer), and the corresponding value is a list of edges that originate from that vertex. This kind of data structure facilitates easy addition of edges and simplifies our approach towards data analysis in a graph-based environment.
4. We implemented the 'BuildGraphFromPreprocessedData' class that ingests the preprocessed dataset, builds the graph, and computes and records the degree of each node in the graph.

**Results:**
1. We produced the 'BuildGraphFromPreprocessedData.java' Java program to construct a graph from the preprocessed data. The program reads the preprocessed data from a file, constructs the graph, and calculates the degree of each node. A node's degree is the count of edges connected to it, which gives valuable insights into the importance of the node in the structure of the graph.
2. The program also writes the degree distribution (the frequency of each degree) into a CSV file. This information will aid in understanding the node degree distribution of the graph, a fundamental attribute of a graph, which can reveal insights about the overall structure of the graph and the characteristics of the genome assembly.
3. The test run of the program successfully built the graph from the preprocessed data and calculated the node degree distribution. It outputted the message "Successfully built the graph from preprocessed data." as expected.
4. The future tasks include continuing the graph-based analyses, specifically computing the count of components with at least three vertices and the component density distribution. Today's progress sets a solid groundwork for these upcoming tasks.


## Day 3 - 2023-05-31

**Planned Activities:**

1. **Generate Smaller Datasets:** Our first task for the day will be to generate smaller subsets from our preprocessed data file. This will provide us with datasets of varying sizes, perfect for initial testing of our `BuildGraphFromPreprocessedData.java` program.

2. **Test BuildGraphFromPreprocessedData.java:** Post dataset generation, we plan to run our `BuildGraphFromPreprocessedData.java` program on these subsets. This should allow us to evaluate the program's functionality and efficiency in constructing the graph and computing the node degree distribution.

3. **Develop Component-Identifying Algorithm:** After testing, our goal is to begin the development of a new feature in `BuildGraphFromPreprocessedData.java`, an algorithm that identifies the components of the graph G with at least three vertices. For this, we intend to use a depth-first search algorithm.

4. **Start Work on Density Distribution:** Once we have the component-identifying algorithm set up, we plan to start work on finding the density distribution of the components. Our initial step will be to study the properties of density in graph theory to inform the design of our algorithm.

**Expected Outcomes:**

1. A collection of smaller datasets derived from our preprocessed data file for testing and analysis.

2. Preliminary evaluation of `BuildGraphFromPreprocessedData.java`'s ability to build a graph and calculate the node degree distribution.

3. The first draft of our algorithm for finding components of the graph G with at least three vertices.

4. Initiated exploration into graph density to guide our approach for determining the component density distribution, one of the three computational problems we identified at the start of the project.

