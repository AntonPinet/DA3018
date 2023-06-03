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

## Day 4 - 2023-06-01

### Activities Undertaken:
1. **Analysis of Preliminary Results:** Upon analyzing the results of running our `BuildGraphFromPreprocessedData.java` on the smaller datasets, we noticed some inconsistencies with the expected outcomes. After a thorough examination of the preprocessing stage and the resulting graph, we discovered that there was a problem with how overlaps were treated in our data preprocessor.
2. **Diagnosis and Solution Design:** Our initial design treated overlaps of 1000 or less as non-overlaps and didn't consider them in creating edges in the graph. However, the project specification defined overlaps as "sufficiently large" if they had a length of at least 1000. This discrepancy necessitated a modification in our `DataPreprocessor.java`.
3. **Implementation of Solution:** We modified our `DataPreprocessor.java` to only consider overlaps "sufficiently large" if they have a length of at least 1000 in both sequences. This ensures that the edges in our graph only represent significant overlaps and are consistent with the project's definition.
4. **Subset Data Generation:** To support the validation of our revised preprocessing and graph generation processes, we created the `GenerateSubset.java` program. This program generates subsets of varying sizes from the original preprocessed dataset, which we can use for testing and initial evaluation without overloading our resources.

### Outcomes:
1. A significant error in data preprocessing was identified and corrected. Our revised `DataPreprocessor.java` now only considers overlaps that meet the project's definition of "sufficiently large."
2. We successfully created the `GenerateSubset.java` program to generate smaller datasets from the original preprocessed data. These smaller datasets will be invaluable for testing and validation of our revised preprocessing and graph generation processes.
3. These advancements set a solid groundwork for further analyses, specifically for the computation of the count of components with at least three vertices and the component density distribution. We plan to start the development of these features in the following days. 
4. The testing process using the smaller datasets generated from `GenerateSubset.java` has been planned for the next day. It will provide insights into the correctness and efficiency of our revised `DataPreprocessor.java` and `BuildGraphFromPreprocessedData.java`.


## Day 5 - 2023-06-02

### Activities Undertaken:

1. **Revewing the Code and Definitions:** Today, as we looked through the code again, we notised a mistake in our calculation of overlaps. Our project discription defines an overlap between two contigs as a similarity at their ends that is sufficiently large, with a length of at least 1000 in both sequences. However, in our initional implementation, we were mistakenly considering the entire length of the contig as the overlap. This oversight in our code did not align with the project's defenition of overlaps.

2. **Clarrifying the Overlap Defenition:** To fix this error, we revisited the definition of overlaps in the project. We realized that the overlap is accurately represented by the fields "Start of overlap in first contig", "End of overlap in first contig", "Start of overlap in second contig", and "End of overlap in second contig" in the data. This understanding led us to see that our previous approach was incorrect.

3. **Implementing the Correct Overlap Calculation:** Having understood the correct definition, we needed to change our `DataPreprocessor.java` to use the correct calculation of overlaps. The new implementation correctly calculates the overlaps as "end1 - start1" and "end2 - start2", and only considers overlaps that are large enough in both sequences.

### Outcomes:

1. Reviewing our code and the project definitions helped us spot an important mistake in our calculation of overlaps. This discovery was crucial for maintaining the accuracy of our project.

2. The revised `DataPreprocessor.java` now correctly calculates overlaps, making sure that only overlaps that are large enough in both sequences are considered. This correction will make sure that the graph that we construct from the preprocessed data accurately represents the overlaps between contigs.

3. This corrected accuracy is expected to have significant positive impact on our further analyses, such as node degree distribution and component density calculations, as these will now be based on more accurate overlap data.

4. Today was a productive day, we found a critical mistake and made a significant improvement in our code. Identifying the error in our overlap calculation and correcting it, ensures that our genome graph analysis is now more closely aligned with the project's definitions and goals.

Moving forward, we will work on developing methods for finding the number of components with at least three vertices and calculating the component density distribution.

## Day 6 - 2023-06-03

**Activities:**
1. **Refining Edge Class:** The Edge class was further streamlined by removing the attributes length1 and length2, which were determined to be non-essential for our graph processing tasks.

2. **Augmenting Graph Class:** Our Graph class saw a host of enhancements aimed at more efficient computation of component densities:
    - Added a max_vertex_number attribute to keep track of the largest vertex number in the graph, essential for the correct creation of the visited array in the DFS.
    - Developed a getVerticesAndEdges() method for the easy computation of total vertices and edges in the graph.
    - Crafted a calculateDensity() method that determines the density of a connected component.
    - Engineered a computeComponentDensities() method to calculate the densities of all connected components comprising at least three vertices.
    - Refined the DFS() and addEdge() methods to better support density calculations and vertex number updates.

3. **Modifying Main Method:** Revisions were made to the main method in BuildGraphFromPreprocessedData.java to accommodate changes in the Edge and Graph classes, and to facilitate the calculation and notation of component densities:
    - Adjusted the input line parsing to exclude length1 and length2, no longer present in the Edge class.
    - Included a step to print the total vertices and edges in the graph post construction.
    - Implemented a process to calculate and record densities of all connected components with a minimum of three vertices in a new "densities.txt" file.
    - Updated success messages to indicate the creation of the densities file.

4. **Data Visualization Script:** The Python script 'Visualize_data.py' was created to visualize the distributions contained in the 'node_degree_distribution.csv' and 'densities.txt' files. The script uses the matplotlib and pandas libraries to load the data, display it, and plot histograms to represent the node degree and component density distributions.

**Outcomes:**
1. The Edge class has been optimized, now containing only necessary attributes for more efficient operation and easier management.

2. The Graph class is now more versatile, with an assortment of new methods that allow for easier computation of component densities - a key feature of this project.

3. The main method in BuildGraphFromPreprocessedData.java has been upgraded to accommodate changes in the Edge and Graph classes, and now supports the computation and recording of component densities.

4. Executing the command "java -Xss1G -Xms7G BuildGraphFromPreprocessedData" successfully built the graph from preprocessed data, determined the total number of vertices in the graph (7,960,435), total number of edges in the graph (31,981,447), and total number of connected components with at least three vertices (661,678). The degree distribution was successfully written to 'node_degree_distribution.csv' and the calculated densities were written to the 'densities.txt' file. The JVM parameters -Xss1G and -Xms7G were used to increase the thread stack size to 1G and the initial heap size to 7G, respectively, to ensure sufficient memory for the program given the large size of the data being processed.

5. The 'Visualize_data.py' Python script was successfully executed, generating histograms representing the node degree and component density distributions from the 'node_degree_distribution.csv' and 'densities.txt' files respectively. Here are the histograms:

![Node Degree Distribution Histogram](node_degree_distribution.png)
![Component Density Distribution Histogram](component_density_distribution.png)

